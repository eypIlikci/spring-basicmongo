package com.basicmongo.repository;

import com.basicmongo.domain.Book;
import com.basicmongo.repository.custom.BookCustomRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book,String>, BookCustomRepository {
}
