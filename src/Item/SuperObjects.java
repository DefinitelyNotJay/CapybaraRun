package Item;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import entity.Entity;
import main.Game;
import main.GamePanel;

public class SuperObjects {
    private BufferedImage Image;
    private String name;
    private boolean collision = false;
    public int mapX, mapY, sizeX, sizeY;
    private GamePanel gp;

    public SuperObjects(GamePanel gp, int x, int y, int sizeX, int sizeY) {
        this.mapX = x;
        this.mapY = y;
        this.gp = gp;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
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
        g2.fillRect(mapX(), mapY(), sizeX, sizeY);
    }
}
