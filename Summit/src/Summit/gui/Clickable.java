package Summit.gui;

import java.awt.event.MouseEvent;

import Summit.game.GameMap;

public interface Clickable{
    public void click(GameMap map, MouseEvent e);
}
