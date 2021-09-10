package com.basicmongo.repository.custom;

import com.basicmongo.domain.Magazine;
import com.basicmongo.domain.model.search.Search;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MagazineCustomRepository {
    List<Magazine> search(Search search);
    Page<Magazine> search(Search search, Pageable pageable);
}
