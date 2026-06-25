package model;

import java.time.format.DateTimeFormatter;

public class Entrada {
  private Cliente cliente;
  private Funcion funcion;
  private int asiento;
  private String tipo;

  public Entrada(Cliente cliente, Funcion funcion, int asiento, String tipo) {
    this.cliente = cliente;
    this.funcion = funcion;
    this.asiento = asiento;
    this.tipo = tipo;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public Funcion getFuncion() {
    return funcion;
  }

  public int getAsiento() {
    return asiento;
  }

  public String getTipo() {
    return tipo;
  }

  public double calcularPrecio() {
    if ("Estudiante".equalsIgnoreCase(tipo)) {
      return 35.0;
    }
    return 60.0;
  }

  public void mostrarResumen() {
    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm");
    System.out.println("=== ENTRADA ===");
    System.out.println("Cliente: " + cliente.getNombre());
    System.out.println("Pelicula: " + funcion.getPelicula().getTitulo());
    System.out.println("Horario: " + funcion.getHorario().format(fmt));
    System.out.println("Asiento: " + asiento);
    System.out.println("Tipo: " + tipo);
    System.out.println("Precio: $" + calcularPrecio());
    System.out.println("===============");
  }
}
