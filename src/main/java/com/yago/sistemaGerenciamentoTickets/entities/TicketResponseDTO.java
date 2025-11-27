package com.yago.sistemaGerenciamentoTickets.entities;

public record TicketResponseDTO(int id, String descricao, UserResponseDTO user) {

    public TicketResponseDTO(Ticket ticket){

        this(ticket.getId(), ticket.getDescricao(), new UserResponseDTO(ticket.getUsers()));
    }

}
