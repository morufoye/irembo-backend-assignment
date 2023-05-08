package com.assignment.backend.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginTwo {
    @NotBlank(message = "UserId is required")
    private String userId;

    @NotBlank(message = "Token is required")
    private String token;
}
