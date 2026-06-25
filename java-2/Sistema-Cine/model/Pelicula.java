package model;

public class Pelicula {
  private String titulo;
  private int minutos;

  public Pelicula(String titulo, int minutos) {
    this.titulo = titulo;
    this.minutos = minutos;
  }

  public String getTitulo() {
    return titulo;
  }

  public int getMinutos() {
    return minutos;
  }

  @Override
  public String toString() {
    return titulo + " (" + minutos + " min)";
  }
}
