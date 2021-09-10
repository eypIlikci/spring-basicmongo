package com.basicmongo.controller;

import com.basicmongo.domain.model.request.UserCreateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

public interface UserOperations {
    @PostMapping("/user")
    public ResponseEntity<?> register(@Valid @RequestBody UserCreateRequest request);
}
