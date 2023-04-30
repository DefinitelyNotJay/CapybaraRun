package screen;
import java.awt.*;
import javax.swing.*;
import methods.Utilz;
import java.awt.image.BufferedImage;



public class MenuGame extends JPanel {

    private BufferedImage bgImg, playButton, creditsButton, quitButton;

    public MenuGame() {
        loadImages();
    }

    private void loadImages() {
        bgImg = Utilz.GetImage("/res/screen/menu/final_menu.png");
        playButton = Utilz.GetImage("/res/screen/menu/btn_play.png");
        creditsButton = Utilz.GetImage("/res/screen/menu/btn_credits.png");
        quitButton = Utilz.GetImage("/res/screen/menu/btn_quit.png");
    }

    public void paint(Graphics g2) {
            g2.drawImage(bgImg, 0, 0, null); // image full size
             g2.drawImage(creditsButton, 285, 263, 230, 72, null);
             g2.drawImage(playButton, 520, 263, 230, 72, null);
             g2.drawImage(quitButton, 754, 263, 230, 72, null);
    }
}
