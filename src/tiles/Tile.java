package tiles;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import static constant.Constants.*;
import main.GamePanel;
import methods.Utilz;

public class Tile {
    public BufferedImage[] tiles;
    public BufferedImage bgImg;
    private GamePanel gp;
    private int tileStage = NIGHT;

    public Tile(GamePanel gp) {
        this.gp = gp;
        tiles = new BufferedImage[5];
        tileUpdate();
    }

    public void draw(Graphics2D g2) {
        g2.drawImage(bgImg, null, 0, 0);
        for (int i = 0; i < 24; i++)
            g2.drawImage(tiles[0], i * (int) (gp.tileSize), 284 + (int) (gp.tileSize * 1.7),
                    (int) (gp.tileSize), (int) (gp.tileSize * 1.3), null);
        // g2.drawImage(tiles[0], (int) (gp.tileSize * 1.7) * 3, 288 + (int)
        // (gp.tileSize * 1.7),
        // (int) (gp.tileSize * 1.7), (int) (gp.tileSize * 1.7), null);
        // g2.drawImage(tiles[0], (int) (gp.tileSize * 1.7) * 6, 288 + (int)
        // (gp.tileSize * 1.7),
        // (int) (gp.tileSize * 1.7), (int) (gp.tileSize * 1.7), null);
    }

    public void tileUpdate() {
        switch (tileStage) {
            case FOREST:
                bgImg = Utilz.GetImage("/res/tiles/18.png");
                tiles[0] = Utilz.GetImage("/res/tiles/tiles1-1.png");
                break;
            case NIGHT:
                bgImg = Utilz.GetImage("/res/tiles/01_bg.png");
                tiles[0] = Utilz.GetImage("/res/tiles/03_ground.png");
                break;
            case BEACH:
                bgImg = Utilz.GetImage("/res/tiles/04_bg.png");
                tiles[0] = Utilz.GetImage("/res/tiles/04_ground.png");
                break;
            case VILLAGE:
                bgImg = Utilz.GetImage("/res/tiles/03_bg.png");
                tiles[0] = Utilz.GetImage("/res/tiles/03_ground.png");
                break;
            case MOUNTAIN:
                bgImg = Utilz.GetImage("/res/tiles/02_bg.png");
                tiles[0] = Utilz.GetImage("/res/tiles/02_ground.png");
                break;
        }
    }

    public int getTileStage() {
        return tileStage;
    }

    public void setTileStage(int tileStage) {
        this.tileStage = tileStage;
    }

}
