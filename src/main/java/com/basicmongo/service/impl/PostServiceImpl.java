package com.basicmongo.service.impl;


import com.basicmongo.domain.Book;
import com.basicmongo.domain.Magazine;
import com.basicmongo.domain.model.convert.Convertor;
import com.basicmongo.domain.model.request.BookCreateRequest;
import com.basicmongo.domain.model.request.BookUpdateRequest;
import com.basicmongo.domain.model.request.MagazineCreateRequest;
import com.basicmongo.domain.model.request.MagazineUpdateRequest;
import com.basicmongo.domain.model.response.AsyncSavedResponse;
import com.basicmongo.domain.model.response.BookResponse;
import com.basicmongo.domain.model.response.MagazineResponse;
import com.basicmongo.domain.model.search.Search;
import com.basicmongo.repository.BookRepository;
import com.basicmongo.repository.MagazineRepository;
import com.basicmongo.service.AuthorService;
import com.basicmongo.service.PostService;
import com.basicmongo.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    private final BookRepository bookRepository;
    private final MagazineRepository magazineRepository;
    private final AuthorService authorService;
    private final PublisherService publisherService;
    private final Convertor convertor;

    public PostServiceImpl(BookRepository bookRepository,
                           MagazineRepository magazineRepository,
                           AuthorService authorService,
                           PublisherService publisherService,
                           Convertor convertor) {
        this.bookRepository = bookRepository;
        this.magazineRepository = magazineRepository;
        this.authorService = authorService;
        this.publisherService = publisherService;
        this.convertor=convertor;
    }

    @Override
    public List<Object> find(Search search) {
        if (search.getDomainName()== Search.DomainName.BOOK){
            return bookRepository.search(search).stream()
                    .map(book -> convertor.convert(book))
                    .collect(Collectors.toList());
        }else if (search.getDomainName()== Search.DomainName.MAGAZINE){
            return magazineRepository.search(search).stream()
                    .map(magazine ->convertor.convert(magazine))
                    .collect(Collectors.toList());
        }
        return null;
    }

    @Override
    public Page<Object> find(Search search, Pageable pageable) {
        if (search.getDomainName()== Search.DomainName.BOOK){
            return bookRepository.search(search,pageable)
                    .map(book -> convertor.convert(book));
        }else if (search.getDomainName()== Search.DomainName.MAGAZINE){
            return magazineRepository.search(search,pageable)
                    .map(magazine ->convertor.convert(magazine));
        }
        return null;
    }

    @Override
    public BookResponse save(BookCreateRequest request) {
        check(request.getAuthorId(),request.getPublisherId());
        return convertor.convert(bookRepository.save(convertor.convert(request)));
    }

    @Override
    public BookResponse update(BookUpdateRequest request) {
        check(request.getAuthorId(),request.getPublisherId());
        return convertor.convert(bookRepository.save(convertor.convert(request)));
    }

    @Override
    public void delete(BookUpdateRequest request) {
        bookRepository.findById(request.getId())
                .orElseThrow(() -> new IllegalArgumentException());
        bookRepository.deleteById(request.getId());
    }

    @Override
    public MagazineResponse save(MagazineCreateRequest request) {
        check(request.getAuthorId(),request.getPublisherId());
        return convertor.convert(magazineRepository.save(convertor.convert(request)));
    }

    @Override
    public MagazineResponse update(MagazineUpdateRequest request) {
        check(request.getAuthorId(),request.getPublisherId());
        return convertor.convert(magazineRepository.save(convertor.convert(request)));
    }

    @Override
    public void delete(MagazineUpdateRequest request) {
        magazineRepository.findById(request.getId())
                .orElseThrow(() -> new IllegalArgumentException());
        magazineRepository.deleteById(request.getId());
    }

    @Override
    public CompletableFuture<AsyncSavedResponse> saveBook(List<BookCreateRequest> requests) {
        List<Book> save=new ArrayList<>();
        List<Book> errorReq=new ArrayList<>();
        for (BookCreateRequest r:requests) {
            try {
                check(r.getAuthorId(),r.getPublisherId());
                save.add(convertor.convert(r));
            }catch (Exception e){
                errorReq.add(convertor.convert(r));
            }
        }
        save=bookRepository.saveAll(save);
        return CompletableFuture.completedFuture(
                AsyncSavedResponse.builder()
                        .saved(save.stream()
                                .map(book -> convertor.convert(book)).collect(Collectors.toList()))
                        .error(errorReq.stream()
                                .map(book -> convertor.convert(book)).collect(Collectors.toList()))
                        .build());
    }

    @Override
    public CompletableFuture<AsyncSavedResponse> saveMagazine(List<MagazineCreateRequest> requests) {
        List<Magazine> save=new ArrayList<>();
        List<Magazine> errorReq=new ArrayList<>();
        for (MagazineCreateRequest r:requests) {
            try {
                check(r.getAuthorId(),r.getPublisherId());
                save.add(convertor.convert(r));
            }catch (Exception e){
                errorReq.add(convertor.convert(r));
            }
        }
        save=magazineRepository.saveAll(save);
        return CompletableFuture.completedFuture(
                AsyncSavedResponse.builder()
                        .saved(save.stream()
                                .map(magazine -> convertor.convert(magazine)).collect(Collectors.toList()))
                        .error(errorReq.stream()
                                .map(magazine -> convertor.convert(magazine)).collect(Collectors.toList()))
                        .build());
    }

    private void check(String authorId,String publisherId){
        authorService.getById(authorId);
        publisherService.getById(publisherId);
    }

}
