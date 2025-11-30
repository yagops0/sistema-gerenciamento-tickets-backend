package com.yago.sistemaGerenciamentoTickets.services;

import com.yago.sistemaGerenciamentoTickets.entities.SolucaoResponseDTO;
import com.yago.sistemaGerenciamentoTickets.entities.TopicoSolucoes;
import com.yago.sistemaGerenciamentoTickets.repositories.SolucaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SolucaoService {

    @Autowired
    private SolucaoRepository solucaoRepository;

    public List<SolucaoResponseDTO> getSolucoes(){

        return this.solucaoRepository.findAll().stream().map(SolucaoResponseDTO::new).toList();
    }

    public List<SolucaoResponseDTO> getSolucoesByTopico(TopicoSolucoes topicoSolucoes){

        return this.solucaoRepository.findByTopico(topicoSolucoes).stream().map(SolucaoResponseDTO::new).toList();
    }
}
