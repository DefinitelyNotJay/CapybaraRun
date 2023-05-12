package entity;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;
import methods.SpecialAbility;
import methods.Utilz;
import static constant.Constants.*;

public class Muscle extends Player {

    public Muscle(GamePanel gp, int HP, int x, int y, int xSize, int ySize) {
        super(gp, HP, x, y, xSize, ySize);
        loadImages();
        skillCooldown = 10;
        skillDuration = 5;
        skillDurationCount = 0;
    }

    @Override
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

    @Override
    public void loadImages() {
        runningAni = Utilz.getRunningImg("/res/player/muscle/capyrun.png");
        slideAni = Utilz.GetImage("/res/player/muscle/capyslide.png");
    }

    @Override
    public void skill() {
        gp.getPlayer().setImmune(true);
        skillOnUse = true;
    }

    @Override
    public void skillActivate() {
        if (timeCount == skillCooldown) {
            timeCount = 0;
            skill();
        }
    }

    @Override
    public void skillReset() {
        gp.getPlayer().setImmune(false);
        skillOnUse = false;
        skillDurationCount = 0;
    }

    @Override
    public void updateEverySec() {
        super.updateEverySec();
        skillActivate();
        if (HP <= 100 && !skillOnUse) {
            timeCount++;
        }
        if (skillOnUse) {
            skillDurationCount++;
        }
        if (skillDurationCount == skillDuration) {
            skillReset();
        }

    }
}
