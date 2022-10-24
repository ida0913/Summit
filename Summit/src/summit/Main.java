package summit;
import summit.gfx.BufferedSprites;
import summit.gui.Window;
import summit.gui.WindowState;
import java.awt.Toolkit;

public class Main {
    public static void main(String[] args) {
        Thread main = new Thread(new Runnable() {
            @Override
            public void run() {
                BufferedSprites.loadSprites("C:/Users/aadiu/Desktop/Programming Files/Personal Projects/Java Projects/Summit/src/Summit/resources");

                java.awt.Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

                System.out.println(screen);

                Window window = new Window("summit", screen.width, screen.height);
                window.setState(WindowState.SELECTIONMENUS);
            }
        });

        main.start();
    }
}
