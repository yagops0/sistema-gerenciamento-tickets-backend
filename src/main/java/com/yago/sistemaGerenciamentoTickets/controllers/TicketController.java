package com.yago.sistemaGerenciamentoTickets.controllers;


import com.yago.sistemaGerenciamentoTickets.entities.TicketAnalistaResponseDTO;
import com.yago.sistemaGerenciamentoTickets.entities.TicketResponseDTO;
import com.yago.sistemaGerenciamentoTickets.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/")
public class TicketController {

    @Autowired
    TicketService ticketService;

    @GetMapping("gerente/dashboard/tickets")
    public ResponseEntity retornarTickets(){

        List<TicketResponseDTO> tickets = this.ticketService.getTickets();

        return ResponseEntity.ok(tickets);
    }

    @GetMapping("analista/tickets")
    public ResponseEntity getTicketsAnalista(Principal principal){

        String matriculaLogada = principal.getName();

        List<TicketAnalistaResponseDTO> tickets = ticketService.getTicketsByResponsavel(matriculaLogada);

        return ResponseEntity.ok(tickets);
    }
}
