package com.basicmongo.domain.model.response;

import com.basicmongo.domain.model.BaseModel;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
public class PublisherReponse extends BaseModel {
    private String id;
}
