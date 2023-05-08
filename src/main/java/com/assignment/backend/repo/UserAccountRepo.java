package com.assignment.backend.repo;

import com.assignment.backend.entity.UserAccount;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface UserAccountRepo extends ReactiveCrudRepository<UserAccount,Long> {
    Mono<UserAccount> findByUserId(String userId);
}
