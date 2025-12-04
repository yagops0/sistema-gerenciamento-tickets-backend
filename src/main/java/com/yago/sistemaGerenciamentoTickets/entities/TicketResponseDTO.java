package com.yago.sistemaGerenciamentoTickets.entities;

public record TicketResponseDTO(String descricao, StatusTicket statusTicket, UserResponseDTO user) {

    public TicketResponseDTO(Ticket ticket){

        this(ticket.getDescricao(), ticket.getStatus(), new UserResponseDTO(ticket.getUsers()));
    }

}
