package obstacles;

import java.awt.Color;
import java.awt.Graphics;
import main.GamePanel;
import static constant.Constants.*;

public class WallHanging extends Wall {

    private int times = 0;

    public WallHanging(GamePanel gp, int x, int y, int sizeX, int sizeY) {
        super(gp, x, y, sizeX, sizeY);
    }

    @Override
    public void crash() {
        if (playerX - playerSolidAreaX >= this.x
                && playerX + playerSolidAreaX <= this.x + width) {
            if (playerY + playerSolidAreaY <= this.y + height) {
                times++;
                if (times == 1) {
                    if (gp.getPlayer().isSkillOnUse() && gp.getPlayer().getCharacter() == MUSCLE) {
                        if (gp.getPlayer().getHP() + 5 <= gp.getPlayer().getMaxHP()) {
                            gp.getPlayer().setHP(gp.getPlayer().getHP() + 5);
                        }
                    } else if (!gp.getPlayer().isImmune()) {
                        // getDamage
                        gp.getPlayer().setHP(gp.getPlayer().getHP() - WALLDAMAGE);
                        GamePanel.playhit(6);

                        // flinching
                        gp.getPlayer().setFlinching(true);
                    }

                    // special ability for muscle

                }
            }
        } else {
            times = 0;
        }
    }

    @Override
    public void draw(Graphics g2) {
        g2.setColor(Color.black);
        g2.fillRect((int) x, (int) y, width, height);
    }
}
