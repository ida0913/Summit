package summit;
import summit.gfx.BufferedSprites;
import summit.gfx.PaintEvent;
import summit.gui.Window;
import summit.gui.WindowState;
import summit.gui.menu.Menu;
import summit.gui.menu.MenuComponent;

import java.awt.Toolkit;

public class Main {
    public static void main(String[] args) {
        Thread main = new Thread(new Runnable() {
            @Override
            public void run() {
                BufferedSprites.loadSprites("C:\\Users\\205625\\IdeaProjects\\Summit\\src\\summit\\resources");

                java.awt.Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

                System.out.println(screen);

                Window window = new Window("summit", screen.width/2, screen.height/2);
                
                window.setState(WindowState.SELECTIONMENUS);

                Menu menu1 = new Menu(0.5f, 0.5f, 0.5f, 0.5f);
                menu1.addComponent(new MenuComponent(menu1, 0.5f, 0.5f, 0.5f, 0.5f));//{
//                    @Override
//                    public void paint(PaintEvent e){
//                        super.paint(e);
//                        System.out.println(this.getRegion());
//                    }
//                });

                Menu menu2 = new Menu(0.5f, 0.5f, 0.5f, 0.5f);

                window.pushMenu(menu1);
                // window.pushMenu(menu2);

            }
        });

        main.start();
    }
}
