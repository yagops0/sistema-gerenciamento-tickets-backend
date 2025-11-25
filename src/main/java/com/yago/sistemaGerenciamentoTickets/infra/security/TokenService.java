package com.yago.sistemaGerenciamentoTickets.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.yago.sistemaGerenciamentoTickets.entities.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;


@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    public String generateToken(User user){

        try{
            Algorithm algorithm = Algorithm.HMAC256(secret); // secrets são tipo "chaves" para tornar o hash único para nossa aplicaçõa
            String token = JWT.create()
                    .withIssuer("sistemaGerenciamentoTickets")
                    .withSubject(user.getMatricula())
                    .withExpiresAt(genExpirationDate())
                    .sign(algorithm);// faz a assinatura e geração final

            return token;
        }catch (JWTCreationException exception){
            throw new RuntimeException("Erro ao gerar token", exception);
        }
    }

    public String validateToken(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("sistemaGerenciamentoTickets")
                    .build()
                    .verify(token)
                    .getSubject();
        }catch (JWTVerificationException exception){
            return null;
        }
    }

    private Instant genExpirationDate(){
        return LocalDateTime.now().plusHours(3).toInstant(ZoneOffset.of("-03:00"));
    }
}
