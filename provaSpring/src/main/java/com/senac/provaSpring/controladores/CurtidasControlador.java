package com.senac.provaSpring.controladores;

import com.senac.provaSpring.DTOS.CurtidasRequestDTO;
import com.senac.provaSpring.Entidades.Curtidas;
import com.senac.provaSpring.Entidades.Postagens;
import com.senac.provaSpring.Entidades.Usuarios;
import com.senac.provaSpring.Repositorios.CurtidasRepositorio;
import com.senac.provaSpring.Repositorios.PostagensRepositorio;
import com.senac.provaSpring.Repositorios.UsuariosRepositorio;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/curtidas")
public class CurtidasControlador {
private final CurtidasRepositorio curtidasRepositorio;
private final UsuariosRepositorio usuariosRepositorio;
private final PostagensRepositorio postagensRepositorio;

    public CurtidasControlador(CurtidasRepositorio curtidasRepositorio, UsuariosRepositorio usuariosRepositorio, PostagensRepositorio postagensRepositorio) {
        this.curtidasRepositorio = curtidasRepositorio;
        this.usuariosRepositorio = usuariosRepositorio;
        this.postagensRepositorio = postagensRepositorio;
    }

    @PostMapping
    public CurtidasRequestDTO curtirPostagem(@RequestBody CurtidasRequestDTO dto){
        Curtidas curtidas = new Curtidas();
        Usuarios usuarios = usuariosRepositorio.findById(dto.getIdUsuario()).orElseThrow();
        Postagens postagens = postagensRepositorio.findById(dto.getIdPostagem()).orElseThrow();
        curtidas.setUsuario(usuarios);
        curtidas.setPostagens(postagens);
        curtidasRepositorio.save(curtidas);

        return dto;
    }
}
