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
public class Solucao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "titulo", nullable = false)
    @Convert(converter = SolucaoAttributeConverter.class)
    private String titulo;

    @Column(name = "descricao", nullable = false)
    @Convert(converter = SolucaoAttributeConverter.class)
    private String descricao;
    @Column(name = "topico", nullable = false)
    private TopicoSolucoes topico;

    public Solucao(String titulo, String descricao, TopicoSolucoes topico){
        this.titulo = titulo;
        this.descricao = descricao;
        this.topico = topico;
    }

}
