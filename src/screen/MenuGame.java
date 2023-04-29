package screen;


import java.awt.*;
import javax.swing.*;

import methods.Utilz;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;



public class MenuGame extends JPanel {
    // private JLabel empty1, empty2, empty3;
    private BufferedImage bgImg, playButton, creditsButton, quitButton;
    // private Font Font1;
//    private btnpanel btn1;
    public int titleScreenState = 0; //0 = the first screen

    public MenuGame() {
        this.setLayout(new GridLayout(4, 1));
        this.setPreferredSize(new Dimension(1280, 512));
        bgImg = Utilz.GetImage("/res/screen/menu/final_menu.png");
        playButton = Utilz.GetImage("/res/screen/menu/btn_play.png");
        creditsButton = Utilz.GetImage("/res/screen/menu/btn_credits.png");
        quitButton = Utilz.GetImage("/res/screen/menu/btn_quit.png");
        BufferedImage img = Utilz.GetImage("/res/screen/menu/empty.png");
        getWidthImage();
        

    }
    public void getWidthImage(){

        
    }
    public void paint(Graphics g2) {
            
            g2.drawImage(bgImg, 0, 0, null); // image full size
             g2.drawImage(creditsButton, 285, 263, 230, 72, null);
             g2.drawImage(playButton, 520, 263, 230, 72, null);
             g2.drawImage(quitButton, 754, 263, 230, 72, null);
    }
}
