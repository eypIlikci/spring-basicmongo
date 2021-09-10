package com.basicmongo.controller;



import com.basicmongo.domain.model.request.BookCreateRequest;
import com.basicmongo.domain.model.request.BookUpdateRequest;
import com.basicmongo.domain.model.request.MagazineCreateRequest;
import com.basicmongo.domain.model.request.MagazineUpdateRequest;
import com.basicmongo.domain.model.search.Search;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.concurrent.CompletableFuture;


public interface PostOperations {
    //Search
    @GetMapping("/search/{domainName}")
    ResponseEntity<?> find(@PathVariable("domainName") Search.DomainName domainName,
                           Search search,
                           Pageable pageable);
    //Book
    @PostMapping("/book")
    ResponseEntity<?> saveBook(@Valid @RequestBody BookCreateRequest request);
    @PutMapping("/book")
    ResponseEntity<?> updateBook(@Valid @RequestBody BookUpdateRequest request);
    @PostMapping("/books")
    @ResponseBody CompletableFuture<ResponseEntity> saveBook(@Valid @RequestBody List<BookCreateRequest> requests);
    //Magazine
    @PostMapping("/magazine")
    ResponseEntity<?> saveMagazine(@Valid @RequestBody MagazineCreateRequest request);
    @PutMapping("/magazine")
    ResponseEntity<?> updateMagazine(@Valid @RequestBody MagazineUpdateRequest request);
    @PostMapping("/magazines")
    @ResponseBody CompletableFuture<ResponseEntity> saveMagazine(@Valid @RequestBody List<MagazineCreateRequest> requests);
    //SaveFlow
    @GetMapping("/flow")
    ResponseEntity<?> flow(@RequestParam(value = "authorId" ,required = false) String authorId,
                           @RequestParam(value = "publisherId",required = false) String publisherId);

}
