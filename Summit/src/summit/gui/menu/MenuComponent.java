package summit.gui.menu;

public class MenuComponent extends Menu{
    private Menu parent;

    public MenuComponent(Menu parent, float relX, float relY, float relWidth, float relHeight){
        super(parent.getRegion().getWidth()*relX, parent.getRegion().getHeight()*relY, 
                parent.getRegion().getWidth()*relWidth, parent.getRegion().getHeight()*relHeight);
        this.parent = parent;
    }

    
}
