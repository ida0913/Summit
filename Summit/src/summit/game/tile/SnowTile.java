package summit.game.tile;

import summit.game.tile.Tile;
import summit.game.GameUpdate;
import summit.game.GameUpdateEvent;
import summit.gfx.PaintEvent;

public class SnowTile extends Tile{

    public Tile(float width, float height, float x, float y){
        super(width, height, x, y);
    }

    @Override
    public void paint(PaintEvent e){

    }

    @Override
    public void click(GameMap map, MouseEvent e){
        if(map.getPlayer().inHand() instanceof ShovelTool.class){
            
        }
    }

    @Override
    public void update(PaintEvent e){
        //do nothing
    }
}