package Objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import entity.Entity;
import main.Game;
import main.GamePanel;

public class SuperObjects extends Entity {
    private BufferedImage Image;
    private String name;
    private boolean collision = false;
    public int mapX, mapY, width, height;
    private GamePanel gp;

    public SuperObjects(GamePanel gp, double x, double y, int sizeX, int sizeY) {
        super(x, y);
        this.gp = gp;
        this.mapX = sizeX;
        this.mapY = sizeY;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void mapX(int mapX){
        this.mapX = mapX;
    }
    public int mapX(){
        return mapX;
    }
    public void mapy(int mapY){
        this.mapY = mapY;
    }
    public int mapY(){
        return mapY;
    }
    public void setCollision(boolean collision){
        this.collision = collision;
    }
    public boolean getCollision(){
        return collision;
    }
    public void draw(Graphics g2) {
        g2.setColor(Color.red);
        g2.fillRect((int) mapX, (int) mapY, width, height);
    }
}
