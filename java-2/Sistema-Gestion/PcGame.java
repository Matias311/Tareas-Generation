/** PcGame. */
public class PcGame extends VideoGame {

  private String requisitosMinimos;

  public PcGame(String nombre, String genero, int precio, String requisitosMinimos) {
    super(nombre, genero, precio);
    this.requisitosMinimos = requisitosMinimos;
  }

  public String getRequisitosMinimos() {
    return requisitosMinimos;
  }

  @Override
  public int calculateFinalPrice() {
    double resultado = this.getPrecio() * 0.90;
    this.setPrecio((int) resultado);
    return (int) resultado;
  }

  @Override
  public String showInfo() {
    return String.format(
        "Nombre: %s\nGenero: %s\nRequisitos minimos: %s\nPrecio: %d\nPrecio Final: %d",
        this.getNombre(),
        this.getGenero(),
        this.getRequisitosMinimos(),
        this.getPrecio(),
        this.calculateFinalPrice());
  }
}
