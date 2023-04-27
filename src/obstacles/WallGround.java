package obstacles;

import java.awt.Color;
import java.awt.Graphics;

import static constant.Constants.*;
import main.GamePanel;

public class WallGround extends Wall {
    private int times = 0;
    public WallGround(GamePanel gp, double x, double y, int sizeX, int sizeY) {
        super(gp, x, y, sizeX, sizeY);
    }

    @Override
    public void crash() {
        if (playerX + playerWidth + playerSolidAreaX >= this.x
        && playerX + playerWidth + playerSolidAreaY <= this.x + width) {
            if (playerY + playerHeight - playerSolidAreaY >= this.y) {
                    times++;
                    if (times == 1) {
                        // System.out.println("Hit");
                        gp.getPlayer().setHP(gp.getPlayer().getHP() - WALLDAMAGE);
                        System.out.println(gp.getPlayer().getHP());
                        if (gp.getPlayer().isSkillOnUse() && gp.getPlayer().getClass().getName().equals("player.Muscle")){
                            gp.getPlayer().setHP(gp.getPlayer().getHP()+10);
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
