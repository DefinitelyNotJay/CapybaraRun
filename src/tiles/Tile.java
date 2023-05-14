package tiles;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import main.GamePanel;
import methods.Utilz;

public class Tile {
    public BufferedImage[] tiles;
    public BufferedImage bgImg;
    private GamePanel gp;

    public Tile(GamePanel gp) {
        this.gp = gp;
        tiles = new BufferedImage[5];
        loadImages();
    }

    public void loadImages() {
        bgImg = Utilz.GetImage("/res/tiles/18.png");
        tiles[0] = Utilz.GetImage("/res/tiles/tiles1-1.png");
        tiles[1] = Utilz.GetImage("/res/tiles/tiles2-2.png");
    }

    public void draw(Graphics2D g2) {
        g2.drawImage(bgImg, null, 0, 0);
        for (int i = 0; i < 24; i++)
            g2.drawImage(tiles[0], i * (int) (gp.tileSize * 1.7), 284 + (int) (gp.tileSize * 1.7),
                    (int) (gp.tileSize * 1.7), (int) (gp.tileSize * 1.7), null);
        // g2.drawImage(tiles[0], (int) (gp.tileSize * 1.7) * 3, 288 + (int)
        // (gp.tileSize * 1.7),
        // (int) (gp.tileSize * 1.7), (int) (gp.tileSize * 1.7), null);
        // g2.drawImage(tiles[0], (int) (gp.tileSize * 1.7) * 6, 288 + (int)
        // (gp.tileSize * 1.7),
        // (int) (gp.tileSize * 1.7), (int) (gp.tileSize * 1.7), null);
    }

}
