import java.util.ArrayList;

/** Main. */
public class Main {

  public static void main(String[] args) {
    VideoGame v1 = new VideoGame("Minecraft", "Sandbox", 20000);
    VideoGame v2 = new VideoGame("FIFA", "Deportes", 35000);
    System.out.println(v1.showInfo());
    System.out.println(v2.showInfo());
    v2.setPrecio(20000); // todo bien
    v2.setPrecio(0); // deberia de mostrar un error
    System.out.println(v2.showInfo());

    PcGame pc = new PcGame("Minecraft", "SandBox", 20000, "3gb de ram");
    System.out.println(pc.showInfo());

    ConsoleGame console = new ConsoleGame("FIFA", "Deportes", 60000, "XBOX ONE");
    System.out.println(console.showInfo());

    ArrayList<VideoGame> listGame = new ArrayList<>();
    listGame.add(v1);
    listGame.add(v2);
    listGame.add(pc);
    listGame.add(console);
    listGame.forEach(g -> g.showInfo());
  }
}
