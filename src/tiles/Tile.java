package tiles;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import main.GamePanel;
import methods.Utilz;

public class Tile{
    public BufferedImage[] tiles;
    private GamePanel gp;
    public Tile(GamePanel gp){
        this.gp = gp;
        tiles = new BufferedImage[5];
        loadImages();
    }

    public void loadImages() {
        tiles[0] = Utilz.GetImage("/res/tiles/tiles1.png");
        tiles[1] = Utilz.GetImage("/res/tiles/tiles2.png");
    }

    public void draw(Graphics2D g2){
        for(int i = 0; i < 30; i++)
        g2.drawImage(tiles[1], i*gp.tileSize, 256+gp.tileSize, gp.tileSize, gp.tileSize,null);
    }
}
