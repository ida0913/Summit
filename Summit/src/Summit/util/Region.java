package Summit.util;

public class Region {

    private float width;
    private float height;

    private float x;
    private float y;

    public Region(float width, float height){
        
    }

    public boolean overlap(Region other){
        return false;
    }

    public boolean contains(float x, float y){
        return false;
    }
}
