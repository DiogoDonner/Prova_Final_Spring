package com.senac.provaSpring.controladores;

import com.senac.provaSpring.DTOS.PostagensRequestDTO;
import com.senac.provaSpring.DTOS.PostagensResponseDTO;
import com.senac.provaSpring.Entidades.Postagens;
import com.senac.provaSpring.Entidades.Usuarios;
import com.senac.provaSpring.Repositorios.PostagensRepositorio;
import com.senac.provaSpring.Repositorios.UsuariosRepositorio;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/postagens")
public class PostagensControlador {
    private final PostagensRepositorio postagensRepositorio;
    private final UsuariosRepositorio usuariosRepositorio;

    public PostagensControlador(PostagensRepositorio postagensRepositorio, UsuariosRepositorio usuariosRepositorio) {
        this.postagensRepositorio = postagensRepositorio;
        this.usuariosRepositorio = usuariosRepositorio;
    }

    @PostMapping
    public PostagensRequestDTO adicionarPostagem(@RequestBody PostagensRequestDTO dto) {
        Postagens postagens = new Postagens();
        Integer idUsuario = dto.getIdUsuario();
        postagens.setAutor(usuariosRepositorio.findById(idUsuario).orElseThrow());
        postagens.setConteudo(dto.getConteudo());
        postagens.setDataCriacao(LocalDateTime.now());
        postagensRepositorio.save(postagens);
        return dto;
    }

    @GetMapping
    public List<PostagensResponseDTO> listarPostagens() {
        List<Postagens> postagensList = postagensRepositorio.findAll();
        List<PostagensResponseDTO> dtoList = new ArrayList<>();
        for (Postagens p : postagensList) {
            dtoList.add(new PostagensResponseDTO(p));
        }
        return dtoList;
    }

    @GetMapping("/{idPostagem}")
    public PostagensResponseDTO buscarPostagem(@PathVariable Integer idPostagem) {
        Postagens postagens = postagensRepositorio.findById(idPostagem).orElseThrow();
        PostagensResponseDTO dto = new PostagensResponseDTO(postagens);
        return dto;
    }

    @GetMapping("/usuario/{idUsuario}")
    public List<PostagensResponseDTO> buscarPostagensUsuario(@PathVariable Integer idUsuario) {
        List<Postagens> postagensList = postagensRepositorio.findAll();
        Usuarios usuarios = usuariosRepositorio.findById(idUsuario).orElseThrow();
        List<PostagensResponseDTO> dtoList = new ArrayList<>();
        for (Postagens p : postagensList) {
            if (p.getId() == idUsuario) {
                dtoList.add(new PostagensResponseDTO(p));
            }
        }
        return dtoList;
    }
}
