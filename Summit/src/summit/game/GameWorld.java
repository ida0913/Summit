package summit.game;

import summit.gfx.PaintEvent;
import summit.gfx.Paintable;
import summit.gui.Window;

import java.io.Serializable;
import java.util.List;

public class GameWorld implements Paintable, Serializable{

    List<GameMap> maps;
    GameMap loadedMap;

    Window parentWindow;

    public GameWorld(Window parentWindow){
        this.parentWindow = parentWindow;
    }

    @Override
    public void paint(PaintEvent e){
        loadedMap.paint(e);
    }
}