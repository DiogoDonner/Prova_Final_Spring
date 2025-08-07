package com.senac.provaSpring.Repositorios;

import com.senac.provaSpring.Entidades.Curtidas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurtidasRepositorio extends JpaRepository<Curtidas, Integer> {
}
