package Item;

import main.GamePanel;
import static constant.Constants.*;

public class Item extends SuperObjects {
    private boolean itemUsed = false;
    private boolean itemReset = false;

    public Item(GamePanel gp, int x, int y, int sizeX, int sizeY, String name) {
        super(gp, x, y, sizeX, sizeY, name);
    }

    @Override
    public void effect() {
        if (getName().equals("Fast")) {
            // System.out.println(mapX);
            if (mapX > -1500 && !itemUsed) {
                GAMESPEED = 13;
                gp.getPlayer().setImmune(true);
                itemUsed = true;
            } else if (mapX < -1500 && !itemReset) {
                GAMESPEED = 4;
                if (!gp.getPlayer().isSkillOnUse())
                    gp.getPlayer().setImmune(false);
                itemReset = true;
                System.out.println("CHeck");

            }
        } else if (getName().equals("IncreaseHP")) {
            if (mapX() > -1 && !itemUsed) {
                gp.getPlayer().setHP(gp.getPlayer().getMaxHP());
                System.out.println(gp.getPlayer().getMaxHP());
                System.out.println("IncreaseHP");
                itemUsed = true;
            }

        } else if (getName().equals("DecreaseHP")) {
            if (mapX() > -1 && !itemUsed) {
                gp.getPlayer().setHP(gp.getPlayer().getHP() - 90);
                System.out.println(gp.getPlayer().getHP());
                System.out.println("DecreaseHP");
                itemUsed = true;
            }
        } else if (getName().equals("ScoreBoost")) {
            if (mapX > -1500 && !itemUsed) {
                gp.setRateScore(2);
                System.out.println("Score Increase!!!");
                itemUsed = true;
            } else if (mapX < -1500 && !itemReset) {
                gp.setRateScore(1);
                System.out.println("set rateScore to " + 1);
                itemReset = true;
            }
        }
    }

    @Override
    public void specificItemSound() {
        switch (getName()) {
            case "Fast":
                GamePanel.playSE(20);
            case "DecreaseHP":
            case "ManaBoost":
            case "IncreaseHP":
                GamePanel.playSE(11);

        }
    }

}
