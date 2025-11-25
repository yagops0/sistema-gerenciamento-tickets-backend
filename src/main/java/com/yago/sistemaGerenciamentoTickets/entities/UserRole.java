package com.yago.sistemaGerenciamentoTickets.entities;

public enum UserRole {
    ANALISTA("ROLE_ANALISTA"),
    GERENTE("ROLE_GERENTE");

    private String role;

    UserRole(String role){
        this.role = role;
    }

    public String getRole(){

        return this.role;
    }
}
