package com.basicmongo.controller;


import com.basicmongo.domain.model.request.AuthorCreateRequest;
import com.basicmongo.domain.model.request.AuthorUpdateRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

public interface AuthorOperations {
    @GetMapping("author/{id}")
    ResponseEntity<?> getById(@PathVariable("id") String id, HttpSession session);
    @PostMapping("author")
    ResponseEntity<?> save(@RequestBody AuthorCreateRequest request);
    @PutMapping("author")
    ResponseEntity<?> update(@RequestBody AuthorUpdateRequest request);
    @GetMapping("author")
    ResponseEntity<?> get(Pageable pageable);

}
