package Summit.gui.menu;

import java.awt.event.MouseEvent;
import java.util.List;

import Summit.game.GameMap;
import Summit.gfx.PaintEvent;
import Summit.gfx.Paintable;
import Summit.gui.Clickable;
import Summit.util.Region;

public class MenuComponent implements Clickable, Paintable{
    
    private List<int[][]> sprites;
    private List<MenuComponent> components;
    private Region region;

    private float relWidth;
    private float relHeight;
    private float relX;
    private float relY;

    public MenuComponent(float relWidth, float relHeight, float relX, float relY){
        
    }

    @Override
    public void paint(PaintEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void click(GameMap map, MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

}
