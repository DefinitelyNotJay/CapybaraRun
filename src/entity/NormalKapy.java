package entity;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;
import methods.Utilz;

public class NormalKapy extends Player {
    private int aniTick, aniIndex, aniSpeed=10;
    public NormalKapy(int HP, double x, double y, int xSize, int ySize) {
        super(HP, x, y, xSize, ySize);
        loadImages();
    }
    
    @Override
    public void loadImages() {
        // BufferedImage img = Utilz.GetImage("/res/capyrun.png");
        // runningAni = new BufferedImage[3][3];
        // for (int i = 0; i < 3; i++) {
        //     for (int j = 0; j < 3; j++) {
        //         runningAni[i][j] = img.getSubimage(32*i, 34*j, 32, 32);
        //     }
        // }
        runningAni = Utilz.getRunningImg("/res/capyrun2.png");
    }
    @Override
    public void updateAnimations(){
        aniTick++;
        if(aniTick>=aniSpeed){
            aniTick = 0;
            aniIndex++;
        }
        // maximum
        if(aniIndex>=7){
            aniIndex = 0;
        }
    }
    public void draw(Graphics g2){
        g2.drawImage(runningAni[aniIndex], (int)x, (int)y, Utilz.gp.tileSize, Utilz.gp.tileSize, null);
//        System.out.println(Utilz.tileSize);
//        g2.fillRect((int)x, (int)y, width, height);
    }



}
