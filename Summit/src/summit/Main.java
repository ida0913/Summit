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

                Menu testmenu = new Menu(0.5f, 0.5f, 0.5f, 0.8f);
                window.pushMenu(testmenu);
            }
        });

        main.start();
    }
}
