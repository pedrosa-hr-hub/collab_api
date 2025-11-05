package com.example.collab.domain.converter;

import com.example.collab.domain.valueobject.documento.VoterRegistration;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class VoterRegistrationConverter implements AttributeConverter<VoterRegistration, String> {

    @Override
    public String convertToDatabaseColumn(VoterRegistration attribute) {

        return attribute != null ? attribute.getVoteId() : null;

    }

    @Override
    public VoterRegistration convertToEntityAttribute(String dbData) {

        return dbData != null ? new VoterRegistration(dbData) : null;
        
    }
}