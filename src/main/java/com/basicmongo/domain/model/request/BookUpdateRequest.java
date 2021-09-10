package com.basicmongo.domain.model.request;

import com.basicmongo.domain.model.PostModel;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotNull;

@SuperBuilder
@Data
public class BookUpdateRequest extends PostModel {
    @NotNull
    private String id;
}
