package summit.gui.menu;

import java.awt.event.MouseEvent;
import java.util.List;

import summit.game.GameMap;
import summit.gfx.PaintEvent;
import summit.gfx.Paintable;
import summit.gui.Clickable;
import summit.util.Region;

public class Menu implements Paintable, Clickable{

    private List<MenuComponent> components;
    private Region region;

    private float relWidth;
    private float relHeight;
    private float relX;
    private float relY;

    public Menu(float relWidth, float relHeight, float relX, float relY){
        
        this.relWidth = relWidth;
        this.relHeight = relHeight;
        this.relX = relX;
        this.relY = relY;
    }

    @Override
    public void click(GameMap map, MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void paint(PaintEvent e) {
        // TODO Auto-generated method stub
        
    }
}
