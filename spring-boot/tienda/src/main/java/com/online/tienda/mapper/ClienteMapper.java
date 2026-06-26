package com.online.tienda.mapper;

import com.online.tienda.dto.ClienteRequestDTO;
import com.online.tienda.dto.ClienteResponseDTO;
import com.online.tienda.model.Cliente;
import org.springframework.stereotype.Component;

/** ClienteMapper. */
@Component
public class ClienteMapper {

  public Cliente toEntity(ClienteRequestDTO dto) {
    return new Cliente(dto.nombre(), dto.apellido(), dto.correo(), dto.telefono(), dto.direction());
  }

  public ClienteResponseDTO toDto(Cliente entity) {
    return ClienteResponseDTO.builder()
        .id(entity.getId())
        .nombre(entity.getNombre())
        .correo(entity.getCorreo())
        .build();
  }
}
