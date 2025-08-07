package com.senac.provaSpring.controladores;

import com.senac.provaSpring.DTOS.PostagensResponseDTO;
import com.senac.provaSpring.DTOS.UsuarioRequestDTO;
import com.senac.provaSpring.DTOS.UsuarioResponseDTO;
import com.senac.provaSpring.Entidades.Postagens;
import com.senac.provaSpring.Entidades.Usuarios;
import com.senac.provaSpring.Repositorios.PostagensRepositorio;
import com.senac.provaSpring.Repositorios.UsuariosRepositorio;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuariosControlador {
    private final UsuariosRepositorio usuariosRepositorio;
    private final PostagensRepositorio postagensRepositorio;

    public UsuariosControlador(UsuariosRepositorio usuariosRepositorio, PostagensRepositorio postagensRepositorio) {
        this.usuariosRepositorio = usuariosRepositorio;
        this.postagensRepositorio = postagensRepositorio;
    }

    @PostMapping
    public UsuarioRequestDTO adicionarUsuario(@RequestBody UsuarioRequestDTO dto) {
        Usuarios usuarios = new Usuarios();
        usuarios.setNome(dto.getNome());
        usuarios.setEmail((dto.getEmail()));
        usuarios.setDataCadastro(LocalDate.now());
        usuariosRepositorio.save(usuarios);
        return dto;
    }
    @GetMapping
    public List<UsuarioResponseDTO> listarUsuarios(){
        List<Usuarios> usuarios = usuariosRepositorio.findAll();
        List<UsuarioResponseDTO> dto = new ArrayList<>();

        for (Usuarios usuario : usuarios){
            dto.add(new UsuarioResponseDTO(usuario));
        }
        return dto;
    }

    @GetMapping("/{idUsuario}")
    public UsuarioResponseDTO buscarUsuario(@PathVariable Integer idUsuario){
        Usuarios usuarios = usuariosRepositorio.findById(idUsuario).orElseThrow();
        UsuarioResponseDTO dto = new UsuarioResponseDTO(usuarios);

        return dto;
    }
    @PutMapping("/{idUsuario}")
    public UsuarioRequestDTO alterarUsuario(@PathVariable Integer idUsuario, @RequestBody UsuarioRequestDTO dto){
        Usuarios usuarios = usuariosRepositorio.findById(idUsuario).orElseThrow();
        usuarios.setNome(dto.getNome());
        usuarios.setEmail(dto.getEmail());
        usuariosRepositorio.save(usuarios);
        return dto;

    }
    @DeleteMapping("/{idUsuario}")
    public UsuarioResponseDTO deletarUsuario(@PathVariable Integer idUsuario){
        Usuarios usuarios = usuariosRepositorio.findById(idUsuario).orElseThrow();
        UsuarioResponseDTO dto = new UsuarioResponseDTO(usuarios);
        usuariosRepositorio.deleteById(idUsuario);
        return dto;
    }
    @GetMapping("/{idUsuario}/postagens")
    public List<PostagensResponseDTO> buscarPostagensUsuario(@PathVariable Integer idUsuario){
        Usuarios usuarios = usuariosRepositorio.findById(idUsuario).orElseThrow();
        List<PostagensResponseDTO> dto = new ArrayList<>();
        List<Postagens> postagens = usuarios.getPostagens();
        for (Postagens p : postagens){
            dto.add(new PostagensResponseDTO(p));
        }
        return dto;

    }
}

