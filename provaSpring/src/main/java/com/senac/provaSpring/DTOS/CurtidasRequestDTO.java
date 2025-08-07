package com.senac.provaSpring.DTOS;

import com.senac.provaSpring.Entidades.Curtidas;

public class CurtidasRequestDTO {
    private Integer idUsuario;
    private Integer idPostagem;

    public CurtidasRequestDTO(Curtidas curtidas) {
        this.idPostagem= curtidas.getPostagens().getId();
        this.idUsuario = curtidas.getUsuario().getId();
    }

    public CurtidasRequestDTO() {
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public Integer getIdPostagem() {
        return idPostagem;
    }
}
