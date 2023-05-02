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
        button[CREDITS] = new Button(284, 263, 230, 72);
        button[PLAY] = new Button(517, 263, 230, 72);
        button[QUIT] = new Button(752, 263, 230, 72);
    }

    private void loadImages() {
        bgImg = Utilz.GetImage("/res/screen/menu/final_menu.png");

        button[PLAY].setImages("/res/screen/menu/btn_play");

        button[CREDITS].setImages("/res/screen/menu/btn_credits");

        button[QUIT].setImages("/res/screen/menu/btn_quit");

        // comment hover button in Button

    }

    public void paint(Graphics g2) {
        g2.drawImage(bgImg, 0, 0, null);
        for (int i = 0; i < button.length; i++) {
            button[i].draw(g2);
        }
    }
}
