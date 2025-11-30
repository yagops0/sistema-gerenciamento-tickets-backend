package com.yago.sistemaGerenciamentoTickets.entities;

public record SolucaoResponseDTO(String titulo, String descricao, TopicoSolucoes topico) {

    public SolucaoResponseDTO(Solucao solucao){
        this(solucao.getTitulo(), solucao.getDescricao(), solucao.getTopico());
    }
}
