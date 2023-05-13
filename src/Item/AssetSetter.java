package Item;

import java.awt.image.BufferedImage;

import main.GamePanel;

public class AssetSetter {
    GamePanel gp;
    public BufferedImage bloodItem, fastItem;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }

    public void setObject() {
        gp.obj[0] = new Flash(gp, 1800, 260, gp.tileSize, gp.tileSize, "fast");
        gp.obj[0].setItemImage("/res/item/fast.png");
        gp.obj[1] = new Flash(gp, 8200, 260, gp.tileSize, gp.tileSize, "IncreaseHP");
        gp.obj[1].setItemImage("/res/item/IncreaseHP.png");
        gp.obj[2] = new Flash(gp, 10200, 270, gp.tileSize, gp.tileSize, "DecreaseHP");
        gp.obj[2].setItemImage("/res/item/DecreaseHP.png");
        gp.obj[3] = new Flash(gp, 14200, 260, gp.tileSize, gp.tileSize, "IncreaseHP");
        gp.obj[3].setItemImage("/res/item/IncreaseHP.png");
        gp.obj[4] = new Flash(gp, 18200, 260, gp.tileSize, gp.tileSize, "IncreaseHP");
        gp.obj[4].setItemImage("/res/item/IncreaseHP.png");
        gp.obj[5] = new Flash(gp, 800, 280, gp.tileSize, gp.tileSize, "Giant");
        gp.obj[5].setItemImage("/res/item/cat.png");
        gp.obj[6] = new Flash(gp, 4800, 260, gp.tileSize, gp.tileSize, "fast");
        gp.obj[6].setItemImage("/res/item/fast.png");
    }
}
