package com.online.tienda.mapper;

import com.online.tienda.dto.ProductoRequestDTO;
import com.online.tienda.dto.ProductoResponseDTO;
import com.online.tienda.model.Producto;
import org.springframework.stereotype.Component;

/** ProductoMapper. */
@Component
public class ProductoMapper {

  public Producto toEntity(ProductoRequestDTO dto) {
    return new Producto(
        dto.nombre(), dto.descripcion(), dto.precio(), dto.stock(), dto.categoria());
  }

  public ProductoResponseDTO toDto(Producto entity) {
    return ProductoResponseDTO.builder()
        .id(entity.getId())
        .nombre(entity.getNombre())
        .stock(entity.getStock())
        .build();
  }
}
