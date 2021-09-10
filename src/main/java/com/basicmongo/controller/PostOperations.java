package com.basicmongo.controller;



import com.basicmongo.domain.model.request.BookCreateRequest;
import com.basicmongo.domain.model.request.BookUpdateRequest;
import com.basicmongo.domain.model.request.MagazineCreateRequest;
import com.basicmongo.domain.model.request.MagazineUpdateRequest;
import com.basicmongo.domain.model.search.Search;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    ResponseEntity<?> saveBook(@RequestBody BookCreateRequest request);
    @PutMapping("/book")
    ResponseEntity<?> updateBook(@RequestBody BookUpdateRequest request);
    @PostMapping("/books")
    @ResponseBody CompletableFuture<ResponseEntity> saveBook(@RequestBody List<BookCreateRequest> requests);
    //Magazine
    @PostMapping("/magazine")
    ResponseEntity<?> saveMagazine(@RequestBody MagazineCreateRequest request);
    @PutMapping("/magazine")
    ResponseEntity<?> updateMagazine(@RequestBody MagazineUpdateRequest request);
    @PostMapping("/magazines")
    @ResponseBody CompletableFuture<ResponseEntity> saveMagazine(@RequestBody List<MagazineCreateRequest> requests);



    //SaveFlow
    @GetMapping("/flow")
    ResponseEntity<?> flow(@RequestParam(value = "authorId" ,required = false) String authorId,
                           @RequestParam(value = "publisherId",required = false) String publisherId);


}
