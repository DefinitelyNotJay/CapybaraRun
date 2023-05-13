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
        button = new Button[3];
        button[CREDITS] = new Button(570, 230, 125, 54);
        button[PLAY] = new Button(570, 170, 125, 54);
        button[QUIT] = new Button(570, 290, 125, 54);
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

        button[PLAY].setImages("/res/screen/menu/start");

        button[CREDITS].setImages("/res/screen/menu/credits");

        button[QUIT].setImages("/res/screen/menu/quit");

        // comment hover button in Button

    }

    public void paint(Graphics g2) {
        g2.drawImage(bgImg, 0, 0, null);
        for (int i = 0; i < button.length; i++) {
            button[i].draw(g2);
        }
        g2.drawImage(runningCapy[aniIndex], 590, 380, (int) (32 * 2.5), (int) (34 * 2.5), null);
    }

    public Button getPlayBtn() {
        return button[PLAY];
    }

    public Button getCreditsBtn() {
        return button[CREDITS];
    }

    public Button getQuitBtn() {
        return button[QUIT];
    }

}
