package com.basicmongo.domain.model;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.Date;

@SuperBuilder
@Data
public abstract class PostModel extends BaseModel {
    private BigDecimal price;
    private String publisherId;
    private String authorId;
    private Date createDate;
}
