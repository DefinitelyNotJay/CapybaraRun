package player;

import entity.Player;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;
import methods.SpecialAbility;
import methods.Utilz;

public class Ghost extends Player implements SpecialAbility{
    public Ghost(int HP, double x, double y, int xSize, int ySize) {
        super(HP, x, y, xSize, ySize);
        loadImages();
    }
    
    @Override
    public void loadImages() {
        runningAni = Utilz.getRunningImg("/res/player/ghost/capyrun.png");
        slideAni = Utilz.GetImage("/res/player/ghost/capyslide.png");
    }

    @Override
    public void skill() {
    }

    @Override
    public void skillActivate() {

    }
}
