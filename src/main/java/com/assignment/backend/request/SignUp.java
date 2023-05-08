package com.assignment.backend.request;

import com.assignment.backend.annotaion.ValidPassword;
import com.assignment.backend.enums.AccountVerificationEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class SignUp {
    @NotBlank(message = "A valid email is required")
    private String userId;
    private String firstname;
    private String lastname;
    @NotBlank(message = "Password is required")
    @ValidPassword
    private String password;
    @NotBlank(message = "Confirm Password is required")
    private String confirmPassword;

    private AccountVerificationEnum status;

     @AssertTrue(message = "Password confirmation mismatch")
        public boolean isPasswordConfirm() {
            if (password == null || confirmPassword == null)
                return true;
        return password.compareTo(confirmPassword) == 0;
    }
}
