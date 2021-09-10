package com.basicmongo.service.impl;

;
import com.basicmongo.domain.Author;
import com.basicmongo.domain.model.request.AuthorCreateRequest;
import com.basicmongo.domain.model.request.AuthorUpdateRequest;
import com.basicmongo.domain.model.response.AuthorResponse;
import com.basicmongo.repository.AuthorRepository;
import com.basicmongo.service.AuthorService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {
    private AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public AuthorResponse save(AuthorCreateRequest request) {
        return convert(authorRepository.save(convert(request)));
    }

    @Override
    public AuthorResponse update(AuthorUpdateRequest request) {
        this.getById(request.getId());
        return convert(authorRepository.save(convert(request)));
    }

    @Override
    public void delete(AuthorUpdateRequest request) {
        this.getById(request.getId());
        authorRepository.deleteById(request.getId());
    }

    @Override
    public AuthorResponse getById(String id) {
        return convert(authorRepository.findById(id)
                        .orElseThrow(() -> new IllegalArgumentException()/*Wrong id*/));
    }

    @Override
    public List<AuthorResponse> getAll() {
        return authorRepository.findAll()
                .stream()
                .map(author -> convert(author))
                 .collect(Collectors.toList());
    }

    @Override
    public Page<AuthorResponse> getAll(Pageable pageable) {
        return authorRepository.findAll(pageable)
                .map(author -> convert(author));
    }

    private AuthorResponse convert(Author author){
        return AuthorResponse.builder()
                .name(author.getName())
                .id(author.getId())
                .build();
    }
    private Author convert(AuthorCreateRequest request){
        return Author.builder()
                .name(request.getName())
                .build();
    }
    private Author convert(AuthorUpdateRequest request){
        return Author.builder()
                .id(request.getId())
                .name(request.getName())
                .build();
    }
}
