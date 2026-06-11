import java.util.ArrayList;
import java.util.List;

public class Cliente extends Persona {
  private List<Mascota> mascotas = new ArrayList<>();

  public Cliente(String nombre) {
    super(nombre);
  }

  public void agregarMascota(Mascota m) {
    mascotas.add(m);
  }

  public List<Mascota> getMascotas() {
    return mascotas;
  }
}
