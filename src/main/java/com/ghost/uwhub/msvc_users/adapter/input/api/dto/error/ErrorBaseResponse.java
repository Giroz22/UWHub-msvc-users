package com.ghost.uwhub.msvc_users.adapter.input.api.dto.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class ErrorBaseResponse {
    private String status;
    private int code;
}
