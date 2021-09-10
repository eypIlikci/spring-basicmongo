package com.basicmongo.repository;

import com.basicmongo.domain.Magazine;
import com.basicmongo.repository.custom.MagazineCustomRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MagazineRepository extends MongoRepository<Magazine,String>, MagazineCustomRepository {
}
