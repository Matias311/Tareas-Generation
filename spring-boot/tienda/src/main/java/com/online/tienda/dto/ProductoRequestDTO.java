package com.online.tienda.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;

/** ProductoRequestDTO. */
@Builder
public record ProductoRequestDTO(
    @NotBlank(message = "El nombre del producto debe de tener un valor")
        @Size(
            min = 2,
            max = 50,
            message =
                "El nombre del producto no puede ser menor a 2 y no puede ser mayor a 50"
                    + " caracteres")
        String nombre,
    String descripcion,
    @Min(value = 0, message = "El precio no puede ser menor a 0") Long precio,
    @Min(value = 0, message = "El stock no puede ser menor a 0") int stock,
    @NotBlank(message = "La categoria debe de tener un valor")
        @Size(
            min = 2,
            max = 50,
            message = "La categoria no puede ser menor a 2 y no puede ser mayor a 50 caracteres")
        String categoria) {}
