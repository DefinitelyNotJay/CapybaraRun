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
            int randomItem = random.nextInt(SMALLHP - FAST) + FAST;
            int wide = random.nextInt(4 - 1) + 1; // ห่าง 1-4 หน้าจอ
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
    }

    public ArrayList<Item> getAllItems() {
        return allItems;
    }
}
