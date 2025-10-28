package com.example.collab.domain.converter;

import com.example.collab.domain.valueobject.documento.TituloEleitor;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class TituloEleitorConverter implements AttributeConverter<TituloEleitor, String> {

    @Override
    public String convertToDatabaseColumn(TituloEleitor attribute) {
        return attribute != null ? attribute.getTitulo() : null;
    }

    @Override
    public TituloEleitor convertToEntityAttribute(String dbData) {
        return dbData != null ? new TituloEleitor(dbData) : null;
    }
}