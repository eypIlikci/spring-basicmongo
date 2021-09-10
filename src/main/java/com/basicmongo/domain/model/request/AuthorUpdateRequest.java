package com.basicmongo.domain.model.request;

import com.basicmongo.domain.model.PostModel;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
public class AuthorUpdateRequest extends PostModel {
    private String id;
}
