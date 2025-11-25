package com.yago.sistemaGerenciamentoTickets.entities;

public record UserResponseDTO(int id, String matricula, UserRole role) {

    public UserResponseDTO(User user){
        this(user.getId(), user.getMatricula(), user.getRole());
    }
}
