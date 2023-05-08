package com.assignment.backend.controller;

import com.assignment.backend.entity.UserAccount;
import com.assignment.backend.repo.UserAccountRepo;
import com.assignment.backend.service.AccountService;
import com.assignment.backend.service.EmailService;
import com.assignment.backend.util.Utility;
import jakarta.mail.MessagingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/message")
@Slf4j
public class MessageController {

    @Autowired
    private EmailService emailService;
    @Autowired
    private AccountService accountService;

    @Autowired
    private UserAccountRepo userAccountRepo;
    @GetMapping("/token/{userId}")
    public Mono<Void> sendToken(@PathVariable String userId) throws MessagingException {
        int token = Utility.generateToken();
        emailService.sendHtmlEmail("Login Token", String.valueOf(userId), String.valueOf(token));
       return  userAccountRepo.findByUserId(userId)
                .map((x)->{
                    x.setTokenHolder(String.valueOf(token));
                    return x ;
                }).flatMap(y->userAccountRepo.save(y)).then();
    }

    @GetMapping("/login-link/{userId}")
    public void loginLin(@PathVariable String userId) throws MessagingException {
        String loginLink = "http://localhost:3000/login";
        emailService.sendHtmlEmail("Login link", userId, loginLink);
    }

    @GetMapping("/reset-link/{userId}")
    public void passwordReset(@PathVariable String userId) throws MessagingException {
        String loginLink = "http://localhost:3000/reset-password";
        emailService.sendHtmlEmail("Password Reset", userId, loginLink);
    }

}
