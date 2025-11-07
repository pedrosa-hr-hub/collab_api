package com.example.collab.domain.converter;

import com.example.collab.domain.valueobject.document.WorkWallet;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class WorkWalletConverter implements AttributeConverter<WorkWallet, String> {

    @Override
    public String convertToDatabaseColumn(WorkWallet attribute) {

        return attribute != null ? attribute.getNumber() : null;

    }

    @Override
    public WorkWallet convertToEntityAttribute(String dbData) {

        return dbData != null ? new WorkWallet(dbData) : null;
    }
}