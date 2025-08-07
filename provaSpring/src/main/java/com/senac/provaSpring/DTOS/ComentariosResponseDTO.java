package com.senac.provaSpring.DTOS;

import com.senac.provaSpring.Entidades.Comentarios;

import java.time.LocalDate;

public class ComentariosResponseDTO {
    public class comentariosResponseDTO {
        private String conteudo;
        private String autor;
        private String postagem;
        private LocalDate dataCriacao;

        public comentariosResponseDTO(Comentarios comentarios) {
            this.conteudo = comentarios.getConteudo();
            this.autor = comentarios.getAutor().getNome();
            this.postagem = comentarios.getPostagens().getConteudo();
        }

        public comentariosResponseDTO() {
        }
    }
}
