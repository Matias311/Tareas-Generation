/** ConsoleGame. */
public class ConsoleGame extends VideoGame {

  private String consolaCompatible;

  public ConsoleGame(String nombre, String genero, int precio, String consolaCompatible) {
    super(nombre, genero, precio);
    this.consolaCompatible = consolaCompatible;
  }

  public String getConsolaCompatible() {
    return consolaCompatible;
  }

  @Override
  public int calculateFinalPrice() {
    double resultado = this.getPrecio() * 0.85;
    this.setPrecio((int) resultado);
    return (int) resultado;
  }

  @Override
  public String showInfo() {
    return String.format(
        "Nombre: %s\nGenero: %s\nConsola compatible: %s\nPrecio: %d\nPrecio Final: %d",
        this.getNombre(),
        this.getGenero(),
        this.getConsolaCompatible(),
        this.getPrecio(),
        this.calculateFinalPrice());
  }
}
