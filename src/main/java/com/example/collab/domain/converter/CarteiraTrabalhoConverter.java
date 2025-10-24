package com.example.collab.domain.converter;

import com.example.collab.domain.CarteiraTrabalho;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class CarteiraTrabalhoConverter implements AttributeConverter<CarteiraTrabalho, String> {

    @Override
    public String convertToDatabaseColumn(CarteiraTrabalho attribute) {
        return attribute != null ? attribute.getNumero() : null;
    }

    @Override
    public CarteiraTrabalho convertToEntityAttribute(String dbData) {
        return dbData != null ? new CarteiraTrabalho(dbData) : null;
    }
}