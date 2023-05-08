package com.assignment.backend.controller;

import com.assignment.backend.entity.AccountVerificationDetails;
import com.assignment.backend.entity.UserAccount;
import com.assignment.backend.request.*;
import com.assignment.backend.service.AccountService;
import com.assignment.backend.util.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserAccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/signup")
    public Mono<UserAccount> signUp(@RequestBody @Valid SignUp signUp){
        return accountService.signUp(signUp);
    }

    @PostMapping("/edit-profile")
    public Mono<UserAccount> editProfile(@RequestBody UserAccount userAccount){
        return accountService.updateProfile(userAccount);
    }

    @PostMapping("/update-status")
    public Mono<UserAccount> updateStatus(@RequestBody StatusUpdate status){
        return accountService.updateStatus(status);
    }

    @PostMapping("/reset-password")
    public Mono<UserAccount> resetPassword(@RequestBody @Valid PasswordReset password){
        return accountService.resetPassword(password);
    }

    @GetMapping("/get-user/{userId}")
    public Mono<UserAccount> getUser(@PathVariable String userId){
        return accountService.getUser(userId);
    }

    @PostMapping("/verification")
    public Mono<AccountVerificationDetails> verificationDetail(@RequestBody @Valid VerificationDetails request){
        return  accountService.verificationDetails(request);
    }

    @PostMapping("/validate-password")
    public Mono<String> validatePassword(@RequestBody Password password){
        return Mono.just(Utility.validatePassword(password));
    }

    @GetMapping("/verification/{userId}")
    public Mono<AccountVerificationDetails> getVerificationDetails(@PathVariable String userId){
        return  accountService.getVerificationDetails(userId);
    }

}
