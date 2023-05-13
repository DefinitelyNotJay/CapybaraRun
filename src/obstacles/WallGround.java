package obstacles;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import static constant.Constants.*;
import main.GamePanel;
import methods.Utilz;

public class WallGround extends Wall {
    private int times = 0;
    private BufferedImage img;

    public WallGround(GamePanel gp, int x, int y, int sizeX, int sizeY) {
        super(gp, x, y, sizeX, sizeY);
        img = Utilz.GetImage("/res/wall/rockblock.png");
    }

    @Override
    public void crash() {
        if (playerX + playerWidth + playerSolidAreaX >= this.x
                && playerX + playerWidth + playerSolidAreaY <= this.x + width) {
            if (playerY + playerHeight - playerSolidAreaY >= this.y) {
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
                    System.out.println(gp.getPlayer().getClass().getName());
                    // special ability for muscle

                }

            }

        } else {
            times = 0;
        }
    }

    @Override
    public void draw(Graphics g2) {
        g2.drawImage(img, x, y, gp.tileSize, gp.tileSize, null);
    }

}
