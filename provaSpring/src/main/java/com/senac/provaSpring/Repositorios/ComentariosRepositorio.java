package com.senac.provaSpring.Repositorios;

import com.senac.provaSpring.Entidades.Comentarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentariosRepositorio extends JpaRepository<Comentarios, Integer> {
}
