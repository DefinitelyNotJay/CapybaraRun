package Item;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import entity.Player;
import main.GamePanel;
import methods.Utilz;
import obstacles.Wall;

public class Obj_Item extends SuperObjects {
    
    public GamePanel gp;
    public Wall wall;
    public Obj_Item(GamePanel gp,int x, int y,int sizeX, int sizeY, String name){
        super(gp, x, y, sizeX, sizeY);
        setName(name);
    }
    
    
}
