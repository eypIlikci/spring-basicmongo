package com.basicmongo.domain.model.request;

import com.basicmongo.domain.model.PostModel;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotNull;

@SuperBuilder
@Data
public class MagazineUpdateRequest extends PostModel {
    @NotNull
    private String id;
}
