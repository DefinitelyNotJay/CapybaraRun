package Item;

import main.GamePanel;
import static constant.Constants.*;

public class Flash extends Obj_Item {

    public Flash(GamePanel gp, int x, int y, int sizeX, int sizeY, String name) {
        super(gp, x, y, sizeX, sizeY, name);
    }

    @Override
    public void effect() {
        if (mapX() > -1500) {
            GAMESPEED = 13;
            gp.getPlayer().setImmune(true);
            System.out.println("fast item");
        } else {
            GAMESPEED = 6;
            gp.getPlayer().setImmune(false);
            gp.getPlayer().getImmune();
        }
    }

}
