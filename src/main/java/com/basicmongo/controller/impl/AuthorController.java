package com.basicmongo.controller.impl;


import com.basicmongo.controller.AuthorOperations;
import com.basicmongo.domain.model.request.AuthorCreateRequest;
import com.basicmongo.domain.model.request.AuthorUpdateRequest;
import com.basicmongo.domain.model.response.AuthorResponse;
import com.basicmongo.service.AuthorService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/v1/")
public class AuthorController implements AuthorOperations {
    private AuthorService authorService;
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @Override
    public ResponseEntity<?> getById(@PathVariable("id") String id, HttpSession session){
        AuthorResponse response=authorService.getById(id);
        session.setAttribute("authorId",response.getId());
        return ResponseEntity.ok(authorService.getById(id));
    }

    @Override
    public ResponseEntity<?> save(@RequestBody AuthorCreateRequest request){
        return ResponseEntity.ok(authorService.save(request));
    }

    @Override
    public ResponseEntity<?> update(@RequestBody AuthorUpdateRequest request){
        return ResponseEntity.ok(authorService.update(request));
    }
    @Override
    public ResponseEntity<?> get(@RequestBody Pageable pageable){
        if (pageable==null)
            return ResponseEntity.ok(authorService.getAll());
        return ResponseEntity.ok(authorService.getAll(pageable));
    }

}
