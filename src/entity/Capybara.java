package entity;

import main.GamePanel;
import methods.Utilz;

public class Capybara extends Player {
    public Capybara(GamePanel gp, int HP, int x, int y, int xSize, int ySize) {
        super(gp, HP, x, y, xSize, ySize);
        loadImages();
        skillActivate();
        skill();
    }

    @Override
    public void loadImages() {
        runningAni = Utilz.getRunningImg("/res/player/capybara/capyrun2.png");
        slideAni = Utilz.GetImage("/res/player/capybara/slideCapy.png");
    }

    @Override
    public void update() {
        super.update();

    }

    

    @Override
    public void skill() {
        if (rateDecreaseHP != 0)
            rateDecreaseHP = 0;
    }

    @Override
    public void skillActivate() {
        skill();
    }

    @Override
    public void skillReset() {

    }
}
