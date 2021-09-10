package com.basicmongo.service;


import com.basicmongo.domain.model.request.AuthorCreateRequest;
import com.basicmongo.domain.model.request.AuthorUpdateRequest;
import com.basicmongo.domain.model.response.AuthorResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AuthorService {
        AuthorResponse save(AuthorCreateRequest request);
        AuthorResponse update(AuthorUpdateRequest request);
        void delete(AuthorUpdateRequest request);
        AuthorResponse getById(String id);
        List<AuthorResponse> getAll();
        Page<AuthorResponse> getAll(Pageable pageable);
}
