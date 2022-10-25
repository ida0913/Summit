package summit.util;

public class Region {

    private float width;
    private float height;

    private float x;
    private float y;

    public Region(float x, float y, float width, float height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public boolean overlap(Region other){
        
    }

    public boolean contains(float ox, float oy){
        if(ox <= x+(width/2) && ox >= x-(width/2)){
            if(oy <= y+(height)/2 && oy >= y-(height/2)){
                return true;
            }
        }
        return false;
    }
}
