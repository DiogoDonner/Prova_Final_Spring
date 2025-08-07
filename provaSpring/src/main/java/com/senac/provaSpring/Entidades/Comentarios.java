package com.senac.provaSpring.Entidades;

import jakarta.persistence.*;

@Entity
public class Comentarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String conteudo;
    @ManyToOne
    @JoinColumn(name = "autor")
    private Usuarios autor;
    @ManyToOne
    @JoinColumn(name = "postagens")
    private Postagens postagens;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Usuarios getAutor() {
        return autor;
    }

    public void setAutor(Usuarios autor) {
        this.autor = autor;
    }

    public Postagens getPostagens() {
        return postagens;
    }

    public void setPostagens(Postagens postagens) {
        this.postagens = postagens;
    }
}
