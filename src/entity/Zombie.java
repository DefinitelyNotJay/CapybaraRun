
package entity;

import main.GamePanel;
import methods.Utilz;
import static constant.Constants.*;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Zombie extends Player {
    private int lives = 5;
    private BufferedImage greenHeart;

    public Zombie(GamePanel gp, int character, int HP, int x, int y, int xSize, int ySize) {
        super(gp, character, HP, x, y, xSize, ySize);
        loadImages();
    }

    @Override
    public void loadImages() {
        greenHeart = Utilz.GetImage("/res/player/zombie/greenHeart.png");

        normalAnirun = Utilz.getRunningImg("/res/player/zombie/capyrun.png");
        normalAniSlide = Utilz.GetImage("/res/player/zombie/capyslide.png");

        skillAniRun = Utilz.getRunningImg("/res/player/zombie/capySkillRun.png");
        skillAniSlide = Utilz.GetImage("/res/player/zombie/capySkillSlide.png");

        runningAni = Utilz.getRunningImg("/res/player/zombie/capyrun.png");
        slideAni = Utilz.GetImage("/res/player/zombie/capyslide.png");

    }

    public void drawPlayerStatusBar(Graphics g2) {
        for (int i = 0; i < lives; i++)
            g2.drawImage(greenHeart, x + (i * 20), y - 20, (int) (gp.tileSize * 0.25),
                    (int) (gp.tileSize * 0.25), null);
        super.drawPlayerStatusBar(g2);
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
        GamePanel.playSE(13);
        setSkillOnUse(true);
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

    @Override
    public void playerReset() {
        this.HP = maxHP;
        lives = 5;
    }

}
