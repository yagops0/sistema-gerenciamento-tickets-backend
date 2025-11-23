package com.yago.sistemaGerenciamentoTickets.controllers;

import com.yago.sistemaGerenciamentoTickets.entities.Solucao;
import com.yago.sistemaGerenciamentoTickets.repositories.SolucaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("public")
public class SolucaoController {

    @Autowired
    private SolucaoRepository repository;

    @PostMapping("/solucoes/register")
    public ResponseEntity registrarSolucao(@RequestBody Solucao data){

        this.repository.save(data);

        return ResponseEntity.ok().build();

    }
    @GetMapping("/solucoes")
    public String retornarSolucoes(){
        return "solucoes";
    }
}
