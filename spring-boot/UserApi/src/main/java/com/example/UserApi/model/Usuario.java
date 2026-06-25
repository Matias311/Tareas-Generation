package com.example.UserApi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/** UsuarioModel. */
@Entity
@Table(name = "usuarios")
public class Usuario {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank(message = "El nombre del usuario no puede estar vacio")
  @Size(min = 2, max = 100, message = "El nombre no puede superar los 100 caracteres")
  private String nombre;

  @NotBlank(message = "El apellido del usuario no puede estar vacio")
  @Size(min = 2, max = 100, message = "El apellido no puede superar los 100 caracteres")
  private String apellido;

  @Max(value = 100, message = "La edad maxima es de 100 años")
  @Min(value = 5, message = "La edad minima es de 10 años")
  private int edad;

  public Usuario() {}

  public Long getId() {
    return id;
  }

  public String getNombre() {
    return nombre;
  }

  public String getApellido() {
    return apellido;
  }

  public int getEdad() {
    return edad;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void setApellido(String apellido) {
    this.apellido = apellido;
  }

  public void setEdad(int edad) {
    this.edad = edad;
  }
}
