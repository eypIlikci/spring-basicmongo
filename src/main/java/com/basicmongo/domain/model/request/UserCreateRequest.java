package com.basicmongo.domain.model.request;

import com.basicmongo.domain.model.request.validation.UniqueUsername;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
public class UserCreateRequest {
    @NotNull
    @Size(min = 5,max = 15)
    @UniqueUsername
    private String username;
    @NotNull
    @Size(min = 5,max = 15)
    private String password;
}
