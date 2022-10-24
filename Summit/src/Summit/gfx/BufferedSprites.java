package Summit.gfx;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BufferedSprites{

    /**'Object' will wrap a 2d int array*/
    public static Object[] sprites;

    public static void loadSprites(String path){

        File[] dirFiles = new File(path).listFiles();
        
        sprites = new Object[dirFiles.length];

        for(int i = 0; i < dirFiles.length; i++){
            String absPath = dirFiles[i].getAbsolutePath();
            
            if(absPath.contains(".png") || absPath.contains(".jpg")){
                try{
                    String ref = dirFiles[i].getName().substring(0, dirFiles[i].getName().lastIndexOf("."));

                    BufferedImage sprite = ImageIO.read(dirFiles[i]);

                    int[][] dataBuffer = new int[sprite.getHeight()][sprite.getWidth()];

                    for (int r = 0; r < dataBuffer.length; r++) {
                        for (int c = 0; c < dataBuffer[0].length; c++) {
                            dataBuffer[r][c] = sprite.getRGB(c, r);
                        }
                    }

                    sprites[i] = dataBuffer;

                    System.out.println(ref);
                    
                } catch(IOException e) {}
            }
        }
    }

    public static int[][] getSprite(int spriteInd){
        return (int[][])sprites[spriteInd];
    }
}