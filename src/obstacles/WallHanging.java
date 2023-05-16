package obstacles;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.net.InetSocketAddress;

import main.GamePanel;
import methods.Utilz;

import static constant.Constants.*;

public class WallHanging extends Wall {
    private BufferedImage img;

    public WallHanging(GamePanel gp, WallPattern wp, int x, int y, int sizeX, int sizeY) {
        super(gp, wp, x, y, sizeX, sizeY);
        img = Utilz.GetImage("/res/wall/wall3.png");
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
                            gp.setScore(gp.getScore() + 500);
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
