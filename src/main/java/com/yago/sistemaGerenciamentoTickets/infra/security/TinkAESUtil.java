package com.yago.sistemaGerenciamentoTickets.infra.security;

import com.google.crypto.tink.*;
import com.google.crypto.tink.config.TinkConfig;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.util.Base64;

@Component
public class TinkAESUtil {

    private Aead aead;

    @Value("${tink.crypto.key}")
    private String keysetBase64;

    @PostConstruct
    public void init() throws GeneralSecurityException, IOException{
        TinkConfig.register();

        byte[] decodeKeysetBytes = Base64.getDecoder().decode(keysetBase64);

        ByteArrayInputStream inputStream = new ByteArrayInputStream(decodeKeysetBytes);

        KeysetHandle keysetHandle = CleartextKeysetHandle.read(
                JsonKeysetReader.withInputStream(inputStream)
        );

        this.aead = keysetHandle.getPrimitive(Aead.class);
    }

    public String encrypt(String valueToEncrypt) throws Exception{
        if (valueToEncrypt == null) return null;
        byte[] ciphertext = aead.encrypt(
          valueToEncrypt.getBytes(StandardCharsets.UTF_8),
          new byte[0]
        );
        return Base64.getEncoder().encodeToString(ciphertext);
    }

    public String decrypt(String encryptedValue) throws Exception{
        if (encryptedValue == null) return null;
        byte[] decodeCiphertext = Base64.getDecoder().decode(encryptedValue);
        byte[] plainText = aead.decrypt(decodeCiphertext, new byte[0]);
        return new String(plainText, StandardCharsets.UTF_8);
    }
}
