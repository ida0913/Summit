
public class Tile implements Clickable, Paintable{

    private String name;
    private float width;
    private float height;
    private float x;
    private float y;

    public static final Tile 

    public Tile(String name, float width, float height, float x, float y){

    }

    public Tile(float x, float y){
        this(this.getClass().getSimpleName(), 1, 1, x, y);
    }

    @Override
    public void click(GameMap map, MouseEvent e){
        //do whatever
    }

    @Override 
    public void paint(PaintEvent e){
        //ignore
    }
}