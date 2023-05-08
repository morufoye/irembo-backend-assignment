package com.assignment.backend.repo;

import com.assignment.backend.entity.AccountVerificationDetails;
import com.assignment.backend.entity.UserAccount;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface AccountVerificationDetailsRepo extends ReactiveCrudRepository<AccountVerificationDetails,Long> {
    Mono<AccountVerificationDetails> findByUserId(String userId);
}
