package object;

import main.GamePanel;

public class AssetSetter{
    GamePanel gp;
    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }
    public void serObject(){
        gp.obj[0] = new Obj_big(gp, 23*gp.tileSize, 7*gp.tileSize, gp.tileSize, gp.tileSize);
        // gp.obj[0].mapX = 23*gp.tileSize;
        // gp.obj[0].mapY = 7*gp.tileSize;
    }
}
