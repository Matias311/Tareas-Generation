package com.online.tienda.dto;

import lombok.Builder;

/** ClienteResponseDTO. */
@Builder
public record ClienteResponseDTO(Long id, String nombre, String correo) {}
