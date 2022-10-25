package summit.game.tile;

import summit.game.GameMap;
import summit.gfx.PaintEvent;
import summit.gfx.Paintable;
import summit.gui.Clickable;
import summit.game.GameUpdate;

import java.awt.event.MouseEvent;

public abstract Tile implements Clickable, Paintable, GameUpdate {

    private float width;
    private float height;
    private float x;
    private float y;

    private boolean setToDestroy;

    public Tile(float width, float height, float x, float y){
        this.height = height;
        this.width = width;
        this.x = x;
        this.y = y;
    }

    public Tile(float x, float y){
        this(1, 1, x, y);
    }

    public boolean isSetToDestroy(){

    }
}