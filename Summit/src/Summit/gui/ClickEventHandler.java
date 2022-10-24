package Summit.gui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Vector;
import Summit.game.GameMap;
import Summit.gui.Clickable;

public class ClickEventHandler extends java.awt.Component implements MouseListener {

    private GameMap map;

    public ClickEventHandler(GameMap map){
        this.map = map;
        super.addMouseListener(this);
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        float nx = Window.toTile(e.getX(), map.getCamera());
        float ny = Window.toTile(e.getY(), map.getCamera());

        ((Clickable)map.getRegionAt(nx, ny)).click(map, e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
    }
}
