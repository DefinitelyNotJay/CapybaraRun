
package entity;

import java.awt.Graphics;

import main.GamePanel;
import methods.Utilz;

public class Ninja extends Player {

    public Ninja(GamePanel gp, int character, int HP, int x, int y, int xSize, int ySize) {
        super(gp, character, HP, x, y, xSize, ySize);
        loadImages();
        skillCooldown = 8;
        skillDuration = 7;
        skillDurationCount = 0;
    }

    @Override
    public void skill() {
        setSkillOnUse(true);
        setImmune(true);
        GamePanel.playSE(15);
    }

    @Override
    public void skillActivate() {
        if (!skillOnUse) {
            timeCount++;
        }
        if (timeCount == skillCooldown) {
            skill();
            timeCount = 0;
        }
        if (skillOnUse) {
            skillDurationCount++;
        }
        if (skillDurationCount >= skillDuration) {
            skillReset();
        }

    }

    public void updateEverySec() {
        super.updateEverySec();
        skillActivate();
    }

    @Override
    public void skillReset() {
        skillDurationCount = 0;
        setImmune(false);
        setSkillOnUse(false);
    }

    @Override
    public void playerReset() {
        this.HP = maxHP;
        skillOnUse = false;
        timeCount = 0;
        skillDurationCount = 0;
    }

    @Override
    public void loadImages() {
        normalAnirun = Utilz.getRunningImg("/res/player/ninja/capyrun.png");
        normalAniSlide = Utilz.GetImage("/res/player/ninja/capyslide.png");

        skillAniRun = Utilz.getRunningImg("/res/player/ninja/capySkillRun.png");
        skillAniSlide = Utilz.GetImage("/res/player/ninja/capySkillSlide.png");

        runningAni = Utilz.getRunningImg("/res/player/ninja/capyrun.png");
        slideAni = Utilz.GetImage("/res/player/ninja/capyslide.png");
    }

    public void drawPlayerStatusBar(Graphics g2) {
        super.drawPlayerStatusBar(g2);
        g2.drawImage(skillCooldownBar, (int) (x * 0.91), (int) (y * 0.88),
                (int) ((90 / (skillCooldown - 1)) * (timeCount)), (int) (10 * 0.8), null);
        g2.drawImage(skillBar, (int) (x * 0.9), (int) (y * 0.85), (int) (65 * 1.5), (int) (10 * 1.5), null);
        if (skillOnUse) {
            g2.drawImage(skillOnUseBar, (int) (x * 0.9), (int) (y * 0.845), (int) (5 * 2), (int) (5 * 2), null);
            g2.drawImage(skillDurationBar, (int) (x * 0.976), (int) (y * 0.85),
                    (int) ((90 / skillDuration) * (skillDuration - skillDurationCount)), (int) (4 * 2), null);
        }
    }

}
