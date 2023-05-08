package com.assignment.backend.converter;

import com.assignment.backend.enums.GenderEnum;
import com.assignment.backend.enums.MaritalStatusEnum;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class MaritalStatusConverter implements AttributeConverter<MaritalStatusEnum, String> {

    @Override
    public String convertToDatabaseColumn(MaritalStatusEnum maritalStatusEnum) {
        if (maritalStatusEnum == null) {
            return null;
        }
        return maritalStatusEnum.getValue();
    }

    @Override
    public MaritalStatusEnum convertToEntityAttribute(String value) {
        if (value == null) {
            return null;
        }
        return Stream.of(MaritalStatusEnum.values())
                .filter(x -> x.getValue().equals(value))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

}
