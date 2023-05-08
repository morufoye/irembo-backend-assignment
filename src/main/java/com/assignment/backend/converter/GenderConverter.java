package com.assignment.backend.converter;

import com.assignment.backend.enums.GenderEnum;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class GenderConverter implements AttributeConverter<GenderEnum, String> {

    @Override
    public String convertToDatabaseColumn(GenderEnum genderEnum) {
        if (genderEnum == null) {
            return null;
        }
        return genderEnum.getValue();
    }

    @Override
    public GenderEnum convertToEntityAttribute(String value) {
        if (value == null) {
            return null;
        }
        return Stream.of(GenderEnum.values())
                .filter(x -> x.getValue().equals(value))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

}
