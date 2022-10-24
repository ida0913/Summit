package Summit;
import Summit.gfx.BufferedSprites;
import Summit.gui.Window;
import Summit.gui.WindowState;
import java.awt.Toolkit;

public class Main {
    public static void main(String[] args) {
        Thread main = new Thread(new Runnable() {
            @Override
            public void run() {
                BufferedSprites.loadSprites("C:/Users/aadiu/Desktop/Programming Files/Personal Projects/Java Projects/Summit/src/Summit/resources");

                java.awt.Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

                System.out.println(screen);

                Window window = new Window("Summit", screen.width, screen.height);
                window.setState(WindowState.SELECTIONMENUS);
            }
        });

        main.start();
    }
}
