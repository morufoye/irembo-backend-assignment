package com.assignment.backend.service;


import com.assignment.backend.entity.AccountVerificationDetails;
import com.assignment.backend.entity.UserAccount;
import com.assignment.backend.enums.AccountVerificationEnum;
import com.assignment.backend.repo.AccountVerificationDetailsRepo;
import com.assignment.backend.repo.UserAccountRepo;
import com.assignment.backend.request.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class AccountService {
    @Autowired
    private UserAccountRepo userAccountRepo;
    @Autowired
    private AccountVerificationDetailsRepo accountVerificationDetailsRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private EmailService emailService;

    public Mono<ResponseEntity<UserAccount>> signUp(SignUp signUp) {
        UserAccount userAccount = UserAccount.builder()
                .userId(signUp.getUserId())
                .password(passwordEncoder.encode(signUp.getPassword()))
                .firstname(signUp.getFirstname())
                .lastname(signUp.getLastname())
                .status(AccountVerificationEnum.UNVERIFIED)
                .build();
        return userAccountRepo.save(userAccount)
                .map(x -> ResponseEntity.ok().body(x))
                .switchIfEmpty(Mono.just(ResponseEntity.status(HttpStatus.BAD_REQUEST).build()));
    }

    public Mono<ResponseEntity<Boolean>> loginStepOne(@RequestBody LoginOne login) {
        return userAccountRepo.findByUserId(login.getUserId())
                .filter(x ->  passwordEncoder.matches(login.getPassword(), x.getPassword()))
                .map (x -> ResponseEntity.ok().body(true))
                .switchIfEmpty(Mono.just(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build()));
    }

    public Mono<ResponseEntity<UserAccount>> loginStepTwo(@RequestBody LoginTwo login) {
       return userAccountRepo.findByUserId(login.getUserId())
                .filter(x ->  login.getToken().equalsIgnoreCase(x.getTokenHolder()))
                .map (x -> ResponseEntity.ok().body(x))
                .switchIfEmpty(Mono.just(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build()));
    }

    public Mono<UserAccount> updateProfile(UserAccount user) {
        return   userAccountRepo.findByUserId(user.getUserId())
                .map((x)->{
                            x.setFirstname(user.getFirstname());
                            x.setLastname(user.getLastname());
                            x.setAge(user.getAge());
                            x.setDateOfBirth(user.getDateOfBirth());
                            x.setNationality(user.getNationality());
                            x.setMaritalStatus(user.getMaritalStatus());
                            x.setGender(user.getGender());
                            x.setTokenHolder(user.getTokenHolder());
                            return x ;
                        }).flatMap(y->userAccountRepo.save(y));
    }

    public Mono<UserAccount> updateToken(String userId, String token) {
        return   userAccountRepo.findByUserId(userId)
                .map((x)->{
                    x.setTokenHolder(token);
                    return x ;
                }).flatMap(y->userAccountRepo.save(y));
    }

    public Mono<UserAccount> resetPassword(PasswordReset passwordReset) {
        return   userAccountRepo.findByUserId(passwordReset.getUserId())
                .map((x)->{
                    x.setPassword(passwordEncoder.encode(passwordReset.getNewPassword()));
                    return x ;
                }).flatMap(y->userAccountRepo.save(y));
    }

    public Mono<UserAccount> updateStatus(StatusUpdate statusUpdate) {
        return   userAccountRepo.findByUserId(statusUpdate.getUserId())
                .map((x)->{
                    x.setStatus(statusUpdate.getStatus());
                    return x ;
                }).flatMap(y->userAccountRepo.save(y));
    }

    public Mono<UserAccount> getUser(String userId) {
        return userAccountRepo.findByUserId(userId);
    }

    public Mono<AccountVerificationDetails> getVerificationDetails(String userId) {
        return accountVerificationDetailsRepo.findByUserId(userId);
    }

    public Mono<AccountVerificationDetails> verificationDetails(VerificationDetails request) {
         AccountVerificationDetails accountVerificationDetails = AccountVerificationDetails.builder()
                 .idNumber(request.getIdNumber())
                 .idType(request.getIdType())
                 .userId(request.getUserId())
                 .build();
        return   accountVerificationDetailsRepo.save(accountVerificationDetails);
    }

    public Mono<Boolean> checkUserAvailability(String username){
        return userAccountRepo.findByUserId(username)
                .map(x -> (x != null));
    }

}
