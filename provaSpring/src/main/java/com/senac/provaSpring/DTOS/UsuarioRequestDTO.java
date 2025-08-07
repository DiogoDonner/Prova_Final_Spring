package com.senac.provaSpring.DTOS;

import com.senac.provaSpring.Entidades.Usuarios;

public class UsuarioRequestDTO {
    private String nome;
    private String email;

    public UsuarioRequestDTO(Usuarios usuarios) {
        this.nome=usuarios.getNome();
        this.email=usuarios.getEmail();
    }

    public UsuarioRequestDTO() {
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }
}
