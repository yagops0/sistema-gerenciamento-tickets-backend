package com.yago.sistemaGerenciamentoTickets.entities;

public record UserResponseDTO(String matricula, UserRole role) {

    public UserResponseDTO(User user){
        this(user.getMatricula(), user.getRole());
    }
}
