package model;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Funcion {
  private Pelicula pelicula;
  private LocalTime horario;
  private int capacidad;
  private boolean[] asientosOcupados;
  private List<Entrada> entradasVendidas;

  public Funcion(Pelicula pelicula, LocalTime horario, int capacidad) {
    this.pelicula = pelicula;
    this.horario = horario;
    this.capacidad = capacidad;
    this.asientosOcupados = new boolean[capacidad];
    this.entradasVendidas = new ArrayList<>();
  }

  public Pelicula getPelicula() {
    return pelicula;
  }

  public LocalTime getHorario() {
    return horario;
  }

  public int getCapacidad() {
    return capacidad;
  }

  public int getAsientosDisponibles() {
    int disponibles = 0;
    for (boolean ocupado : asientosOcupados) {
      if (!ocupado) disponibles++;
    }
    return disponibles;
  }

  public boolean hayAsientosDisponibles() {
    return getAsientosDisponibles() > 0;
  }

  public boolean venderAsiento(int numeroAsiento) {
    if (numeroAsiento < 1 || numeroAsiento > capacidad) {
      return false;
    }
    int idx = numeroAsiento - 1;
    if (asientosOcupados[idx]) {
      return false;
    }
    asientosOcupados[idx] = true;
    return true;
  }

  public void registrarEntrada(Entrada entrada) {
    this.entradasVendidas.add(entrada);
  }

  public List<Entrada> getEntradasVendidas() {
    return entradasVendidas;
  }

  public String toString() {
    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm");
    return pelicula.getTitulo()
        + " - "
        + horario.format(fmt)
        + " ("
        + getAsientosDisponibles()
        + "/"
        + capacidad
        + " libres)";
  }
}
