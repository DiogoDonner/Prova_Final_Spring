package com.senac.provaSpring.DTOS;

import com.senac.provaSpring.Entidades.Comentarios;
import com.senac.provaSpring.Entidades.Postagens;
import com.senac.provaSpring.Entidades.Usuarios;

import java.util.ArrayList;
import java.util.List;

public class UsuarioResponseDTO {
    private Integer id;
    private String nome;
    private List<String> postagens;
    private List<String> comentarios;

    public UsuarioResponseDTO(Usuarios usuarios) {
        this.id = usuarios.getId();
        this.nome= usuarios.getNome();
        this.postagens = new ArrayList<>();
        for (Postagens p : usuarios.getPostagens()){
            this.postagens.add(p.getConteudo());
        }
        this.comentarios = new ArrayList<>();
        for (Comentarios c : usuarios.getComentarios()){
            this.comentarios.add(c.getConteudo());
        }
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public List<String> getPostagens() {
        return postagens;
    }

    public List<String> getComentarios() {
        return comentarios;
    }
}
