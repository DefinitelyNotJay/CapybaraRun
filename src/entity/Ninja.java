
package entity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import constant.Constants;
import main.GamePanel;
import methods.SpecialAbility;
import methods.Utilz;

public class Ninja extends Player {
    private BufferedImage skillAniRun[], normalAnirun[];
    private BufferedImage skillAniSlide, normalAniSlide;

    public Ninja(GamePanel gp, int character, int HP, int x, int y, int xSize, int ySize) {
        super(gp, character, HP, x, y, xSize, ySize);
        loadImages();
    }

    @Override
    public void loadImages() {
        runningAni = Utilz.getRunningImg("/res/player/ninja/capyrun.png");
        slideAni = Utilz.GetImage("/res/player/ninja/capyslide.png");
    }

    public void drawPlayerStatusBar(Graphics g2) {
        super.drawPlayerStatusBar(g2);
        g2.drawImage(skillCooldownBar, (int) (x * 0.91), (int) (y * 0.88),
                (int) ((90 / (skillCooldown - 1)) * (timeCount)), (int) (10 * 0.8), null);
        g2.drawImage(skillBar, (int) (x * 0.9), (int) (y * 0.85), (int) (65 * 1.5), (int) (10 * 1.5), null);
    }

    @Override
    public void skill() {
        Constants.WALLDAMAGE = 0;
    }

    @Override
    public void skillActivate() {

    }

    public void updateEverySec() {

    }

    @Override
    public void skillReset() {

    }

    @Override
    public void playerReset() {
        this.HP = maxHP;
        skillOnUse = false;
        timeCount = 0;
        skillDurationCount = 0;
    }

}
