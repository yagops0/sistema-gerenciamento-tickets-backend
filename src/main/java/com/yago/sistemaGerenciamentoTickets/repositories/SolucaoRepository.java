package com.yago.sistemaGerenciamentoTickets.repositories;

import com.yago.sistemaGerenciamentoTickets.entities.Solucao;
import com.yago.sistemaGerenciamentoTickets.entities.TopicoSolucoes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SolucaoRepository extends JpaRepository<Solucao, Integer> {

    List<Solucao> findByTopico(TopicoSolucoes topicoSolucoes);
}
