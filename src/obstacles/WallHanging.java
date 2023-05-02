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
                    // getDamage
                    gp.getPlayer().setHP(gp.getPlayer().getHP() - WALLDAMAGE);

                    // flinching
                    gp.getPlayer().setFlinching(true);

                    // set immune player to true
                    // gp.getPlayer().setImmune(true);

                    // special ability for muscle
                    if (gp.getPlayer().isSkillOnUse() && gp.getPlayer().getClass().getName().equals("entity.Muscle")) {
                        if (gp.getPlayer().getHP() + 10 <= gp.getPlayer().getMaxHP()) {
                            gp.getPlayer().setHP(gp.getPlayer().getHP() + 10);
                        }
                    }
                }
            }
        } else {
            times = 0;
            gp.getPlayer().setIsCrash(false);
        }
    }

    @Override
    public void draw(Graphics g2) {
        g2.setColor(Color.black);
        g2.fillRect((int) x, (int) y, width, height);
    }
}
