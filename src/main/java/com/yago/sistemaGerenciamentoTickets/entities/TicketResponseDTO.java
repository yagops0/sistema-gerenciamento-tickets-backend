package com.yago.sistemaGerenciamentoTickets.entities;

public record TicketResponseDTO(String descricao, UserResponseDTO user) {

    public TicketResponseDTO(Ticket ticket){

        this(ticket.getDescricao(), new UserResponseDTO(ticket.getUsers()));
    }

}
