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
        if (gp.getPlayer().getX()-gp.getPlayer().getCrashAreaWidth() >= this.x 
                && gp.getPlayer().getX()+gp.getPlayer().getCrashAreaWidth() <= this.x + width) {
            if (gp.getPlayer().getY()+gp.getPlayer().getCrashAreaHeight() <= this.y + height) {
                times++;
                if (times == 1) {
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
        // g2.drawLine((int)gp.getPlayer().x, (int)gp.getPlayer().y+gp.getPlayer().crashAreaHeight, 3, 3);
        g2.setColor(Color.black);
        g2.fillRect((int) x, (int) y, width, height);
    }
}
