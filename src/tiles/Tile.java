package tiles;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.*;

import static constant.Constants.*;
import main.GamePanel;
import methods.Utilz;
import obstacles.WallPattern;

public class Tile {
    public BufferedImage[] tiles;
    public BufferedImage bgImg;
    private GamePanel gp;
    private int tileStage;
    private int stateChangeEvery, stateCheck;
    List<Integer> stageOrder;
    WallPattern wp;

    public Tile(GamePanel gp, WallPattern wp) {
        this.gp = gp;
        this.wp = wp;
        tiles = new BufferedImage[5];
        randomStage();
    }

    public void update() {
        stageChange();
    }

    public void randomStage() {
        stateChangeEvery = (int) (wp.getWallSize() / 5);
        stateCheck = stateChangeEvery;
        Set<Integer> num = new HashSet<>();
        while (num.size() != 5) {
            num.add((int) Math.floor(Math.random() * (4 - 0 + 1) + 0));
        }
        stageOrder = new ArrayList<>(num);
        Collections.shuffle(stageOrder);
        tileStage = stageOrder.get(0);
    }

    private void stageChange() {
        if (wp.getWallSize() - wp.getWallPattern().size() >= stateCheck) {
            stateCheck += stateChangeEvery;
            if (tileStage >= 4 || tileStage == 0) {
                tileStage = 0;
            } else {
                tileStage++;
            }
            tileUpdate();
        }
    }

    public void draw(Graphics2D g2) {
        g2.drawImage(bgImg, null, 0, 0);
        for (int i = 0; i < 24; i++)
            g2.drawImage(tiles[0], i * (int) (gp.tileSize), 284 + (int) (gp.tileSize * 1.7),
                    (int) (gp.tileSize), (int) (gp.tileSize * 1.3), null);
    }

    public void tileUpdate() {
        GamePanel.stopMusic();
        switch (stageOrder.get(tileStage)) {
            case FOREST:
                GamePanel.playMusic(2);
                bgImg = Utilz.GetImage("/res/tiles/18.png");
                tiles[0] = Utilz.GetImage("/res/tiles/tiles1-1.png");
                break;
            case NIGHT:
                GamePanel.playMusic(16);
                bgImg = Utilz.GetImage("/res/tiles/01_bg.png");
                tiles[0] = Utilz.GetImage("/res/tiles/03_ground.png");
                break;
            case BEACH:
                GamePanel.playMusic(17);
                bgImg = Utilz.GetImage("/res/tiles/04_bg.png");
                tiles[0] = Utilz.GetImage("/res/tiles/04_ground.png");
                break;
            case VILLAGE:
                GamePanel.playMusic(18);
                bgImg = Utilz.GetImage("/res/tiles/03_bg.png");
                tiles[0] = Utilz.GetImage("/res/tiles/03_ground.png");
                break;
            case MOUNTAIN:
                GamePanel.playMusic(19);
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
