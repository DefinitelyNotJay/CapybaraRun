package screen;

import java.awt.*;
import javax.swing.*;
import methods.Utilz;
import java.awt.image.BufferedImage;

public class MenuGame extends JPanel {

    public Button[] button;
    public final int CREDITS = 0, PLAY = 1, QUIT = 2;
    private BufferedImage bgImg;

    public MenuGame() {
        buttonCreate();
        loadImages();

    }

    public void buttonCreate() {
        button = new Button[3];
        button[CREDITS] = new Button(444, 130, 125, 54);
        button[PLAY] = new Button(418, 70, 125, 54);
        button[QUIT] = new Button(410, 190, 125, 54);
    }

    private void loadImages() {
        bgImg = Utilz.GetImage("/res/screen/menu/menu bg.png");

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
    }
}
