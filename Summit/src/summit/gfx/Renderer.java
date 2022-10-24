package summit.gfx;

import java.awt.geom.Point2D;

public class Renderer {
    
    private int[][] frame;

    private static final int WIDTH = 512;
    private static final int HEIGHT = 288;

    private Camera camera;

    public Renderer(){

    }

    public int[][] getUpscaled(int newWidth, int newHeight){

        int[][] newFrame = new int[newHeight][newWidth];



        return newFrame;
    }


    /** 
     * coordinates are topleft gamespace coordinates. 
     * rotation is rounded to nearest multiple of 90. 
     * {@code sprite} is image data. 
    */
    public void render(int s, float x, float y, int rotation){
        
        int[][] sprite = BufferedSprites.getSprite(s);

        Point2D.Float spritePos = toPixel(x, y, this.camera);


        int nx = Math.round(toPixel(x)-toPixel(rotation));
        int ny = Math.round(toPixel(y)-toPixel(rotation));

        rotation = ((int)rotation/90)*90;

        for(int yy = ny; yy < frame.length; yy++) {
            for(int xx = nx; xx < frame[0].length; xx++) {
                frame[yy][xx] = sprite[yy-ny][xx-nx];
            }
        }
    }

    /**
     * Camera is left in gamecoordinates
     * 
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

    //------------------------------------------------------------------
    //getters and setters
    //------------------------------------------------------------------
    
    public void setCamera(Camera camera) {
        this.camera = camera;
    }
}
