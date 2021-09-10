package com.basicmongo.domain.model;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@SuperBuilder
@Data
public abstract class PostModel extends BaseModel {
    @NotNull
    private BigDecimal price;
    @NotNull
    private String publisherId;
    @NotNull
    private String authorId;
    @NotNull
    private Date createDate;
}
