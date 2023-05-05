package Item;

import main.GamePanel;

public class AssetSetter{
    GamePanel gp;
    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }
    public void setObject(){
        gp.obj[0] = new Obj_Item(gp, 1800, 250, gp.tileSize, gp.tileSize, "fast");
        // gp.obj[1] = new Obj_Item(gp, 2200, 250, gp.tileSize, gp.tileSize, "fast");
        //gp.obj[2] = new Obj_Item(gp, 2200, 250, gp.tileSize, gp.tileSize, "fast");
    }
}
