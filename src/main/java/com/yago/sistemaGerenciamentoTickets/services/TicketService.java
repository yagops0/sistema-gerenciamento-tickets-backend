package com.yago.sistemaGerenciamentoTickets.services;

import com.yago.sistemaGerenciamentoTickets.entities.Ticket;
import com.yago.sistemaGerenciamentoTickets.entities.TicketResponseDTO;
import com.yago.sistemaGerenciamentoTickets.entities.User;
import com.yago.sistemaGerenciamentoTickets.entities.UserResponseDTO;
import com.yago.sistemaGerenciamentoTickets.repositories.TicketRepository;
import com.yago.sistemaGerenciamentoTickets.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private UserService userService;

    public List<TicketResponseDTO> getTickets(){

        return this.ticketRepository.findAll().stream().map(TicketResponseDTO::new).toList();
    }

    public List<TicketResponseDTO> getTicketsByResponsavel(String matriculaUser){

        User analista = this.userRepository.findByMatricula(matriculaUser);

        return this.ticketRepository.findByUsers(analista).stream().map(TicketResponseDTO::new).toList();

    }


}
