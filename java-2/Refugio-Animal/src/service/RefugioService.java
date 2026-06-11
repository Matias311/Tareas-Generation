import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RefugioService {

  private Map<Cliente, List<Mascota>> clientes = new HashMap<>();
  private int contadorAdopciones = 0;

  public void iniciar() {
    boolean salir = false;

    while (!salir) {
      System.out.println("\n=== REFUGIO ANIMAL ===");
      System.out.println("1) Crear cliente");
      System.out.println("2) Registrar mascota");
      System.out.println("3) Ver clientes y mascotas");
      System.out.println("4) Menú de Adopción");
      System.out.println("0) Salir");

      int op = InputUtil.leerInt();

      switch (op) {
        case 1 -> crearCliente();
        case 2 -> registrarMascota();
        case 3 -> mostrarDatos();
        case 4 -> menuAdopcion();
        case 0 -> salir = true;
        default -> System.out.println("Opción inválida");
      }
    }
  }

  public void crearCliente() {
    String nombre = InputUtil.pedirString("Ingrese el nombre del cliente");
    Cliente cliente = new Cliente(nombre);

    if (clientes.containsKey(cliente)) {
      System.out.println("El cliente ya existe");
      return;
    }

    clientes.put(cliente, new ArrayList<Mascota>());
    System.out.println("Cliente creado correctamente");
  }

  public void registrarMascota() {
    System.out.println("\n--- Registrar Mascota ---");
    String nombre = InputUtil.pedirString("Ingrese el nombre:");

    int edad = -1;
    while (edad <= 0) {
      try {
        System.out.println("Ingrese la edad (debe ser > 0):");
        edad = InputUtil.leerInt();
        if (edad <= 0) {
          System.out.println("La edad debe ser mayor a 0");
        }
      } catch (IllegalArgumentException e) {
        System.out.println("Edad inválida: " + e.getMessage());
      }
    }

    String tipo = InputUtil.pedirString("Ingrese el tipo de mascota (Gato/Perro)");

    String nombreCliente = InputUtil.pedirString("Ingrese el nombre del cliente");

    Cliente cliente = buscarCliente(nombreCliente);
    if (cliente == null) {
      System.out.println("El cliente no se encuentra registrado");
      return;
    }

    List<Mascota> mascotasCliente = clientes.get(cliente);

    try {
      Mascota mascota = null;
      switch (tipo.toLowerCase()) {
        case "gato":
          mascota = new Gato(nombre, edad);
          break;
        case "perro":
          mascota = new Perro(nombre, edad);
          break;
        default:
          System.out.println("Tipo no válido");
          return;
      }

      // Verificar si la mascota ya existe
      if (mascotasCliente.contains(mascota)) {
        System.out.println("Esta mascota ya está registrada para este cliente");
        return;
      }

      mascotasCliente.add(mascota);
      System.out.println("Mascota registrada correctamente");
    } catch (IllegalArgumentException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

  public void mostrarDatos() {
    if (clientes.isEmpty()) {
      System.out.println("No hay clientes registrados");
      return;
    }

    System.out.println("\n=== CLIENTES Y MASCOTAS ===");
    clientes
        .entrySet()
        .forEach(
            entry -> {
              System.out.println("\n--- Cliente: " + entry.getKey().getNombre() + " ---");
              if (entry.getValue().isEmpty()) {
                System.out.println("  Sin mascotas");
              } else {
                entry
                    .getValue()
                    .forEach(
                        m ->
                            System.out.println(
                                "  - "
                                    + m.getNombre()
                                    + " ("
                                    + m.getClass().getSimpleName()
                                    + ")"));
              }
            });
  }

  public void menuAdopcion() {
    boolean volver = false;

    while (!volver) {
      System.out.println("\n=== MENÚ DE ADOPCIÓN ===");
      System.out.println("1) Ver mascotas adoptables");
      System.out.println("2) Adoptar mascota");
      System.out.println("3) Reportes por tipo");
      System.out.println("4) Ver contador de adopciones");
      System.out.println("0) Volver");

      int op = InputUtil.leerInt();

      switch (op) {
        case 1 -> verMascotasAdoptables();
        case 2 -> adoptarMascota();
        case 3 -> reportesPorTipo();
        case 4 -> System.out.println("Total de adopciones realizadas: " + contadorAdopciones);
        case 0 -> volver = true;
        default -> System.out.println("Opción inválida");
      }
    }
  }

  public void verMascotasAdoptables() {
    System.out.println("\n=== MASCOTAS ADOPTABLES ===");
    boolean hayAdoptables = false;

    for (Cliente cliente : clientes.keySet()) {
      List<Mascota> adoptables =
          clientes.get(cliente).stream()
              .filter(m -> m instanceof Adoptable)
              .collect(Collectors.toList());

      if (!adoptables.isEmpty()) {
        hayAdoptables = true;
        System.out.println("\nCliente: " + cliente.getNombre());
        adoptables.forEach(
            m -> {
              System.out.println(
                  "  - "
                      + m.getNombre()
                      + " ("
                      + m.getClass().getSimpleName()
                      + ", Edad: "
                      + m.getEdad()
                      + ")");
              if (m instanceof Adoptable) {
                System.out.println("    " + ((Adoptable) m).datosAdopcion());
              }
            });
      }
    }

    if (!hayAdoptables) {
      System.out.println("No hay mascotas adoptables disponibles");
    }
  }

  public void adoptarMascota() {
    String nombreMascota = InputUtil.pedirString("Ingrese el nombre de la mascota a adoptar");

    for (Cliente cliente : clientes.keySet()) {
      for (Mascota mascota : clientes.get(cliente)) {
        if (mascota.getNombre().equals(nombreMascota) && mascota instanceof Adoptable) {
          clientes.get(cliente).remove(mascota);
          contadorAdopciones++;
          System.out.println("¡Adopción exitosa! " + nombreMascota + " ha sido adoptado");
          return;
        }
      }
    }

    System.out.println("Mascota no encontrada o no es adoptable");
  }

  public void reportesPorTipo() {
    System.out.println("\n=== REPORTE POR TIPO DE MASCOTA ===");

    Map<String, Long> reporteGatos = new HashMap<>();
    Map<String, Long> reportePerros = new HashMap<>();

    for (Cliente cliente : clientes.keySet()) {
      long cantidadGatos = clientes.get(cliente).stream().filter(m -> m instanceof Gato).count();

      long cantidadPerros = clientes.get(cliente).stream().filter(m -> m instanceof Perro).count();

      if (cantidadGatos > 0) {
        reporteGatos.put(cliente.getNombre(), cantidadGatos);
      }
      if (cantidadPerros > 0) {
        reportePerros.put(cliente.getNombre(), cantidadPerros);
      }
    }

    System.out.println("--- GATOS ---");
    if (reporteGatos.isEmpty()) {
      System.out.println("No hay gatos registrados");
    } else {
      reporteGatos.forEach(
          (cliente, cantidad) -> System.out.println(cliente + ": " + cantidad + " gato(s)"));
    }

    System.out.println("\n--- PERROS ---");
    if (reportePerros.isEmpty()) {
      System.out.println("No hay perros registrados");
    } else {
      reportePerros.forEach(
          (cliente, cantidad) -> System.out.println(cliente + ": " + cantidad + " perro(s)"));
    }
  }

  public Cliente buscarCliente(String nombre) {
    for (Cliente cliente : clientes.keySet()) {
      if (cliente.getNombre().equals(nombre)) {
        return cliente;
      }
    }
    return null;
  }
}
