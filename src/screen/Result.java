package screen;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import main.GamePanel;
import methods.ScreenTools;
import methods.Utilz;

public class Result extends JPanel implements ScreenTools {

    BufferedImage bgImg, scoreFrame;
    GamePanel gp;
    Button button[];
    final int BACK = 0, RESTART = 1;

    public Result() {
        buttonCreate();
        loadImages();
    }

    public void loadImages() {
        bgImg = Utilz.GetImage("/res/screen/result/totalbg.png");

        scoreFrame = Utilz.GetImage("/res/screen/result/score frame.png");

        button[BACK].setImages("/res/screen/result/back");

        button[RESTART].setImages("/res/screen/result/restart");
    }

    public void paint(Graphics g2) {
        g2.drawImage(bgImg, 0, 0, null);
        g2.drawImage(scoreFrame, 260, 25, null);
        for (int i = 0; i < button.length; i++) {
            button[i].draw(g2);
        }
    }

    @Override
    public void buttonCreate() {
        button = new Button[2];

        button[BACK] = new Button(365, 290, 125, 50);

        button[RESTART] = new Button(787, 290, 125, 50);
    }

    public Button[] getButton() {
        return button;
    }

    public void setButton(Button[] button) {
        this.button = button;
    }
    
    public Button getBackBtn(){
        return button[BACK];
    }
    
    public Button getRestartBtn(){
        return button[RESTART];
    }

}
