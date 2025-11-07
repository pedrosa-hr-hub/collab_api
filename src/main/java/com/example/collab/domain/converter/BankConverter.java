package com.example.collab.domain.converter;

import com.example.collab.domain.valueobject.banking.Bank;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class BankConverter implements AttributeConverter<Bank, String> {

    @Override
    public String convertToDatabaseColumn(Bank attribute) {

        return attribute != null ? attribute.getCode() : null;

    }

    @Override
    public Bank convertToEntityAttribute(String dbData) {

        return dbData != null ? new Bank(dbData) : null;
        
    }
}