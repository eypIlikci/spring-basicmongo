package com.basicmongo.domain.model.request;

import com.basicmongo.domain.model.BaseModel;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
public class PublisherUpdateRequest extends BaseModel {
    private String id;
}
