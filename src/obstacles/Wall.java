package obstacles;

import entity.Entity;
import java.awt.Graphics;
import main.GamePanel;
import static constant.Constants.*;

public abstract class Wall extends Entity {

    protected GamePanel gp;
    // private static final int WALLSPEED = 6;
    protected int width, height, character, wallDamage = 10;
    protected WallPattern wp;
    public double playerX, playerY, playerWidth, playerHeight, playerSolidAreaX, playerSolidAreaY;
    public double firstSetupX;
    protected boolean isDestroy = false, isPlayerSkillOnUse = false;
    protected int playerCharacter;
    protected boolean crashingEffect = false;

    public abstract void crash();

    public abstract void draw(Graphics g2);

    public Wall(GamePanel gp, WallPattern wp, int x, int y, int sizeX, int sizeY) {
        super(x, y);
        this.firstSetupX = x;
        this.gp = gp;
        this.wp = wp;
        this.width = sizeX;
        this.height = sizeY;
    }

    public void update() {
        playerX = gp.getPlayer().getX();
        playerWidth = gp.getPlayer().getWidth();
        playerSolidAreaX = gp.getPlayer().getCrashAreaWidth();
        playerY = gp.getPlayer().getY();
        playerHeight = gp.getPlayer().getHeight();
        playerSolidAreaY = gp.getPlayer().getCrashAreaHeight();
        playerCharacter = gp.getPlayer().getCharacter();
        isPlayerSkillOnUse = gp.getPlayer().isSkillOnUse();
        x -= GAMESPEED;
        wallOutScreen();
        crash();
    }

    public int getWallDamage() {
        return wallDamage;
    }

    public void setWallDamage(int wallDamage) {
        this.wallDamage = wallDamage;
    }

    public void wallOutScreen() {
        if (x + width <= 0) {
            wp.getWallPattern().remove(0);
        }
    }

}
