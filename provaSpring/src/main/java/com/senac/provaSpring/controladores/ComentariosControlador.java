package com.senac.provaSpring.controladores;

import com.senac.provaSpring.DTOS.ComentariosRequestDTO;
import com.senac.provaSpring.Repositorios.ComentariosRepositorio;
import com.senac.provaSpring.Repositorios.PostagensRepositorio;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comentarios")
public class ComentariosControlador {
    private final ComentariosRepositorio comentariosRepositorio;
    private final PostagensRepositorio postagensRepositorio;

    public ComentariosControlador(ComentariosRepositorio comentariosRepositorio, PostagensRepositorio postagensRepositorio) {
        this.comentariosRepositorio = comentariosRepositorio;
        this.postagensRepositorio = postagensRepositorio;
    }

    @PostMapping
    public ComentariosRequestDTO adicionarComentario(@RequestBody ComentariosRequestDTO dto){
        return null;
    }


}
