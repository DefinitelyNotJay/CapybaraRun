
package entity;

import main.GamePanel;
import methods.SpecialAbility;
import methods.Utilz;
import static constant.Constants.*;

import java.util.concurrent.TimeUnit;

public class Zombie extends Player {
    private int lives = 5;

    public Zombie(GamePanel gp, int HP, int x, int y, int xSize, int ySize) {
        super(gp, HP, x, y, xSize, ySize);
        loadImages();
    }

    @Override
    public void loadImages() {
        runningAni = Utilz.getRunningImg("/res/player/zombie/runCapy.png");
        slideAni = Utilz.GetImage("/res/player/zombie/slideCapy.png");
    }

    @Override
    public void update() {
        super.update();
        skillActivate();

    }

    @Override
    public void skill() {
        HP = 10;
        lives--;
        rateDecreaseHP = 0;

    }

    @Override
    public void healthCheck() {
        if (HP <= 0 && lives < 1) {
            GamePanel.GameState = DEAD;
        }
    }

    @Override
    public void skillActivate() {
        if (HP <= 0 && lives >= 1) {
            skill();
        }
    }

    @Override
    public void skillReset() {

    }

}
