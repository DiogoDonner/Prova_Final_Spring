package com.senac.provaSpring.controladores;

import com.senac.provaSpring.DTOS.ComentariosRequestDTO;
import com.senac.provaSpring.Entidades.Comentarios;
import com.senac.provaSpring.Entidades.Postagens;
import com.senac.provaSpring.Entidades.Usuarios;
import com.senac.provaSpring.Repositorios.ComentariosRepositorio;
import com.senac.provaSpring.Repositorios.PostagensRepositorio;
import com.senac.provaSpring.Repositorios.UsuariosRepositorio;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/comentarios")
public class ComentariosControlador {
    private final ComentariosRepositorio comentariosRepositorio;
    private final PostagensRepositorio postagensRepositorio;
    private final UsuariosRepositorio usuariosRepositorio;

    public ComentariosControlador(ComentariosRepositorio comentariosRepositorio, PostagensRepositorio postagensRepositorio, UsuariosRepositorio usuariosRepositorio) {
        this.comentariosRepositorio = comentariosRepositorio;
        this.postagensRepositorio = postagensRepositorio;
        this.usuariosRepositorio = usuariosRepositorio;
    }

    @PostMapping
    public ComentariosRequestDTO adicionarComentario(@RequestBody ComentariosRequestDTO dto){
        Comentarios comentarios = new Comentarios();
        Usuarios usuarios = usuariosRepositorio.findById(dto.getIdAutor()).orElseThrow();
        Postagens postagens = postagensRepositorio.findById(dto.getIdPostagem()).orElseThrow();
        comentarios.setDataCriacao(LocalDateTime.now());
        comentarios.setConteudo(dto.getConteudo());
        comentarios.setAutor(usuarios);
        comentarios.setPostagens(postagens);
        comentariosRepositorio.save(comentarios);
        return dto;
    }



}
