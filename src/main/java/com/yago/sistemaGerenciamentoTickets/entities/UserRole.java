package com.yago.sistemaGerenciamentoTickets.entities;

public enum UserRole {
    ADMIN("ADMIN"),
    ANALISTA("ANALISTA"),
    GERENTE("GERENTE");

    private String role;

    UserRole(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }
}
