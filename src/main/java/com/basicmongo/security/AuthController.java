package com.basicmongo.security;

import com.basicmongo.domain.User;
import com.basicmongo.domain.model.convert.Convertor;
import com.basicmongo.domain.model.request.UserCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class AuthController {
    @Autowired
    private Convertor convertor;
    @PostMapping("/auth")
    public ResponseEntity<?> auth(@CurrentUser User user){
        return ResponseEntity.ok(convertor.convert(user));
    }
}
