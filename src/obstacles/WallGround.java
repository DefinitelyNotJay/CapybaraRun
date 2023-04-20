package obstacles;

import java.awt.Color;
import java.awt.Graphics;
import main.GamePanel;
import methods.Utilz;

public class WallGround extends Wall {
    private int times = 0;
    public WallGround(GamePanel gp, double x, double y, int sizeX, int sizeY) {
        super(gp, x, y, sizeX, sizeY);
    }

    @Override
    public void crash() {
        if (gp.getPlayer().getX()+gp.getPlayer().getWidth()+gp.getPlayer().getCrashAreaWidth() >= this.x
        && gp.getPlayer().getX()+gp.getPlayer().getWidth()+gp.getPlayer().getCrashAreaHeight() <= this.x + width) {
            if (gp.getPlayer().getY()+gp.getPlayer().getHeight()-gp.getPlayer().getCrashAreaHeight() >= this.y) {
                    times++;
                    if (times == 1) {
                        // System.out.println("Hit");
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
