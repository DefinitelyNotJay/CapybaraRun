package Item;

import main.GamePanel;
import methods.Utilz;

import static constant.Constants.*;

public class Item extends SuperObjects {
    private boolean itemUsed = false;
    private boolean itemReset = false;
    private int whichItem;

    public Item(GamePanel gp, int x, int y, int whichItem) {
        this(gp, x, y, gp.tileSize, gp.tileSize, whichItem);
    }

    public Item(GamePanel gp, int x, int y, int sizeX, int sizeY, int whichItem) {
        super(gp, x, y, sizeX, sizeY);
        this.whichItem = whichItem;
        setItemAsset();
    }

    @Override
    public void effect() {
        switch (whichItem) {
            case FAST:
                if (mapX > -1500 && !itemUsed) {
                    GAMESPEED = 13;
                    gp.getPlayer().setImmune(true);
                    gp.getPlayer().setItemImmune(true);
                    itemUsed = true;
                } else if (mapX < -1500 && !itemReset) {
                    GAMESPEED = 4;
                    if (!gp.getPlayer().isSkillOnUse() || gp.getPlayer().getCharacter() == ZOMBIE)
                        gp.getPlayer().setImmune(false);
                    itemReset = true;
                    gp.getPlayer().setItemImmune(false);
                }
                break;
            case SLOW:
                if (mapX > -1500 && !itemUsed) {
                    GAMESPEED = 3;
                    itemUsed = true;
                } else if (mapX < -1500 && !itemReset) {
                    GAMESPEED = 4;
                    if (!gp.getPlayer().isSkillOnUse())
                        itemReset = true;
                }
            case DECREASEHP:
                if (mapX() > -1 && !itemUsed) {
                    gp.getPlayer().setHP(gp.getPlayer().getHP() - 20);
                    System.out.println(gp.getPlayer().getHP());
                    System.out.println("DecreaseHP");
                    itemUsed = true;
                }
                break;
            case MANABOOST:
                if (mapX > -1500 && !itemUsed) {
                    gp.setRateScore(2);
                    System.out.println("Score Increase!!!");
                    itemUsed = true;
                } else if (mapX < -1500 && !itemReset) {
                    gp.setRateScore(1);
                    System.out.println("set rateScore to " + 1);
                    itemReset = true;
                }
                break;
            case INCREASEHP:
                if (mapX() > -1 && !itemUsed) {
                    gp.getPlayer().setHP(gp.getPlayer().getHP() + 30);
                    System.out.println(gp.getPlayer().getMaxHP());
                    System.out.println("IncreaseHP");
                    itemUsed = true;
                    break;
                }
            case SMALLHP:
                if (mapX() > -1 && !itemUsed) {
                    gp.getPlayer().setHP(gp.getPlayer().getHP() + 15);
                    itemUsed = true;
                    break;
                }
        }

    }

    @Override
    public void specificItemSound() {
        switch (whichItem) {
            case FAST:
                GamePanel.playSE(20);
                break;
            case DECREASEHP:
                break;
            case MANABOOST:
                break;
            case INCREASEHP:
                GamePanel.playSE(11);
                break;
            case SLOW:
                break;
        }
    }

    public void setItemAsset() {
        switch (whichItem) {
            case FAST:
                imageItem = Utilz.GetImage("/res/item/fast.png");
                break;
            case DECREASEHP:
                imageItem = Utilz.GetImage("/res/item/posion.png");
                break;
            case MANABOOST:
                imageItem = Utilz.GetImage("/res/item/mana.png");
                break;
            case INCREASEHP:
                imageItem = Utilz.GetImage("/res/item/heart.png");
                break;
            case SLOW:
                imageItem = Utilz.GetImage("/res/item/slow.png");
                break;
            case SMALLHP:
                imageItem = Utilz.GetImage("/res/item/icon1.png");
                break;
        }
    }

}
