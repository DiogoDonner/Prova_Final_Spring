package com.senac.provaSpring.Entidades;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Postagens {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String conteudo;
    private LocalDateTime dataCriacao;
    @ManyToOne
    @JoinColumn(name = "autor")
    private Usuarios autor;
    @OneToMany(mappedBy = "postagens",cascade = CascadeType.ALL)
    private List<Curtidas> curtidas;
    @OneToMany(mappedBy = "postagens",cascade = CascadeType.ALL)
    private List<Comentarios> comentarios;

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

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Usuarios getAutor() {
        return autor;
    }

    public void setAutor(Usuarios autor) {
        this.autor = autor;
    }

    public List<Curtidas> getCurtidas() {
        return curtidas;
    }

    public void setCurtidas(List<Curtidas> curtidas) {
        this.curtidas = curtidas;
    }

    public List<Comentarios> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentarios> comentarios) {
        this.comentarios = comentarios;
    }
}
