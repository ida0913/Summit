package summit.gfx;

public class PaintEvent {

    private Renderer renderer;
    private long paintTime;

    public PaintEvent(Renderer renderer, long paintTime){
        this.renderer = renderer;
        this.paintTime = paintTime;
    }

    public Renderer getRenderer(){
        return this.renderer;
    }

    public long getPaintTime(){
        return this.paintTime;
    }
}
