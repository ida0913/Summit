import java.io.Serializable;

public class GameWorld implements Paintable, Serializable{

    List<GameMap> maps;
    GameMap loadedMap;

    Window parentWindow;

    public GameWorld(Window parentWindow){
        this.parentWindow = parentWindow;
    }

    @Override
    public void paint(PaintEvent e){
        loadedMap.paint();
    }
}