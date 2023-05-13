package entity;

import main.GamePanel;
import methods.Utilz;

public class Capybara extends Player {
    public Capybara(GamePanel gp, int character, int HP, int x, int y, int xSize, int ySize) {
        super(gp, character, HP, x, y, xSize, ySize);
        loadImages();
        skillActivate();
        skill();
    }

    @Override
    public void loadImages() {
        normalAnirun = Utilz.getRunningImg("/res/player/capybara/capyrun2.png");
        normalAniSlide = Utilz.GetImage("/res/player/capybara/slideCapy.png");
    }

    @Override
    public void update() {
        super.update();
    }

    @Override
    public void skill() {
        rateDecreaseHP = 0;
    }

    @Override
    public void skillActivate() {
        skill();
    }

    @Override
    public void skillReset() {

    }

    @Override
    public void playerReset() {
        this.HP = maxHP;
    }
}
