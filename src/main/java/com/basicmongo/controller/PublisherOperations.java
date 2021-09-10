package com.basicmongo.controller;


import com.basicmongo.domain.model.request.PublisherCreateRequest;
import com.basicmongo.domain.model.request.PublisherUpdateRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

public interface PublisherOperations {
    @GetMapping("publisher/{id}")
    ResponseEntity<?> getById(@PathVariable("id") String id, HttpSession session);
    @PostMapping("publisher")
    ResponseEntity<?> save(@RequestBody PublisherCreateRequest request);
    @PutMapping("publisher")
    ResponseEntity<?> update(@RequestBody PublisherUpdateRequest request);
    @GetMapping("publisher")
    ResponseEntity<?> get(Pageable pageable);


}
