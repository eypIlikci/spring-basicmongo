package com.basicmongo.domain.model.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class AsyncSavedResponse {
    private List<Object> saved;
    private List<Object> error;
}
