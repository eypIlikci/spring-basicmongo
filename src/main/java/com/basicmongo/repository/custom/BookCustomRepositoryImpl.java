package com.basicmongo.repository.custom;

;
import com.basicmongo.domain.Book;
import com.basicmongo.domain.model.search.Search;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookCustomRepositoryImpl implements BookCustomRepository{
    private final CustomTemplate<Book> customTemplate;
    public BookCustomRepositoryImpl(CustomTemplate<Book> customTemplate) {
       this.customTemplate=customTemplate;
    }

    @Override
    public List<Book> search(Search search) {
        return  customTemplate.search(search,Book.class);
    }

    @Override
    public Page<Book> search(Search search, Pageable pageable) {
        return customTemplate.search(search,pageable,Book.class);
    }
}
