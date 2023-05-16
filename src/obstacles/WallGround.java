package obstacles;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import static constant.Constants.*;
import main.GamePanel;
import methods.Utilz;

public class WallGround extends Wall {
    private int times = 0;
    private BufferedImage img;

    public WallGround(GamePanel gp, WallPattern wp, int x, int y, int sizeX, int sizeY) {
        super(gp, wp, x, y, sizeX, sizeY);
        img = Utilz.GetImage("/res/wall/wall.png");
    }

    @Override
    public void crash() {
        boolean isPlayerCollide = (playerX - playerSolidAreaX >= this.x && playerX + playerSolidAreaX <= this.x + width)
                && (playerY + playerHeight - playerSolidAreaY >= this.y);
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
