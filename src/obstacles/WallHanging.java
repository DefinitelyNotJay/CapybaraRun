package obstacles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import main.GamePanel;
import methods.Utilz;
import static constant.Constants.*;

public class WallHanging extends Wall {
    private BufferedImage img;

    public WallHanging(GamePanel gp, WallPattern wp, int x, int y, int sizeX, int sizeY) {
        super(gp, wp, x, y, sizeX, sizeY);
    }

    public void updateWallSkin() {
        switch (gp.getTile().getTileStage()) {
            case FOREST:
                img = Utilz.GetImage("/res/wall/Bramble_1.png");
                break;
            case MOUNTAIN:
                img = Utilz.GetImage("/res/wall/Fire_12_.png");
                break;
            case BEACH:
                img = Utilz.GetImage("/res/wall/Stone_3.png");
                break;
            case NIGHT:
                img = Utilz.GetImage("/res/wall/DarkCastle_24.png");
                break;
            case VILLAGE:
                img = Utilz.GetImage("/res/wall/crate.png"); 
                break;
        }
    }

    @Override
    public void crash() {
        boolean isPlayerCollide = (playerX - playerSolidAreaX >= this.x && playerX + playerSolidAreaX <= this.x + width)
                && (playerY + playerSolidAreaY <= this.y + height);
        if (isPlayerCollide) {
            if (!crashingEffect) {
                // case NINJA && MUSCLE
                if (isPlayerSkillOnUse && (playerCharacter == MUSCLE || playerCharacter == NINJA)) {
                    switch (playerCharacter) {
                        case MUSCLE:
                            if (gp.getPlayer().getHP() + 5 <= gp.getPlayer().getMaxHP()) {
                                gp.getPlayer().setHP(gp.getPlayer().getHP() + 5);
                                GamePanel.playSE(22);
                            }
                            isDestroy = true;
                            break;
                        case NINJA:
                            gp.setScore(gp.getScore() + 100);
                            isDestroy = true;
                            break;
                    }
                } else if (!gp.getPlayer().isImmune()) {
                    // getDamage
                    gp.getPlayer().setHP(gp.getPlayer().getHP() - WALLDAMAGE);
                    GamePanel.playhit(6);
                    // flinching
                    gp.getPlayer().setFlinching(true);
                }
            }
            crashingEffect = true;
            // special ability for muscle

        }
    }

    @Override
    public void draw(Graphics g2) {
        if (!isDestroy)
            g2.drawImage(img, x, y, gp.tileSize, gp.tileSize, null);
    }
}
