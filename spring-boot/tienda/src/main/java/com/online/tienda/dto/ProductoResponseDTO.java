package com.online.tienda.dto;

import lombok.Builder;

/** ProductoResponseDTO. */
@Builder
public record ProductoResponseDTO(Long id, String nombre, int stock) {}
