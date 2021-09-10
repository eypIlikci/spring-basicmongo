package com.basicmongo.service.impl;


import com.basicmongo.domain.Publisher;
import com.basicmongo.domain.model.request.PublisherCreateRequest;
import com.basicmongo.domain.model.request.PublisherUpdateRequest;
import com.basicmongo.domain.model.response.PublisherReponse;
import com.basicmongo.repository.PublisherRepository;
import com.basicmongo.service.PublisherService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PublisherServiceImpl implements PublisherService {
    private final PublisherRepository publisherRepository;

    public PublisherServiceImpl(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Override
    public PublisherReponse save(PublisherCreateRequest request) {
        return convert(publisherRepository.save(convert(request)));
    }

    @Override
    public PublisherReponse update(PublisherUpdateRequest request) {
        this.getById(request.getId());
        return convert(publisherRepository.save(convert(request)));
    }

    @Override
    public void delete(PublisherUpdateRequest request) {
        publisherRepository.deleteById(request.getId());
    }

    @Override
    public PublisherReponse getById(String id) {
        return convert(publisherRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException()));
    }

    @Override
    public List<PublisherReponse> getAll() {
        return publisherRepository.findAll()
                .stream()
                .map(publisher -> convert(publisher))
                .collect(Collectors.toList());
    }

    @Override
    public Page<PublisherReponse> getAll(Pageable pageable) {
        return publisherRepository.findAll(pageable)
                .map(publisher -> convert(publisher));
    }
    private PublisherReponse convert(Publisher publisher){
        return PublisherReponse.builder()
                .name(publisher.getName())
                .id(publisher.getId())
                .build();
    }
    private Publisher convert(PublisherCreateRequest request){
        return Publisher.builder()
                .name(request.getName())
                .build();
    }
    private Publisher convert(PublisherUpdateRequest request){
        return Publisher.builder()
                .id(request.getId())
                .name(request.getName())
                .build();
    }
}
