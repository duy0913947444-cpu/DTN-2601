package com.vti.Enum;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.springframework.objenesis.ObjenesisException;

import java.util.Objects;

@Converter(autoApply = true)
public class ArticlePositionNameConverter implements AttributeConverter<PositionName, String> {
    @Override
    public String convertToDatabaseColumn(PositionName attribute) {
        if(Objects.isNull(attribute)) return null;
        return attribute.getName();
    }

    @Override
    public PositionName convertToEntityAttribute(String dbData) {
        if(Objects.isNull(dbData)) return null;
        return PositionName.toEnum(dbData);
    }
}
