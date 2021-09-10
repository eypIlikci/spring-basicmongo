package com.basicmongo.domain.model.response;

import com.basicmongo.domain.model.BaseModel;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
public class AuthorResponse extends BaseModel {
    private String id;
}
