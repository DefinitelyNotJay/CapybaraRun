package screen;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import main.GamePanel;
import methods.ScreenTools;
import methods.Utilz;

public class Credits implements ScreenTools {
    GamePanel gp;
    Button button[];
    BufferedImage bgImg;

    public Credits(GamePanel gp) {
        this.gp = gp;
        buttonCreate();
        loadImages();
    }

    @Override
    public void loadImages() {
        button[0].setImages("/res/screen/credits/back");
        bgImg = Utilz.GetImage("/res/screen/credits/1.png");
    }

    public boolean isInButton(int x, int y, int num) {
        return x >= button[num].getX() && x <= button[num].getX() + button[num].getWidth()
                && y >= button[num].getY() && y <= button[num].getY() + button[num].getHeight();
    }

    @Override
    public void buttonCreate() {
        button = new Button[1];
        button[0] = new Button(555, 380, 125, 50);
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(bgImg, 0, 0, null);
        button[0].draw(g);
    }

    public Button getBackBtn() {
        return button[0];
    }

}
