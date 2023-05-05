package Item;

import java.awt.image.BufferedImage;

import main.GamePanel;
import methods.Utilz;

public class AssetSetter{
    GamePanel gp;
    public BufferedImage bloodItem, fastItem;

    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }
    
    public void setObject(){
        gp.obj[0] = new Obj_Item(gp, 1800, 250, gp.tileSize, gp.tileSize, "fast");
        // gp.obj[1] = new Obj_Item(gp, 2200, 250, gp.tileSize, gp.tileSize, "blood");
        //gp.obj[2] = new Obj_Item(gp, 2200, 250, gp.tileSize, gp.tileSize, "fast");
    }
}
