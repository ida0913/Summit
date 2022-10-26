package summit.gui.menu;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import summit.game.GameMap;
import summit.gfx.PaintEvent;
import summit.gfx.Paintable;
import summit.gfx.Renderer;
import summit.gfx.Sprite;
import summit.gui.Clickable;
import summit.util.Region;

public class Menu implements Paintable, Clickable{

    private List<MenuComponent> components;
    private Region region;

    private final float REL_WIDTH;
    private final float REL_HEIGHT;
    private final float REL_X;
    private final float REL_Y;

    public Menu(float relX, float relY, float relWidth, float relHeight){
        components = new ArrayList<>();
        region = new Region(Renderer.WIDTH*relX, Renderer.HEIGHT*relY, Renderer.WIDTH*relWidth, Renderer.HEIGHT*relHeight);

        REL_WIDTH = relWidth;
        REL_HEIGHT = relHeight;
        REL_X = relX;
        REL_Y = relY;
    }

    @Override
    public void click(GameMap map, MouseEvent e) {
        for(int i = 0; i < components.size(); i++){
            if(components.get(i).getRegion().contains(e.getX(), e.getY())){
                components.get(i).click(map, e);
            }
        }
    }

    @Override
    public void paint(PaintEvent e) {

        //blocks needed horizontally and veritcally to satisfy bounding region
        
        Renderer ren = e.getRenderer();

        int v = (int)(region.getHeight()/16);
        int h = (int)(region.getWidth()/16);

        for(int r = 0; r < v; r++){
            for(int c = 0; c < h; c++){

                float px = region.getX()-((r-(v/2))*16);
                float py = region.getY()-((c-(h/2))*16);

                //check corners
                if(r == 0 && c == 0){
                    ren.render(Sprite.MENU_CORNER, px, py, Renderer.FLIP_NONE);
                    continue;
                }
                if(r == 0 && c == h-1){
                    ren.render(Sprite.MENU_CORNER, px, py, Renderer.FLIP_X);
                    continue;
                }
                if(r == v-1 && c == 0){
                    ren.render(Sprite.MENU_CORNER, px, py, Renderer.FLIP_Y);
                    continue;
                }
                if(r == v-1 && c == h-1){
                    ren.render(Sprite.MENU_CORNER, px, py, Renderer.FLIP_X | Renderer.FLIP_Y);
                    continue;
                }
                //------------

                //check borders
                if(r == 0){
                    ren.render(Sprite.MENU_BORDER, px, py, Renderer.FLIP_NONE);
                    continue;
                }
                if(r == v-1){
                    ren.render(Sprite.MENU_BORDER, px, py, Renderer.FLIP_Y);
                    continue;
                }
                if(c == 0){
                    ren.render(Sprite.MENU_BORDER, px, py,  Renderer.ROTATE_90 | Renderer.FLIP_Y);
                    continue;
                }
                if(c == h-1){
                    ren.render(Sprite.MENU_BORDER, px, py, Renderer.ROTATE_90);
                    continue;
                }
                //------------

                //render inside
                ren.render(Sprite.MENU_FILL, px, py, Renderer.FLIP_NONE);
            }   
        }
    }

    //--------------------------------------------------------------------
    //getters and setters
    //--------------------------------------------------------------------

    public List<MenuComponent> getComponents() {
        return this.components;
    }

    public void setComponents(List<MenuComponent> components) {
        this.components = components;
    }

    public Region getRegion() {
        return this.region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }
}
