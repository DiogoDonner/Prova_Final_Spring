package com.senac.provaSpring.DTOS;

import com.senac.provaSpring.Entidades.Comentarios;

import java.time.LocalDate;

public class ComentariosRequestDTO {
    private String conteudo;
    private Integer idAutor;
    private Integer idPostagem;

    public ComentariosRequestDTO(Comentarios comentarios) {
        this.conteudo = comentarios.getConteudo();
        this.idAutor = comentarios.getAutor().getId();
        this.idPostagem = comentarios.getPostagens().getId();
    }

    public ComentariosRequestDTO() {
    }

    public String getConteudo() {
        return conteudo;
    }

    public Integer getIdAutor() {
        return idAutor;
    }

    public Integer getIdPostagem() {
        return idPostagem;
    }
}
