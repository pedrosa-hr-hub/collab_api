package com.example.collab.domain.converter;

import com.example.collab.domain.valueobject.document.CNPJ;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class CnpjConverter implements AttributeConverter<CNPJ, String> {

    @Override
    public String convertToDatabaseColumn(CNPJ attribute) {

        return attribute != null ? attribute.getCnpj() : null;

    }

    @Override
    public CNPJ convertToEntityAttribute(String dbData) {

        return dbData != null ? new CNPJ(dbData) : null;
        
    }
}