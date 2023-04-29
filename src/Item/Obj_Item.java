package Item;

import java.io.IOException;

import main.GamePanel;

public class Obj_Item extends SuperObjects {
    public Obj_Item(GamePanel gp,int x, int y,int sizeX, int sizeY, String name){
        super(gp, x, y, sizeX, sizeY);
        setName(name);
    }
}
