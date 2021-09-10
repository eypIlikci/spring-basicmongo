package com.basicmongo.repository.custom;


import com.basicmongo.domain.Book;
import com.basicmongo.domain.model.search.Search;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookCustomRepository {
    List<Book> search(Search search);
    Page<Book> search(Search search, Pageable pageable);
}
