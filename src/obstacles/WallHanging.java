package obstacles;

import java.awt.Color;
import java.awt.Graphics;
import main.GamePanel;

public class WallHanging extends Wall {

    private int times = 0;

    public WallHanging(GamePanel gp, double x, double y, int sizeX, int sizeY) {
        super(gp, x, y, sizeX, sizeY);
    }
    @Override
    public void crash() {
        if (playerX - playerSolidAreaX >= this.x 
                && playerX + playerSolidAreaX <= this.x + width) {
            if (playerY + playerSolidAreaY <= this.y + height) {
                times++;
                if (times == 1) {
                    // System.out.println("crash");
                    gp.getPlayer().setHP(gp.getPlayer().getHP() - 10);
                    System.out.println(gp.getPlayer().getHP());
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
