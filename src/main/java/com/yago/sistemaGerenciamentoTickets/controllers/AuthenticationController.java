package com.yago.sistemaGerenciamentoTickets.controllers;

import com.yago.sistemaGerenciamentoTickets.entities.AuthenticationDTO;
import com.yago.sistemaGerenciamentoTickets.entities.LoginResponseDTO;
import com.yago.sistemaGerenciamentoTickets.entities.RegisterDTO;
import com.yago.sistemaGerenciamentoTickets.entities.User;
import com.yago.sistemaGerenciamentoTickets.infra.security.TokenService;
import com.yago.sistemaGerenciamentoTickets.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository repository;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data){

        var usernamePassword = new UsernamePasswordAuthenticationToken(data.matricula(), data.senha());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data){
        if(this.repository.findByMatricula(data.matricula()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.senha());
        User newUser = new User(data.matricula(), encryptedPassword, data.role());

        this.repository.save(newUser);
        System.out.println(a);
        return ResponseEntity.ok().build();
    }
}
