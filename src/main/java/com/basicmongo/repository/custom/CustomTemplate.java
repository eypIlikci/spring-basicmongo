package com.basicmongo.repository.custom;

import com.basicmongo.domain.Book;
import com.basicmongo.domain.model.search.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomTemplate<T>{
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<T> search(Search search,Class<T> type){
        Query query=new Query();
        List<Criteria> criteria=new ArrayList<>();
        if (search.getId()!=null)
            criteria.add(Criteria.where("id").is(search.getId()));
        if (search.getName()!=null)
            criteria.add(Criteria.where("name").is(search.getName()));
        if (search.getPrice()!=null)
            criteria.add(Criteria.where("price").is(search.getPrice()));
        query.addCriteria(new Criteria().andOperator(criteria.toArray(new Criteria[criteria.size()])));
        return mongoTemplate.find(query,type);
    }
    public Page<T> search(Search search, Pageable pageable,Class<T> type){
        Query query=new Query();
        List<Criteria> criteria=new ArrayList<>();
        if (search.getId()!=null)
            criteria.add(Criteria.where("id").is(search.getId()));
        if (search.getName()!=null)
            criteria.add(Criteria.where("name").is(search.getName()));
        if (search.getPrice()!=null)
            criteria.add(Criteria.where("price").is(search.getPrice()));
        query.addCriteria(new Criteria().andOperator(criteria.toArray(new Criteria[criteria.size()])))
                .with(pageable)
                .skip(pageable.getPageSize() * pageable.getPageNumber())
                .limit(pageable.getPageSize());
        List<T> find=mongoTemplate.find(query,type);
        long count=mongoTemplate.count(query.skip(-1).limit(-1),type);
       return new PageImpl<T>(find,pageable,count);
    }
}
