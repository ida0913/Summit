package summit.gui.menu;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import summit.game.GameMap;
import summit.gfx.PaintEvent;
import summit.gfx.Paintable;
import summit.gui.Clickable;
import summit.util.Region;

public abstract class MenuComponent implements Clickable, Paintable{
    
    private List<MenuComponent> components;
    private Region region;

    private final float REL_WIDTH;
    private final float REL_HEIGHT;
    private final float REL_X;
    private final float REL_Y;

    public MenuComponent(float relX, float relY, float relWidth, float relHeight){
        components = new ArrayList<>();
        region = new Region(Renderer., );

        REL_WIDTH = relWidth;
        REL_HEIGHT = relHeight;
        REL_X = relX;
        REL_Y = relY;
    }
}
