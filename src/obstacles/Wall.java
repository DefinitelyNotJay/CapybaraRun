package obstacles;

import entity.Entity;
import entity.Entity;
import java.awt.Color;
import java.awt.Graphics;
import main.GamePanel;

public abstract class Wall extends Entity {
    
    protected GamePanel gp;
    private static final int WALLSPEED = 6;
    protected int width, height;
    public abstract void crash();
    public abstract void draw(Graphics g2);

    public Wall(GamePanel gp, double x, double y, int sizeX, int sizeY) {
        super(x, y);
        this.gp = gp;
        this.width = sizeX;
        this.height = sizeY;
    }

    public void update() {
        x -= WALLSPEED;
        if (x < 0) {
            x = 1100;
        }
        crash();
    }

}
