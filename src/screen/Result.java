package screen;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import main.GamePanel;
import methods.ScreenTools;
import methods.Utilz;

public class Result extends JPanel implements ScreenTools {

    BufferedImage bgImg;
    GamePanel gp;
    Button button[];

    public Result(GamePanel gp) {
        this.gp = gp;
        loadImages();
    }

    public void loadImages() {
        bgImg = Utilz.GetImage("/res/screen/result/final_bg_score.png");
    }

    public void paint(Graphics g2) {
        g2.drawImage(bgImg, 0, 0, null);
    }

    @Override
    public void buttonCreate() {
        button = new Button[2];
    }

}
