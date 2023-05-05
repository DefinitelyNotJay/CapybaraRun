package entity;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;
import methods.SpecialAbility;
import methods.Utilz;

public class Capybara extends Player {
    public Capybara(GamePanel gp, int HP, int x, int y, int xSize, int ySize) {
        super(gp, HP, x, y, xSize, ySize);
        loadImages();
        skillActivate();
    }

    @Override
    public void loadImages() {
        runningAni = Utilz.getRunningImg("/res/player/capybara/capyrun2.png");
        slideAni = Utilz.GetImage("/res/player/capybara/slideCapy.png");
    }

    @Override
    public void update() {
        move();
        updateAnimations();
        healthCheck();
    }

    @Override
    public void skill() {
        rateDecreaseHP = 0;
        HP = 150;
    }

    @Override
    public void skillActivate() {
        skill();
    }

    @Override
    public void skillReset() {

    }
}
