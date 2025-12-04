package com.yago.sistemaGerenciamentoTickets.entities;

public record TicketAnalistaResponseDTO(String descricao, StatusTicket statusTicket) {
    public TicketAnalistaResponseDTO(Ticket ticket){
        this(ticket.getDescricao(), ticket.getStatus());
    }
}
