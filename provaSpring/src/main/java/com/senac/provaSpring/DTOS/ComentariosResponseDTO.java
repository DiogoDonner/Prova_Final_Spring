package com.senac.provaSpring.DTOS;

import com.senac.provaSpring.Entidades.Comentarios;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ComentariosResponseDTO {

        private String conteudo;
        private String autor;
        private String postagem;
        private LocalDateTime dataCriacao;

        public ComentariosResponseDTO(Comentarios comentarios) {
            this.conteudo = comentarios.getConteudo();
            this.autor = comentarios.getAutor().getNome();
            this.postagem = comentarios.getPostagens().getConteudo();
            this.dataCriacao = comentarios.getDataCriacao();
        }

        public ComentariosResponseDTO() {
        }

    public String getConteudo() {
        return conteudo;
    }

    public String getAutor() {
        return autor;
    }

    public String getPostagem() {
        return postagem;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }
}

