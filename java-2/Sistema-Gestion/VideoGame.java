/** VideoGame. */
public class VideoGame {

  private String nombre;
  private String genero;
  private int precio;

  public VideoGame(String nombre, String genero, int precio) {
    this.nombre = nombre;
    this.genero = genero;
    this.precio = precio;
  }

  public String getNombre() {
    return nombre;
  }

  public String getGenero() {
    return genero;
  }

  public int getPrecio() {
    return precio;
  }

  public void setPrecio(int precio) {
    if (precio <= 0) {
      System.out.println("Error precio invalido");
    } else {
      this.precio = precio;
    }
  }

  public int calculateFinalPrice() {
    return this.getPrecio();
  }

  public String showInfo() {
    return String.format(
        "Nombre: %s\nGenero: %s\nPrecio: %d\nPrecio Final: %d",
        this.getNombre(), this.getGenero(), this.getPrecio(), this.calculateFinalPrice());
  }
}
