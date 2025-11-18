package com.yago.sistemaGerenciamentoTickets.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "matricula", nullable = false)
    private String matricula;
    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "cargo", nullable = false)
    private String cargo;
    @Column(name = "senha", nullable = false)
    private String senha;
}
