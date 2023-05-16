package entity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import main.GamePanel;
import methods.Utilz;
import static constant.Constants.*;

public class Ghost extends Player {

    public Ghost(GamePanel gp, int character, int HP, int x, int y, int xSize, int ySize) {
        super(gp, character, HP, x, y, xSize, ySize);
        skillCooldown = 10;
        skillDuration = 5;
        skillDurationCount = 0;
        loadImages();
    }

    @Override
    public void loadImages() {
        normalAnirun = Utilz.getRunningImg("/res/player/ghost/capyrun.png");
        normalAniSlide = Utilz.GetImage("/res/player/ghost/capyslide.png");

        skillAniRun = Utilz.getRunningImg("/res/player/ghost/capySkillRun.png");
        skillAniSlide = Utilz.GetImage("/res/player/ghost/capySkillSlide.png");

        runningAni = Utilz.getRunningImg("/res/player/ghost/capyrun.png");
        slideAni = Utilz.GetImage("/res/player/ghost/capyslide.png");

    }

    public void drawPlayerStatusBar(Graphics g2) {
        super.drawPlayerStatusBar(g2);
        g2.drawImage(skillCooldownBar, (int) (x * 0.91), (int) (y * 0.88),
                (int) ((90 / (skillCooldown - 1)) * (timeCount)), (int) (10 * 0.8), null);
        g2.drawImage(skillBar, (int) (x * 0.9), (int) (y * 0.85), (int) (65 * 1.5), (int) (10 * 1.5), null);
    }

    public void update() {
        super.update();
        HP = 100;
    }

    @Override
    public void skill() {
        setImmune(true);
        setSkillOnUse(true);
        GAMESPEED = 13;
        aniSpeed = 1;
        GamePanel.playSE(14);

    }

    @Override
    public void skillActivate() {
        if (timeCount == skillCooldown) {
            skill();
            timeCount = 0;
        }

    }

    @Override
    public void updateEverySec() {
        super.updateEverySec();
        if (skillDurationCount == skillDuration) {
            skillReset();
        }
        if (skillOnUse) {
            skillDurationCount++;
        }
        if (!skillOnUse) {
            timeCount++;
        }
        skillActivate();
        if (skillDurationCount + 1 == skillDuration) {
            GAMESPEED = 4;
            aniSpeed = 7;
        }

        // immortal before running

    }

    @Override
    public void skillReset() {
        // reset animation
        skillDurationCount = 0;
        setSkillOnUse(false);
        timeCount = 0;
        setImmune(false);
    }

    @Override
    public void playerReset() {
        this.HP = maxHP;
        skillOnUse = false;
        timeCount = 0;
        skillDurationCount = 0;
    }
}
