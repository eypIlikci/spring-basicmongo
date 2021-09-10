package com.basicmongo.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.Date;

@SuperBuilder
@Data
@NoArgsConstructor
public abstract class Post extends BaseDomain{
    private BigDecimal price;
    private Publisher publisher;
    private Author author;
    private Date createDate;
}
