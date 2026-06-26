package com.online.tienda.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;

/** ClienteRequestDTO. */
@Builder
public record ClienteRequestDTO(
    @NotBlank(message = "El nombre debe de tener un valor")
        @Size(
            min = 2,
            max = 50,
            message = "El nombre no puede ser menor a 2 y no puede ser mayor a 50 caracteres")
        String nombre,
    @NotBlank(message = "El apellido debe de tener un valor")
        @Size(
            min = 2,
            max = 50,
            message = "El apellido no puede ser menor a 2 y no puede ser mayor a 50 caracteres")
        String apellido,
    @NotBlank(message = "El correo electronico no puede estar vacio")
        @Email(message = "Por favor ingresa una direccion de correo electronico valida")
        String correo,
    String telefono,
    String direction) {}
