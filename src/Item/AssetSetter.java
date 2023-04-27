package Item;

import main.GamePanel;

public class AssetSetter{
    GamePanel gp;
    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }
    public void setObject(){
        gp.obj[0] = new Obj_big(gp, 300, 250, gp.tileSize, gp.tileSize);
        // gp.obj[0].mapX = 23*gp.tileSize;
        // gp.obj[0].mapY = 7*gp.tileSize;
    }
}
