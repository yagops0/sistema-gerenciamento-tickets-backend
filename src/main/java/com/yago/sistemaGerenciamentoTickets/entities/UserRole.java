package com.yago.sistemaGerenciamentoTickets.entities;

public enum UserRole {
    ROLE_ANALISTA("ROLE_ANALISTA"),
    ROLE_GERENTE("ROLE_GERENTE");

    private String role;

    UserRole(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }
}
