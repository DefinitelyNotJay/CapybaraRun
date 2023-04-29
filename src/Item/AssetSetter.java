package Item;

import main.GamePanel;

public class AssetSetter{
    GamePanel gp;
    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }
    public void setObject(){
        gp.obj[0] = new Obj_Item(gp, 300, 250, gp.tileSize, gp.tileSize, "Big");
        gp.obj[1] = new Obj_Item(gp, 500, 250, gp.tileSize, gp.tileSize, "Small");
    }
}
