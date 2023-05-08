package com.assignment.backend.entity;


import com.assignment.backend.enums.AccountVerificationEnum;
import com.assignment.backend.enums.GenderEnum;
import com.assignment.backend.enums.MaritalStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.Column;
import java.time.LocalDate;

@Table
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserAccount {
    @Id
    private long id;
    @Column(unique=true)
    private String userId;
    private String firstname;
    private String password;
    private String lastname;
    private int age;
    private LocalDate dateOfBirth;
    private GenderEnum gender;
    private MaritalStatusEnum maritalStatus;
    private String nationality;
    private AccountVerificationEnum status;
    private String tokenHolder;
}
