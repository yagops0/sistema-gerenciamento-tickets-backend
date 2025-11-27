package com.yago.sistemaGerenciamentoTickets.repositories;

import com.yago.sistemaGerenciamentoTickets.entities.Ticket;
import com.yago.sistemaGerenciamentoTickets.entities.TicketResponseDTO;
import com.yago.sistemaGerenciamentoTickets.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

    List<Ticket> findByUsers(User user);

}
