package com.online.tienda.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/** Cliente. */
@Entity
@Table(name = "clientes")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Cliente {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nombre;
  private String apellido;
  private String correo;
  private String telefono;
  private String direction;

  public Cliente(String nombre, String apellido, String correo, String telefono, String direction) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.correo = correo;
    this.telefono = telefono;
    this.direction = direction;
  }
}
