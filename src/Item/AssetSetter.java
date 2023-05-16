package Item;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import static constant.Constants.*;

import main.GamePanel;

public class AssetSetter {
    GamePanel gp;
    public BufferedImage bloodItem, fastItem;
    private ArrayList<Item> allItems;
    private final int AMOUNT = 50;
    Random random = new Random();

    public AssetSetter(GamePanel gp) {
        this.gp = gp;
        allItems = new ArrayList<Item>();
        setItems();
    }

    public void setItems() {
        int recentlyX = 0;
        for (int i = 0; i < AMOUNT; i++) {
            int randomItem = random.nextInt(SCOREBOOST - FAST) + FAST;
            int wide = random.nextInt(4 - 1) + 1;
            int wideSize = random.nextInt(1200 - 1000) + 1000;
            int itemHeight = 250;
            if (i == 0) {
                allItems.add(new Item(gp, wideSize, itemHeight, randomItem));
                recentlyX = wideSize;
            } else {
                recentlyX += (wide * wideSize);
                allItems.add(new Item(gp, recentlyX, itemHeight, randomItem));

            }

        }

        // allItems.add(new Item(gp, 1000, 260, FAST));

        // gp.obj[0] = new Item(gp, 1800, 260, gp.tileSize, gp.tileSize, "Fast");
        // gp.obj[0].setItemImage("/res/item/boots_01d.png");
        // gp.obj[1] = new Item(gp, 8200, 260, gp.tileSize, gp.tileSize, "IncreaseHP");
        // gp.obj[1].setItemImage("/res/item/heart.png");
        // gp.obj[2] = new Item(gp, 10200, 270, gp.tileSize, gp.tileSize, "DecreaseHP");
        // gp.obj[2].setItemImage("/res/item/posion.png");
        // gp.obj[3] = new Item(gp, 14200, 260, gp.tileSize, gp.tileSize, "IncreaseHP");
        // gp.obj[3].setItemImage("/res/item/heart.png");
        // gp.obj[4] = new Item(gp, 18200, 260, gp.tileSize, gp.tileSize, "DecreaseHP");
        // gp.obj[4].setItemImage("/res/item/posion.png");
        // gp.obj[5] = new Item(gp, 800, 280, gp.tileSize, gp.tileSize, "Giant");
        // gp.obj[5].setItemImage("/res/item/bigger.png");
        // gp.obj[6] = new Item(gp, 1000, 280, gp.tileSize, gp.tileSize, "ManaBoost");
        // gp.obj[6].setItemImage("/res/item/mana.png");
        // gp.obj[7] = new Item(gp, 500, 280, gp.tileSize, gp.tileSize, "ScoreBoost");
        // gp.obj[7].setItemImage("/res/item/mana.png");
    }

    public ArrayList<Item> getAllItems() {
        return allItems;
    }
}
