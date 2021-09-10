package com.basicmongo.controller.impl;

import com.basicmongo.controller.UserOperations;
import com.basicmongo.domain.model.request.UserCreateRequest;
import com.basicmongo.security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/v1")
public class UserController implements UserOperations{
    @Autowired
    private UserService userService;
    @Override
    public ResponseEntity<?> register(UserCreateRequest request) {
        return ResponseEntity.ok(userService.register(request));
    }
}
