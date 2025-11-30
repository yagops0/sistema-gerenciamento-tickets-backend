package com.yago.sistemaGerenciamentoTickets.controllers;

import com.yago.sistemaGerenciamentoTickets.entities.Solucao;
import com.yago.sistemaGerenciamentoTickets.entities.SolucaoResponseDTO;
import com.yago.sistemaGerenciamentoTickets.entities.TopicoSolucoes;
import com.yago.sistemaGerenciamentoTickets.repositories.SolucaoRepository;
import com.yago.sistemaGerenciamentoTickets.services.SolucaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/public")
public class SolucaoController {

    @Autowired
    SolucaoService solucaoService;

    @Autowired
    SolucaoRepository solucaoRepository;

    @PostMapping("solucoes/register")
    public ResponseEntity registrarSolucao(@RequestBody List<Solucao> solucoes){

        this.solucaoRepository.saveAll(solucoes);

        return ResponseEntity.ok().build();

    }

    @GetMapping("/solucoes/busca")
    public List<SolucaoResponseDTO> retonarSolucoesTopicos(@RequestParam(value = "topico", defaultValue = "nenhum") TopicoSolucoes topico){
        List<SolucaoResponseDTO> solucoes = this.solucaoService.getSolucoesByTopico(topico);

        return solucoes;
    }

    @GetMapping("/solucoes")
    public List<SolucaoResponseDTO> retornarSolucoes(){
        List<SolucaoResponseDTO> solucoes = this.solucaoService.getSolucoes();

        return solucoes;
    }
}
