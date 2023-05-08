package com.assignment.backend.converter;

import com.assignment.backend.enums.VerificationDocumentType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class VerificationDocumentTypeConverter implements AttributeConverter<VerificationDocumentType, String> {

    @Override
    public String convertToDatabaseColumn(VerificationDocumentType genderEnum) {
        if (genderEnum == null) {
            return null;
        }
        return genderEnum.getValue();
    }

    @Override
    public VerificationDocumentType convertToEntityAttribute(String value) {
        if (value == null) {
            return null;
        }
        return Stream.of(VerificationDocumentType.values())
                .filter(x -> x.getValue().equals(value))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
