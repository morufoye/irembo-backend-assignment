package com.assignment.backend.request;

import com.assignment.backend.annotaion.ValidPassword;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class
PasswordReset {
    private String userId;

    @JsonProperty("new_password")
    @NotBlank(message = "Password is required")
    @ValidPassword
    private String newPassword;
    @NotBlank(message = "Confirm Password is required")
    private String confirmPassword;

    @AssertTrue(message = "Password confirmation mismatch")
    public boolean isPasswordConfirm() {
        if (newPassword == null || confirmPassword == null)
            return true;
        return newPassword.compareTo(confirmPassword) == 0;
    }
}
