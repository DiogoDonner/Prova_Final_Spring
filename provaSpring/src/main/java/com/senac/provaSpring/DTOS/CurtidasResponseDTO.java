package com.senac.provaSpring.DTOS;

import com.senac.provaSpring.Entidades.Curtidas;

public class CurtidasResponseDTO {
    private String usuario;

    public CurtidasResponseDTO(Curtidas curtidas) {
        this.usuario=curtidas.getUsuario().getNome();
    }

    public CurtidasResponseDTO() {

    }

    public String getUsuario() {
        return usuario;
    }
}

