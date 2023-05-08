package com.assignment.backend.converter;

import com.assignment.backend.enums.AccountVerificationEnum;
import com.assignment.backend.enums.GenderEnum;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class AccountStatusConverter implements AttributeConverter<AccountVerificationEnum, String> {

    @Override
    public String convertToDatabaseColumn(AccountVerificationEnum accountVerificationEnum) {
        if (accountVerificationEnum == null) {
            return null;
        }
        return accountVerificationEnum.getValue();
    }

    @Override
    public AccountVerificationEnum convertToEntityAttribute(String value) {
        if (value == null) {
            return null;
        }
        return Stream.of(AccountVerificationEnum.values())
                .filter(x -> x.getValue().equals(value))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
