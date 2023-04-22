package Objects;

import java.io.IOException;

import main.GamePanel;

public class Obj_big extends SuperObjects {
    public Obj_big(GamePanel gp,double x, double y,int sizeX, int sizeY){
        super(gp, x, y, sizeX, sizeY);
         setName("Big");
    }
}
