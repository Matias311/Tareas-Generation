package com.online.tienda.repository;

import com.online.tienda.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

/** ClienteRepository. */
public interface ClienteRepository extends JpaRepository<Cliente, Long> {}
