package com.basicmongo.domain.model.search;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Search {
    private String id;
    private String name;
    private BigDecimal price;
    private DomainName domainName;
    public enum DomainName{BOOK,MAGAZINE}
}
