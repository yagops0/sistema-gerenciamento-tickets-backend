package com.yago.sistemaGerenciamentoTickets.entities;

import com.yago.sistemaGerenciamentoTickets.infra.security.TinkAESUtil;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.image.BufferedImageFilter;

@Component
@Converter(autoApply = false)
public class SolucaoAttributeConverter implements AttributeConverter<String, String> {

    @Autowired
    private TinkAESUtil aesUtil;


    @Override
    public String convertToDatabaseColumn(String attribute) {
        if (attribute == null) return null;
        try {
            return aesUtil.encrypt(attribute);
        }catch (Exception e){
        throw new RuntimeException("falha ao criptografar dado com Google Tink", e);
        }
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        if (dbData == null) return null;
        try {
            return aesUtil.decrypt(dbData);
        }catch (Exception e){
            throw new RuntimeException("falha ao descriptografar dado com Google TInk", e);
        }
    }
}
