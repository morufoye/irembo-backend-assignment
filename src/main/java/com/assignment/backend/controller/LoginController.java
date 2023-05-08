package com.assignment.backend.controller;

import com.assignment.backend.entity.UserAccount;
import com.assignment.backend.request.LoginOne;
import com.assignment.backend.request.LoginTwo;
import com.assignment.backend.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.validation.Valid;


@RestController
@RequestMapping("login/")
@Slf4j
public class LoginController {

    @Autowired
    private AccountService accountService;

    @PostMapping("one")
    public Mono<ResponseEntity<Boolean>> loginStepOne(@RequestBody LoginOne login) {
        return accountService.loginStepOne(login);
    }

    @PostMapping("two")
    public Mono<ResponseEntity<UserAccount>> loginLevelTwo(@RequestBody LoginTwo login) {
        return accountService.loginStepTwo(login);
    }
}
