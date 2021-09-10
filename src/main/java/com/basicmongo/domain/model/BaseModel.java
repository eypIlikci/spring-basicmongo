package com.basicmongo.domain.model;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
public abstract class BaseModel {
    private String name;
}
