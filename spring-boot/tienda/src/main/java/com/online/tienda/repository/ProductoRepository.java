package com.online.tienda.repository;

import com.online.tienda.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

/** ProductoRepository. */
public interface ProductoRepository extends JpaRepository<Producto, Long> {}
