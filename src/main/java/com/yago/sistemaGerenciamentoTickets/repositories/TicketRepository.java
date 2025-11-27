package com.yago.sistemaGerenciamentoTickets.repositories;

import com.yago.sistemaGerenciamentoTickets.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

}
