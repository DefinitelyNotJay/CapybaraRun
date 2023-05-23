package screen;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import main.GamePanel;
import methods.ScreenTools;
import methods.Utilz;

public class Pause implements ScreenTools {
    GamePanel gp;
    Button button[];
    BufferedImage bgImg;
    int BACK = 0, RESUME = 1, RESTART = 2;

    public Pause(GamePanel gp) {
        this.gp = gp;
        buttonCreate();
        loadImages();
    }

    @Override
    public void loadImages() {
        bgImg = Utilz.GetImage("/res/screen/pause/bgImg.png");
        button[RESUME].setImages("/res/screen/pause/back");
        button[BACK].setImages("/res/screen/pause/resume");
        button[RESTART].setImages("/res/screen/pause/restart");
    }

    @Override
    public void buttonCreate() {
        button = new Button[3];
        button[BACK] = new Button(570, 170, 125, 54);
        button[RESUME] = new Button(570, 230, 125, 54);
        button[RESTART] = new Button(570, 290, 125, 54);
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(bgImg, 0, 0, null);
        for (int i = 0; i < button.length; i++) {
            button[i].draw(g);
        }
    }

    public boolean isInButton(int x, int y, int num) {
        return x >= button[num].getX() && x <= button[num].getX() + button[num].getWidth()
                && y >= button[num].getY() && y <= button[num].getY() + button[num].getHeight();
    }

    public Button[] getButton() {
        return button;
    }

    public void setButton(Button[] button) {
        this.button = button;
    }
}
