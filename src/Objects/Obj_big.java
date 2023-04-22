package Objects;

import java.awt.Color;
import java.awt.Graphics;
import main.GamePanel;

public class Obj_big {
    private int times = 0;
    private boolean collision = false;

    public Obj_big(GamePanel gp, double x, double y, int sizeX, int sizeY) {
        super(gp, x, y, sizeX, sizeY);
    }

    // @Override
    // public void Obcrash() {
    //     if (gp.getPlayer().getX()+gp.getPlayer().getWidth()+gp.getPlayer().getCrashAreaWidth() >= this.x
    //     && gp.getPlayer().getX()+gp.getPlayer().getWidth()+gp.getPlayer().getCrashAreaHeight() <= this.x + width) {
    //         if (gp.getPlayer().getY()+gp.getPlayer().getHeight()-gp.getPlayer().getCrashAreaHeight() >= this.y) {
    //                 times++;
    //                 if (times == 1) {
    //                     System.out.println("Hit");
    //                     collision = true;
    //                 }
    //         }

    //     } else {
    //         times = 0;
    //     }
    // }

    // @Override
    // public void draw(Graphics g2) {
    //     g2.setColor(Color.black);
    //     g2.fillRect((int) x, (int) y, width, height);
    // }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public boolean getCollision() {
        return collision;
    }

    public void setCollision(boolean collision) {
        this.collision = collision;
    }

}
