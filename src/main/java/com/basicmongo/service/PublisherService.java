package com.basicmongo.service;


import com.basicmongo.domain.model.request.PublisherCreateRequest;
import com.basicmongo.domain.model.request.PublisherUpdateRequest;
import com.basicmongo.domain.model.response.PublisherReponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PublisherService {
    PublisherReponse save(PublisherCreateRequest request);
    PublisherReponse update(PublisherUpdateRequest request);
    void delete(PublisherUpdateRequest request);
    PublisherReponse getById(String id);
    List<PublisherReponse> getAll();
    Page<PublisherReponse> getAll(Pageable pageable);

}
