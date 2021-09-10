package com.basicmongo.controller.impl;


import com.basicmongo.controller.PostOperations;
import com.basicmongo.domain.model.request.BookCreateRequest;
import com.basicmongo.domain.model.request.BookUpdateRequest;
import com.basicmongo.domain.model.request.MagazineCreateRequest;
import com.basicmongo.domain.model.request.MagazineUpdateRequest;
import com.basicmongo.domain.model.search.Search;
import com.basicmongo.helper.PostFlowHelper;
import com.basicmongo.service.PostService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;


@RestController("/api/v1/post")
public class PostController implements PostOperations {

    private final PostService postService;
    private final PostFlowHelper postFlowHelper;

    public PostController(PostService postService,
                          PostFlowHelper postFlowHelper) {
        this.postService = postService;
        this.postFlowHelper=postFlowHelper;
    }


    @Override
    public ResponseEntity<?> find(Search.DomainName domainName,
                                  Search search,
                                  Pageable pageable) {
        search.setDomainName(domainName);
        if (pageable!=null)
            return ResponseEntity.ok(postService.find(search,pageable));
        return ResponseEntity.ok(postService.find(search));
    }

    @Override
    public ResponseEntity<?> saveBook(BookCreateRequest request) {
        if (request.getAuthorId()==null)
            request.setAuthorId(postFlowHelper.getAuthorId());
        if (request.getPublisherId()==null)
            request.setPublisherId(postFlowHelper.getPublisherId());
        return ResponseEntity.ok(postService.save(request));
    }

    @Override
    public ResponseEntity<?> updateBook(BookUpdateRequest request) {
        if (request.getAuthorId()==null)
            request.setAuthorId(postFlowHelper.getAuthorId());
        if (request.getPublisherId()==null)
            request.setPublisherId(postFlowHelper.getPublisherId());
        return ResponseEntity.ok(postService.update(request));
    }

    @Override
    public CompletableFuture<ResponseEntity> saveBook(List<BookCreateRequest> requests) {
        return postService.saveBook(requests).<ResponseEntity>thenApply(ResponseEntity::ok);
    }

    @Override
    public ResponseEntity<?> saveMagazine(MagazineCreateRequest request) {
        if (request.getAuthorId()==null)
            request.setAuthorId(postFlowHelper.getAuthorId());
        if (request.getPublisherId()==null)
            request.setPublisherId(postFlowHelper.getPublisherId());
        return ResponseEntity.ok(postService.save(request));
    }

    @Override
    public ResponseEntity<?> updateMagazine(MagazineUpdateRequest request) {
        if (request.getAuthorId()==null)
            request.setAuthorId(postFlowHelper.getAuthorId());
        if (request.getPublisherId()==null)
            request.setPublisherId(postFlowHelper.getPublisherId());
        return ResponseEntity.ok(postService.update(request));
    }

    @Override
    public CompletableFuture<ResponseEntity> saveMagazine(List<MagazineCreateRequest> requests) {
        return postService.saveMagazine(requests).<ResponseEntity>thenApply(ResponseEntity::ok);
    }


    @Override
    public ResponseEntity<?> flow(String authorId, String publisherId) {
        if (authorId!=null)
              postFlowHelper.setAuthorId(authorId);
        if (publisherId!=null)
            postFlowHelper.setPublisherId(publisherId);
        return ResponseEntity.ok("Added");
    }
}
