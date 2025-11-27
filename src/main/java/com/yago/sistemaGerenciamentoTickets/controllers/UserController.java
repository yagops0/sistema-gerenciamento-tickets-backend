package com.yago.sistemaGerenciamentoTickets.controllers;

import com.yago.sistemaGerenciamentoTickets.entities.User;
import com.yago.sistemaGerenciamentoTickets.entities.UserResponseDTO;
import com.yago.sistemaGerenciamentoTickets.repositories.UserRepository;
import com.yago.sistemaGerenciamentoTickets.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("analista")
    public String testeToken(){
        return "FUNCIONOU ANALISTA";
    }

    @GetMapping("gerente")
    public String testeGerente(){
        return "FUNCIONOU GERENTE";
    }

    @GetMapping("gerente/dashboard/analistas")
    public ResponseEntity getAnalistas(){
        List<UserResponseDTO> analistas = userService.retornarAnalistas();

        return ResponseEntity.ok(analistas);
    }

    @GetMapping("public/users")
    public ResponseEntity getUsers(){
        List<UserResponseDTO> usuarios = userService.retornarTodos();

        return ResponseEntity.ok(usuarios);
    }
}
