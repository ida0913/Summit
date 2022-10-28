package summit;
import summit.gfx.BufferedSprites;
import summit.gui.Window;
import summit.gui.WindowState;
import summit.gui.menu.Menu;

import java.awt.Toolkit;

public class Main {
    public static void main(String[] args) {
        Thread main = new Thread(new Runnable() {
            @Override
            public void run() {
                BufferedSprites.loadSprites("C:/Users/aadiu/Desktop/Programming Files/Personal Projects/Java Projects/Summit Game/Summit/Summit/src/summit/resources");

                java.awt.Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

                System.out.println(screen);

                Window window = new Window("summit", screen.width/2, screen.height/2);
                
                window.setState(WindowState.SELECTIONMENUS);

                Menu menu1 = new Menu(0.2f, 0.5f, 0.30f, 0.5f);
                Menu menu2 = new Menu(0.8f, 0.5f, 0.30f, 0.5f);

                window.pushMenu(menu1);
                window.pushMenu(menu2);

            }
        });

        main.start();
    }
}
