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

        Renderer ren = e.getRenderer();

        //for centering on region coordinate
        int xOffset = (int)((region.getWidth()%16)/2);
        int yOffset = (int)((region.getHeight()%16)/2);

        int startX = (int)(region.getX()-(region.getWidth()/2)) + xOffset;
        int startY = (int)(region.getY()-(region.getHeight()/2)) + yOffset;

        int endX = (int)(region.getX()+(region.getWidth()/2) - xOffset);
        int endY = (int)(region.getY()+(region.getHeight()/2) - yOffset);

        //traversed in pixel coordinates
        for (int x = startX; x <= endX; x+=16) {
            for (int y = startY; y <= endY; y+=16) {
                // System.out.println(px + "  " + py + "\n\n");
                
                if(y == startY && x == startX){
                    ren.render(Sprite.MENU_CORNER, x, y, Renderer.FLIP_NONE);
                    continue;
                }
                if(y == startY && x == endX){
                    ren.render(Sprite.MENU_CORNER, x, y, Renderer.FLIP_X);
                    continue;
                }
                if(y == endY && x == startX){
                    ren.render(Sprite.MENU_CORNER, x, y, Renderer.FLIP_Y);
                    continue;
                }
                if(y == endY && x == endX){
                    ren.render(Sprite.MENU_CORNER, x, y, Renderer.FLIP_X | Renderer.FLIP_Y);
                    continue;
                }
                //------------

                //check borders
                if(y == startY){
                    ren.render(Sprite.MENU_BORDER, x, y, Renderer.FLIP_NONE);
                    continue;
                }
                if(y == endY){
                    ren.render(Sprite.MENU_BORDER, x, y, Renderer.FLIP_Y);
                    continue;
                }
                if(x == startX){
                    ren.render(Sprite.MENU_BORDER, x, y,  Renderer.ROTATE_90 | Renderer.FLIP_X);
                    continue;
                }
                if(x == endX){
                    ren.render(Sprite.MENU_BORDER, x, y, Renderer.ROTATE_90);
                    continue;
                }
                //------------

                //render inside
                ren.render(Sprite.MENU_FILL, x, y, Renderer.FLIP_NONE);
            }
        }
        
        //blocks needed horizontally and veritcally to satisfy bounding region
        
//         Renderer ren = e.getRenderer();

//         int v = (int)(region.getHeight()/16);
//         int h = (int)(region.getWidth()/16);

//         System.out.println(v + "  " + h);

// //        System.out.println(region);

//         for(int y = 0; y < 1; y++){
//             for(int x = 0; x < h; x++){

//                 float py = region.getX()-((y-(v/2))*16);
//                 float px = region.getY()-((x-(h/2))*16);

//                 // System.out.println(px + "  " + py + "\n\n");
                
//                 //check corners
//                 if(y == startY && x == startX){
//                     System.out.println("hi1");
//                     ren.render(Sprite.MENU_CORNER, px, py, Renderer.FLIP_NONE);
//                     continue;
//                 }
//                 if(y == startY && x == h-1){
//                     System.out.println("hi2");
//                     ren.render(Sprite.MENU_CORNER, px, py, Renderer.FLIP_X);
//                     continue;
//                 }
//                 if(y == v-1 && x == startX){
//                     System.out.println("hi3");
//                     ren.render(Sprite.MENU_CORNER, px, py, Renderer.FLIP_Y);
//                     continue;
//                 }
//                 if(y == v-1 && x == h-1){
//                     System.out.println("hi4");
//                     ren.render(Sprite.MENU_CORNER, px, py, Renderer.FLIP_X | Renderer.FLIP_Y);
//                     continue;
//                 }
//                 //------------

//                 //check borders
//                 if(y == startY){
//                     System.out.println("hi5");
//                     ren.render(Sprite.MENU_BORDER, px, py, Renderer.FLIP_NONE);
//                     continue;
//                 }
//                 if(y == v-1){
//                     System.out.println("hi6");
//                     ren.render(Sprite.MENU_BORDER, px, py, Renderer.FLIP_Y);
//                     continue;
//                 }
//                 if(x == startX){
//                     System.out.println("hi7");
//                     ren.render(Sprite.MENU_BORDER, px, py,  Renderer.ROTATE_90 | Renderer.FLIP_Y);
//                     continue;
//                 }
//                 if(x == h-1){
//                     System.out.println("hi8");
//                     ren.render(Sprite.MENU_BORDER, px, py, Renderer.ROTATE_90);
//                     continue;
//                 }
//                 //------------

//                 //render inside
//                 ren.render(Sprite.MENU_FILL, px, py, Renderer.FLIP_NONE);
//             }   
//         }
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
