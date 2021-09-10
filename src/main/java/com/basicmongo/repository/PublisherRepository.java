package com.basicmongo.repository;

import com.basicmongo.domain.Publisher;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PublisherRepository extends MongoRepository<Publisher,String> {
}
