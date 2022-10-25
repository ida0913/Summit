package summit.game.tile;

import summit.game.GameMap;
import summit.game.GameUpdate;
import summit.game.GameUpdateEvent;
import summit.game.tile.Tile;
import summit.gfx.PaintEvent;
import summit.gfx.Paintable;
import summit.gui.Clickable;

import java.awt.event.MouseEvent;
import java.util.Stack;

public class TileStack implements Clickable, Paintable, GameUpdate {

    private Stack<Tile> tiles;
    private float x, y;
    
    public TileStack(float x, float y){
        tiles = new Stack();
        this.x = x;
        this.y = y;
    }

    public void pushTile(Tile tile){
        tiles.push(tile);
    }

    public Tile popTile(){
        return tiles.pop();
    }

    @Override
    public void click(GameMap map, MouseEvent e){
        for(Tile t: tiles){
            t.click(map, e);
        }
    }

    @Override 
    public void paint(PaintEvent e){
        for(Tile t: tiles){
            t.paint(e);
        }
    }

    @Override
    public void update(GameUpdateEvent e) {
        for(Tile t: tiles){
            t.update(e);
        }
    }

}