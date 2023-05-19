package screen;

import java.awt.*;
import javax.swing.*;

import methods.Animations;
import methods.ScreenTools;
import methods.Utilz;
import java.awt.image.BufferedImage;

public class MenuGame extends JPanel implements Animations, ScreenTools {

    public Button[] button;
    private int aniTick, aniIndex, aniSpeed = 5;
    private BufferedImage[] runningCapy;
    public final int CREDITS = 0, PLAY = 1, QUIT = 2;
    private BufferedImage bgImg;

    public MenuGame() {
        buttonCreate();
        loadImages();
    }

    public void update() {
        updateAnimations();
    }

    public void buttonCreate() {
        button = new Button[5];
        button[0] = new Button(570 + 160, 210, 125, 54);
        button[1] = new Button(250, 210, 125, 54);
        button[2] = new Button(730 + 160, 210, 125, 54);
        button[3] = new Button(410 + 160, 210, 125, 54);
        button[4] = new Button(250 + 160, 210, 125, 54);
    }

    @Override
    public void updateAnimations() {
        aniTick++;
        if (aniTick >= aniSpeed) {
            aniTick = 0;
            aniIndex++;
        }

        if (aniIndex >= 7) {
            aniIndex = 0;
        }
    }

    @Override
    public void loadImages() {
        runningCapy = Utilz.getRunningImg("/res/player/capybara/capyrun2.png");

        bgImg = Utilz.GetImage("/res/screen/menu/Menu.png");

        button[0].setImages("/res/screen/menu/credits");

        button[1].setImages("/res/screen/menu/start");

        button[2].setImages("/res/screen/menu/quit");

        button[3].setImages("/res/screen/menu/score"); // score

        button[4].setImages("/res/screen/menu/howto"); // how to

    }

    public void paint(Graphics g2) {
        g2.drawImage(bgImg, 0, 0, null);
        for (int i = 0; i < button.length; i++) {
            button[i].draw(g2);
        }
        g2.drawImage(runningCapy[aniIndex], 590, 380, (int) (32 * 2.5), (int) (34 * 2.5), null);
    }

    public Button getCreditsBtn() {
        return button[0];
    }

    public Button getPlayBtn() {
        return button[1];
    }

    public Button getQuitBtn() {
        return button[2];
    }

    public Button getScoreBtn() {
        return button[3];
    }

    public Button getHowToBtn() {
        return button[4];
    }

}
