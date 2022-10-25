package summit.gui.menu;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import summit.game.GameMap;
import summit.gfx.PaintEvent;
import summit.gfx.Paintable;
import summit.gui.Clickable;
import summit.util.Region;

public class Menu implements Paintable, Clickable{

    private List<MenuComponent> components;
    private Region region;

    private final float REL_WIDTH;
    private final float REL_HEIGHT;
    private final float REL_X;
    private final float REL_Y;

    public Menu(float relX, float relY, float relWidth, float relHeight){
        this.components = new ArrayList<>();
        region = new Region(relX, relY, relWidth, relHeight);

        this.REL_WIDTH = relWidth;
        this.REL_HEIGHT = relHeight;
        this.REL_X = relX;
        this.REL_Y = relY;
    }

    @Override
    public void click(GameMap map, MouseEvent e) {
        for(int i = 0; i < components.size(); i++){
            if(components.get(i).getRegion().contains(e.getX(), e.getY())){
                components.get(i).click(map, e);
            }
        }
    }

    @Override
    public void paint(PaintEvent e) {
        
    }
}
