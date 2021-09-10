package com.basicmongo.domain.model.request;

import com.basicmongo.domain.model.BaseModel;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotNull;

@SuperBuilder
@Data
public class PublisherUpdateRequest extends BaseModel {
    @NotNull
    private String id;
}
