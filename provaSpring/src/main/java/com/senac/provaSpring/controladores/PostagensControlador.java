package com.senac.provaSpring.controladores;

import com.senac.provaSpring.DTOS.ComentariosResponseDTO;
import com.senac.provaSpring.DTOS.CurtidasResponseDTO;
import com.senac.provaSpring.DTOS.PostagensRequestDTO;
import com.senac.provaSpring.DTOS.PostagensResponseDTO;
import com.senac.provaSpring.Entidades.Comentarios;
import com.senac.provaSpring.Entidades.Curtidas;
import com.senac.provaSpring.Entidades.Postagens;
import com.senac.provaSpring.Entidades.Usuarios;
import com.senac.provaSpring.Repositorios.ComentariosRepositorio;
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
    private final ComentariosRepositorio comentariosRepositorio;

    public PostagensControlador(PostagensRepositorio postagensRepositorio, UsuariosRepositorio usuariosRepositorio, ComentariosRepositorio comentariosRepositorio) {
        this.postagensRepositorio = postagensRepositorio;
        this.usuariosRepositorio = usuariosRepositorio;
        this.comentariosRepositorio = comentariosRepositorio;
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
    @GetMapping("/{idPostagem}/comentarios")
    public List<ComentariosResponseDTO> buscarComentariosPublicacao(@PathVariable Integer idPostagem){
        Postagens postagens = postagensRepositorio.findById(idPostagem).orElseThrow();
        List<ComentariosResponseDTO> dtoList = new ArrayList<>();
        List<Comentarios> comentariosList = postagens.getComentarios();
        for (Comentarios c:comentariosList){
            dtoList.add(new ComentariosResponseDTO(c));
        }
        return dtoList;
    }
    @GetMapping("/{idPostagem}/curtidas")
    public List<CurtidasResponseDTO> listarUsuariosCurtidasPostagem(@PathVariable Integer idPostagem){
        Postagens postagens = postagensRepositorio.findById(idPostagem).orElseThrow();
        List<CurtidasResponseDTO> dtoList = new ArrayList<>();
        List<Curtidas> curtidasList = postagens.getCurtidas();
        for (Curtidas c: curtidasList){
            dtoList.add(new CurtidasResponseDTO(c));
        }
        return dtoList;
    }
}
