package com.yago.sistemaGerenciamentoTickets.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "solucoes")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Solucoes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "titulo", nullable = false)
    private String titulo;
    @Column(name = "solucao", nullable = false)
    private String solucao;
    @Column(name = "descricao", nullable = false)
    private String descricao;

}
