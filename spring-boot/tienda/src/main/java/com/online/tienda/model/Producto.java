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

/** Producto. */
@Entity
@Table(name = "productos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Producto {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nombre;
  private String descripcion;
  private Long precio;
  private int stock;
  private String categoria;

  public Producto(String nombre, String descripcion, Long precio, int stock, String categoria) {
    this.nombre = nombre;
    this.descripcion = descripcion;
    this.precio = precio;
    this.stock = stock;
    this.categoria = categoria;
  }
}
