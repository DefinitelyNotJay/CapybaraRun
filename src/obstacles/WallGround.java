package obstacles;

import java.awt.Color;
import java.awt.Graphics;

import static constant.Constants.*;
import main.GamePanel;

public class WallGround extends Wall {
    private int times = 0;

    public WallGround(GamePanel gp, int x, int y, int sizeX, int sizeY) {
        super(gp, x, y, sizeX, sizeY);
    }

    @Override
    public void crash() {
        if (playerX + playerWidth + playerSolidAreaX >= this.x
                && playerX + playerWidth + playerSolidAreaY <= this.x + width) {
            if (playerY + playerHeight - playerSolidAreaY >= this.y) {
                times++;
                if (times == 1) {
                    if (!gp.getPlayer().isImmune()) {
                        // getDamage
                        gp.getPlayer().setHP(gp.getPlayer().getHP() - WALLDAMAGE);

                        // flinching
                        gp.getPlayer().setFlinching(true);
                    }
                    System.out.println(gp.getPlayer().getClass().getName());
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
        }
    }

    @Override
    public void draw(Graphics g2) {
        g2.setColor(Color.black);
        g2.fillRect((int) x, (int) y, width, height);
    }

}
