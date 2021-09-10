package com.basicmongo.service;


import com.basicmongo.domain.model.request.BookCreateRequest;
import com.basicmongo.domain.model.request.BookUpdateRequest;
import com.basicmongo.domain.model.request.MagazineCreateRequest;
import com.basicmongo.domain.model.request.MagazineUpdateRequest;
import com.basicmongo.domain.model.response.AsyncSavedResponse;
import com.basicmongo.domain.model.response.BookResponse;
import com.basicmongo.domain.model.response.MagazineResponse;
import com.basicmongo.domain.model.search.Search;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface PostService {
    //TODO Search
    List<Object> find(Search search);
    Page<Object> find(Search search,Pageable pageable);

    //TODO Book Service
    BookResponse save(BookCreateRequest request);
    BookResponse update(BookUpdateRequest request);
    void delete(BookUpdateRequest request);

    //TODO Magazine Service
    MagazineResponse save(MagazineCreateRequest request);
    MagazineResponse update(MagazineUpdateRequest request);
    void delete(MagazineUpdateRequest request);

    //TODO Async
    CompletableFuture<AsyncSavedResponse> saveBook(List<BookCreateRequest> requests);
    CompletableFuture<AsyncSavedResponse> saveMagazine(List<MagazineCreateRequest> requests);

}
