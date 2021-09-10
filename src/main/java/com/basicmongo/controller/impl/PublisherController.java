package com.basicmongo.controller.impl;


import com.basicmongo.controller.PublisherOperations;
import com.basicmongo.domain.model.request.PublisherCreateRequest;
import com.basicmongo.domain.model.request.PublisherUpdateRequest;
import com.basicmongo.domain.model.response.PublisherReponse;
import com.basicmongo.service.PublisherService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/v1/")
public class PublisherController implements PublisherOperations {
    private final PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @Override
    public ResponseEntity<?> getById(String id,HttpSession session) {
        PublisherReponse response=publisherService.getById(id);
        session.setAttribute("publisherId",response.getId());
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<?> save(PublisherCreateRequest request) {
        return ResponseEntity.ok(publisherService.save(request));
    }

    @Override
    public ResponseEntity<?> update(PublisherUpdateRequest request) {
        return ResponseEntity.ok(publisherService.update(request));
    }

    @Override
    public ResponseEntity<?> get(Pageable pageable) {
        if (pageable==null)
            return ResponseEntity.ok(publisherService.getAll());
        return ResponseEntity.ok(publisherService.getAll(pageable));
    }


}
