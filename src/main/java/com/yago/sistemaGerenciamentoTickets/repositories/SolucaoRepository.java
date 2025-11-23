package com.yago.sistemaGerenciamentoTickets.repositories;

import com.yago.sistemaGerenciamentoTickets.entities.Solucao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolucaoRepository extends JpaRepository<Solucao, Integer> {
}
