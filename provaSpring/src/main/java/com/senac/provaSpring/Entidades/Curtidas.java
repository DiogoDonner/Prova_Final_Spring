package com.senac.provaSpring.Entidades;

import jakarta.persistence.*;

@Entity
public class Curtidas {
    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "usuario")
    private Usuarios usuario;
    @ManyToOne
    @JoinColumn(name = "postagens")
    private Postagens postagens;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public Postagens getPostagens() {
        return postagens;
    }

    public void setPostagens(Postagens postagens) {
        this.postagens = postagens;
    }
}
