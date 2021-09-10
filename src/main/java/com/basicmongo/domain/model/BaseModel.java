package com.basicmongo.domain.model;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@SuperBuilder
@Data
public abstract class BaseModel {
    @NotNull
    @NotEmpty
    @Size(max = 20,min = 3)
    private String name;
}
