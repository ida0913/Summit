package summit.game.tile;

import summit.game.GameMap;
import summit.gfx.PaintEvent;
import summit.gfx.Paintable;
import summit.gui.Clickable;

import java.awt.event.MouseEvent;

public class Tile implements Clickable, Paintable {

    private String name;
    private float width;
    private float height;
    private float x;
    private float y;


    public Tile(String name, float width, float height, float x, float y){

    }

    public Tile(float x, float y){
        this("", 1, 1, x, y);
        name = this.getClass().getSimpleName();
    }

    @Override
    public void click(GameMap map, MouseEvent e){
        //do whatever
    }

    @Override 
    public void paint(PaintEvent e){
        //ignore
    }
}