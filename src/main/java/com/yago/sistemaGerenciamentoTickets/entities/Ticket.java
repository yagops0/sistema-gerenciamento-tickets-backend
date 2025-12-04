package com.yago.sistemaGerenciamentoTickets.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tickets")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "descricao", nullable = false)
    private String descricao;
    @Column(name = "status", nullable = false)
    private StatusTicket status;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User users;
}
