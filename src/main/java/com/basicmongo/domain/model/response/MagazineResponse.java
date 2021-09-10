package com.basicmongo.domain.model.response;

import com.basicmongo.domain.model.PostModel;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
public class MagazineResponse extends PostModel {
    private String id;
}
