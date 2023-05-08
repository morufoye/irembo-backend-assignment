package com.assignment.backend.request;

import com.assignment.backend.enums.AccountVerificationEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StatusUpdate {
    private String userId;
    private AccountVerificationEnum status;
}
