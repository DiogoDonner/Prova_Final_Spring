package com.senac.provaSpring.DTOS;

import com.senac.provaSpring.Entidades.Postagens;

public class PostagensRequestDTO {
    private String conteudo;
    private Integer idUsuario;

    public PostagensRequestDTO(Postagens postagens) {
        this.conteudo=postagens.getConteudo();
        this.idUsuario=postagens.getAutor().getId();
    }

    public PostagensRequestDTO() {
    }

    public String getConteudo() {
        return conteudo;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }
}
