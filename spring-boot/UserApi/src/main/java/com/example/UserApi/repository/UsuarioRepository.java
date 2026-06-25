package com.example.UserApi.repository;

import com.example.UserApi.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/** UsuarioRepository. */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {}
