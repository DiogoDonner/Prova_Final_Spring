package com.senac.provaSpring.DTOS;

import com.senac.provaSpring.Entidades.Comentarios;
import com.senac.provaSpring.Entidades.Postagens;
import com.senac.provaSpring.Entidades.Usuarios;

import java.util.ArrayList;
import java.util.List;

public class UsuarioResponseDTO {
    private String nome;
    private List<PostagensResponseDTO> postagens;
    private List<ComentariosResponseDTO> comentarios;

    public UsuarioResponseDTO(Usuarios usuarios) {
        this.nome= usuarios.getNome();
        this.postagens = new ArrayList<>();
        for (Postagens p : usuarios.getPostagens()){
            this.postagens.add(new PostagensResponseDTO(p));
        }
        this.comentarios = new ArrayList<>();
        for (Comentarios c : usuarios.getComentarios()){
            this.comentarios.add(new ComentariosResponseDTO(c));
        }
    }


    public String getNome() {
        return nome;
    }

    public List<PostagensResponseDTO> getPostagens() {
        return postagens;
    }

    public List<ComentariosResponseDTO> getComentarios() {
        return comentarios;
    }
}
