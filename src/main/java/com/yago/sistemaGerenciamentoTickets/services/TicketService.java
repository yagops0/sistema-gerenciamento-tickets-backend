package com.yago.sistemaGerenciamentoTickets.services;

import com.yago.sistemaGerenciamentoTickets.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;
}
