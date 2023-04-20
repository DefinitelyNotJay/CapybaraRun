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
        if (gp.getPlayer().getCrashAreaWidth()-gp.getPlayer().getCrashAreaWidth() >= this.x
        && gp.getPlayer().getCrashAreaWidth()+gp.getPlayer().getCrashAreaWidth() <= this.x + width) {
            if (gp.getPlayer().getY()+Utilz.tileSize >= this.y) {
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
        g2.drawLine((int)x, (int)gp.getPlayer().getY()+Utilz.tileSize, 5, 5);
        g2.setColor(Color.black);
        g2.fillRect((int) x, (int) y, width, height);
    }

}
