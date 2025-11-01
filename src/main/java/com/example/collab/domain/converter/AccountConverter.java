package com.example.collab.domain.converter;

import com.example.collab.domain.valueobject.banking.Account;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class AccountConverter implements AttributeConverter<Account, String> {

    @Override
    public String convertToDatabaseColumn(Account attribute) {

        return attribute != null ? attribute.getNumber() : null;

    }

    @Override
    public Account convertToEntityAttribute(String dbData) {

        return dbData != null ? new Account(dbData) : null;

    }
}