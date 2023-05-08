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
public class LoginOne {

    @NotBlank(message = "UserId is required")
    private String userId;
    @NotBlank(message = "Password is required")
    private String password;

}
