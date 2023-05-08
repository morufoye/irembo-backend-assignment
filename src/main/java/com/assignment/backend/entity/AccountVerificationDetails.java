package com.assignment.backend.entity;

import com.assignment.backend.enums.VerificationDocumentType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.Column;

@Table
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AccountVerificationDetails {
    @Id
    private long id;
    @Column(unique=true)
    private String userId;
    private String idNumber;
    private VerificationDocumentType idType;
}
