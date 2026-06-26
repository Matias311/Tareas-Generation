package com.example.UserApi.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/** UsuarioDTO. */
public record UsuarioDTO(
    Long id,
    @NotBlank(message = "El nombre del usuario no puede estar vacio")
        @Size(min = 2, max = 100, message = "El nombre no puede superar los 100 caracteres")
        String nombre,
    @NotBlank(message = "El apellido del usuario no puede estar vacio")
        @Size(min = 2, max = 100, message = "El apellido no puede superar los 100 caracteres")
        String apellido,
    @Max(value = 100, message = "La edad maxima es de 100 años")
        @Min(value = 5, message = "La edad minima es de 10 años")
        int edad) {}
