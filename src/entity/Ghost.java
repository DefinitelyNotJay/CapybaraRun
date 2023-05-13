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
        skillAniRun = Utilz.getRunningImg("/res/player/ghost/capyskill.png");
        // skillAniSlide = Utilz.GetImage("/res/player/ghost/capyrun.png");
        runningAni = normalAnirun;
        slideAni = normalAniSlide;

    }

    public void drawPlayerStatusBar(Graphics g2) {
        super.drawPlayerStatusBar(g2);
        g2.drawImage(skillCooldownBar, (int) (x * 0.91), (int) (y * 0.88),
                (int) ((90 / (skillCooldown - 1)) * (timeCount)), (int) (10 * 0.8), null);
        g2.drawImage(skillBar, (int) (x * 0.9), (int) (y * 0.85), (int) (65 * 1.5), (int) (10 * 1.5), null);
    }

    public void update() {
        super.update();
    }

    @Override
    public void skill() {
        setImmune(true);
        setSkillOnUse(true);
        runningAni = skillAniRun;
        GAMESPEED = 30;
        aniSpeed = 1;

    }

    @Override
    public void skillActivate() {
        if (timeCount == skillCooldown) {
            skill();
            timeCount = 0;
        }
        if (skillDurationCount + 1 == skillDuration) {
            GAMESPEED = 6;
            aniSpeed = 7;
        }
        if (skillDurationCount == skillDuration) {
            skillReset();
        }
        if (skillOnUse) {
            skillDurationCount++;
        }
        if (!skillOnUse) {
            timeCount++;
        }
    }

    @Override
    public void updateEverySec() {
        super.updateEverySec();
        skillActivate();
        // immortal before running

    }

    @Override
    public void skillReset() {
        runningAni = normalAnirun;
        WALLDAMAGE = 10;
        // reset animation
        skillDurationCount = 0;
        setSkillOnUse(false);
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
