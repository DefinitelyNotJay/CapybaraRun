package player;

import entity.Player;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;
import methods.Utilz;

public class Capybara extends Player {
    // private int aniTick, aniIndex, aniSpeed=10;
    public Capybara(int HP, double x, double y, int xSize, int ySize) {
        super(HP, x, y, xSize, ySize);
        loadImages();
    }
    
    @Override
    public void loadImages() {
        runningAni = Utilz.getRunningImg("/res/player/capybara/capyrun2.png");
        slideAni = Utilz.GetImage("/res/player/capybara/slideCapy.png");
    }




}
