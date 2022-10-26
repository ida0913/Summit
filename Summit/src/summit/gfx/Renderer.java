package summit.gfx;

import java.awt.geom.Point2D;

public class Renderer {
    
    private int[][] frame;

    public static final int WIDTH = 512;
    public static final int HEIGHT = 288;

    public static final int FLIP_NONE = 0b0;
    public static final int FLIP_X = 0b1;
    public static final int FLIP_Y = 0b10;
    public static final int ROTATE_90 = 0b100;

    private Camera camera;

    public Renderer(){

    }

    public int[][] getUpscaled(int newWidth, int newHeight){

        int[][] newFrame = new int[newHeight][newWidth];



        return newFrame;
    }


    /**
     * USE THIS METHOD FOR GENERAL RENDERING (MENUS, DIALOGUE, ETC). COORDINATES ARE SCREEN COORDINATES
     */
    public void render(int s, float x, float y, int flip){
        int[][] sprite = BufferedSprites.getSprite(s);

        int nx = (int)x-(sprite[0].length/2);
        int ny = (int)y-(sprite.length/2);

        if(flip == 0){
            for(int yy = ny; yy < frame.length; yy++) {
                for(int xx = nx; xx < frame[0].length; xx++) {
                    frame[yy][xx] = sprite[yy-ny][xx-nx];
                }
            }
        }
        else if(flip == FLIP_X){

        }
        else if(flip == FLIP_Y){

        }
        else if(flip == (FLIP_X | FLIP_X)){

        }
    }

    /** 
     * USE THIS METHOD FOR RENDERING GAME STUFF (ANYTHING THAT IS POSITIONALLY BASED ON A CAMERA).
     * COORDINATES ARE GAMESPACE COORDINATES.
    */
    public void renderGame(int s, float x, float y, int flip){

        Point2D.Float spritePos = toPixel(x, y, this.camera);

        this.render(s, spritePos.x, spritePos.y, flip);
    }



    //--------------------------------------------------------------------
    // utilities
    //--------------------------------------------------------------------

    /**
     * Camera is left in gamecoordinates
     */
    public static Point2D.Float toPixel(float x, float y, Camera cam){
        float nx = (WIDTH/2)+(x*16F)-(cam.getX()*16F);
        float ny = (HEIGHT/2)-(y*16F)+(cam.getY()*16F);

        return new Point2D.Float(nx, ny);
    }

    /**
     * Camera is left in gamecoordinates
     */
    public static Point2D.Float toTile(float x, float y, Camera cam){
        
        //inverted equation of topixel
        //REDO IT IS WRONG 
        float nx = (x+cam.getX()-(WIDTH/2))/16F;
        float ny = (y-cam.getY()-(HEIGHT/2))/(-16F);

        return new Point2D.Float(nx, ny); 
    }

    public static float toPixel(float n){
        return n*16;
    }

    public static boolean onScreen(float x, float y, Camera cam){
        return false;
    }

    //------------------------------------------------------------------
    //getters and setters
    //------------------------------------------------------------------
    
    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    public Camera getCamera() {
        return this.camera;
    }
}
