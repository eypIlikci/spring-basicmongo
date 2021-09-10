package com.basicmongo.domain;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@SuperBuilder
@Data
@Document
public class Publisher extends BaseDomain{
    @Id
    private String id;
}
