package com.basicmongo.controller;


import com.basicmongo.domain.model.request.PublisherCreateRequest;
import com.basicmongo.domain.model.request.PublisherUpdateRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

public interface PublisherOperations {
    @GetMapping("publisher/{id}")
    ResponseEntity<?> getById(@Valid  @PathVariable("id") String id, HttpSession session);
    @PostMapping("publisher")
    ResponseEntity<?> save(@Valid @RequestBody PublisherCreateRequest request);
    @PutMapping("publisher")
    ResponseEntity<?> update(@Valid @RequestBody PublisherUpdateRequest request);
    @GetMapping("publisher")
    ResponseEntity<?> get(Pageable pageable);


}
