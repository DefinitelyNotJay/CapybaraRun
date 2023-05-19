package screen;

import java.awt.*;
import javax.swing.*;
import methods.ScreenTools;
import methods.Utilz;
import java.awt.image.BufferedImage;

public class Howto2 implements ScreenTools {

    public Button[] button;
    private BufferedImage bgImg;

    public Howto2() {
        buttonCreate();
        loadImages();
    }

    public void buttonCreate() {
        button = new Button[2];
        button[0] = new Button(570, 230, 125, 54);
        button[1] = new Button(570, 170, 125, 54);

    }

    @Override
    public void loadImages() {

        bgImg = Utilz.GetImage("/res/screen/menu/Menu.png"); //screen 2 images

        button[0].setImages("/res/screen/howto/back"); // back

        button[1].setImages("/res/screen/howto/Menu"); // Menu

        bgImg = Utilz.GetImage("res/screen/howto/bgImg.png");

    }

    public void paint(Graphics g2) {
        g2.drawImage(bgImg, 0, 0, null);
        for (int i = 0; i < button.length; i++) {
            button[i].draw(g2);
        }
    }

    public Button getBackBtn() {
        return button[0];
    }

    public Button getMenuBtn() {
        return button[1];

    }
}
