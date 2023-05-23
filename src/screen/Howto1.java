package screen;

import java.awt.*;
import javax.swing.*;
import methods.ScreenTools;
import methods.Utilz;
import java.awt.image.BufferedImage;

public class Howto1 implements ScreenTools {

    public Button[] button;
    private BufferedImage bgImg;

    public Howto1() {
        buttonCreate();
        loadImages();
    }

    public void buttonCreate() {
        button = new Button[2];
        button[0] = new Button(50, 450, 125, 54);
        button[1] = new Button(1110, 450, 125, 54);

    }

    @Override
    public void loadImages() {

        bgImg = Utilz.GetImage("/res/screen/menu/Menu.png");

        button[0].setImages("/res/screen/howto/back");

        button[1].setImages("/res/screen/howto/Next");

        bgImg = Utilz.GetImage("/res/screen/howto/bgImg1.png");

    }

    public void paint(Graphics g2) {
        g2.drawImage(bgImg, 0, 0, null);
        for (int i = 0; i < button.length; i++) {
            button[i].draw(g2);
        }
    }

    public boolean isInButton(int x, int y, int num) {
        return x >= button[num].getX() && x <= button[num].getX() + button[num].getWidth()
                && y >= button[num].getY() && y <= button[num].getY() + button[num].getHeight();
    }

    public Button getBackBtn() {
        return button[0];
    }

    public Button getNextBtn() {
        return button[1];

    }
}
