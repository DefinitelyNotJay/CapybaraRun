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
        gp.obj[0] = new Item(gp, 1800, 260, gp.tileSize, gp.tileSize, "Fast");
        gp.obj[0].setItemImage("/res/item/boots_01d.png");
        gp.obj[1] = new Item(gp, 8200, 260, gp.tileSize, gp.tileSize, "IncreaseHP");
        gp.obj[1].setItemImage("/res/item/heart.png");
        gp.obj[2] = new Item(gp, 10200, 270, gp.tileSize, gp.tileSize, "DecreaseHP");
        gp.obj[2].setItemImage("/res/item/posion.png");
        gp.obj[3] = new Item(gp, 14200, 260, gp.tileSize, gp.tileSize, "IncreaseHP");
        gp.obj[3].setItemImage("/res/item/heart.png");
        gp.obj[4] = new Item(gp, 18200, 260, gp.tileSize, gp.tileSize, "DecreaseHP");
        gp.obj[4].setItemImage("/res/item/posion.png");
        gp.obj[6] = new Item(gp, 1000, 280, gp.tileSize, gp.tileSize, "ManaBoost");
        gp.obj[6].setItemImage("/res/item/mana.png");
        gp.obj[7] = new Item(gp, 500, 280, gp.tileSize, gp.tileSize, "ScoreBoost");
        gp.obj[7].setItemImage("/res/item/mana.png");
    }
}
