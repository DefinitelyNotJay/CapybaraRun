package entity;

import java.awt.image.BufferedImage;
import main.GamePanel;
import methods.Utilz;
import static constant.Constants.*;

public class Ghost extends Player {
    private BufferedImage skillAniRun[], normalAnirun[];
    private BufferedImage skillAniSlide, normalAniSlide;

    public Ghost(GamePanel gp, int HP, int x, int y, int xSize, int ySize) {
        super(gp, HP, x, y, xSize, ySize);
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

    @Override
    public void skill() {
        WALLDAMAGE = 0;
        skillOnUse = true;
        runningAni = skillAniRun;
        GAMESPEED += 10;
        aniSpeed = 1;

    }

    @Override
    public void skillActivate() {
        if (timeCount == skillCooldown) {
            timeCount = 0;
            skill();
        }
        if (skillDurationCount + 1 == skillDuration) {
            GAMESPEED -= 10;
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
        skillOnUse = false;
    }
}
