package com.senac.provaSpring.Entidades;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Usuarios {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    private String nome;
    private String email;
    private LocalDate dataCadastro;
    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL)
    private List<Postagens> postagens;
    @OneToMany(mappedBy = "autor",cascade = CascadeType.ALL)
    private List<Comentarios> comentarios;
    @OneToMany(mappedBy = "usuario", cascade =  CascadeType.ALL)
    List<Curtidas> curtidas;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public List<Postagens> getPostagens() {
        return postagens;
    }

    public void setPostagens(List<Postagens> postagens) {
        this.postagens = postagens;
    }

    public List<Comentarios> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentarios> comentarios) {
        this.comentarios = comentarios;
    }

    public List<Curtidas> getCurtidas() {
        return curtidas;
    }

    public void setCurtidas(List<Curtidas> curtidas) {
        this.curtidas = curtidas;
    }
}
