package com.senac.provaSpring.DTOS;

import com.senac.provaSpring.Entidades.Postagens;

import java.time.LocalDate;
import java.util.List;

public class PostagensResponseDTO {
    private String conteudo;
    private LocalDate dataCriacao;
    private String autor;

    public PostagensResponseDTO(Postagens postagens) {
        this.conteudo = postagens.getConteudo();
        this.dataCriacao = LocalDate.from(postagens.getDataCriacao());
        this.autor = postagens.getAutor().getNome();
    }

    public PostagensResponseDTO() {
    }


    public String getConteudo() {
        return conteudo;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public String getAutor() {
        return autor;
    }
}
