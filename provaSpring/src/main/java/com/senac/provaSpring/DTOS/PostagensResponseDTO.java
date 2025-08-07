package com.senac.provaSpring.DTOS;

import com.senac.provaSpring.Entidades.Postagens;

import java.time.LocalDateTime;

public class PostagensResponseDTO {
    private String conteudo;
    private LocalDateTime dataCriacao;
    private String autor;
    private int quantidadeCurtidas;

    public PostagensResponseDTO(Postagens postagens) {
        this.conteudo = postagens.getConteudo();
        this.dataCriacao = postagens.getDataCriacao();
        this.autor = postagens.getAutor().getNome();
        this.quantidadeCurtidas = postagens.getCurtidas().size();
    }

    public PostagensResponseDTO() {
    }


    public String getConteudo() {
        return conteudo;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public String getAutor() {
        return autor;
    }

    public int getQuantidadeCurtidas() {
        return quantidadeCurtidas;
    }
}
