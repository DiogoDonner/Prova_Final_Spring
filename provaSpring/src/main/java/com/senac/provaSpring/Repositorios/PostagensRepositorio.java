package com.senac.provaSpring.Repositorios;

import com.senac.provaSpring.Entidades.Postagens;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostagensRepositorio extends JpaRepository<Postagens, Integer> {
}
