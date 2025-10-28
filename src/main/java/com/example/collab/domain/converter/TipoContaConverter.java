package com.example.collab.domain.converter;

import com.example.collab.domain.valueobject.bancario.TipoConta;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class TipoContaConverter implements AttributeConverter<TipoConta, String> {

    @Override
    public String convertToDatabaseColumn(TipoConta attribute) {
        return attribute != null ? attribute.getTipo() : null;
    }

    @Override
    public TipoConta convertToEntityAttribute(String dbData) {
        return dbData != null ? new TipoConta(dbData) : null;
    }
}