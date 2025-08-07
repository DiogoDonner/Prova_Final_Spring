package com.senac.provaSpring.Repositorios;

import com.senac.provaSpring.Entidades.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuariosRepositorio extends JpaRepository<Usuarios, Integer> {
}
