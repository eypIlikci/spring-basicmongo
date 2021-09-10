package com.basicmongo.repository.custom;

import com.basicmongo.domain.Magazine;
import com.basicmongo.domain.model.search.Search;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MagazineCustomRepositoryImpl implements MagazineCustomRepository{
    private final CustomTemplate<Magazine> customTemplate;
    public MagazineCustomRepositoryImpl(CustomTemplate<Magazine> customTemplate) {
        this.customTemplate=customTemplate;
    }
    @Override
    public List<Magazine> search(Search search) {
        return customTemplate.search(search,Magazine.class);
    }

    @Override
    public Page<Magazine> search(Search search, Pageable pageable) {
        return customTemplate.search(search,pageable,Magazine.class);
    }
}
