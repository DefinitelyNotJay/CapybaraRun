package player;

import entity.Player;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;
import methods.SpecialAbility;
import methods.Utilz;
import static constant.Constants.*;

public class Ghost extends Player{
    private int skillCooldown = 10;
    public Ghost(int HP, double x, double y, int xSize, int ySize) {
        super(HP, x, y, xSize, ySize);
        loadImages();
    }
    
    @Override
    public void loadImages() {
        runningAni = Utilz.getRunningImg("/res/player/ghost/capyrun.png");
        slideAni = Utilz.GetImage("/res/player/ghost/capyslide.png");
    }

    @Override
    public void skill() {
        WALLDAMAGE = 0;
    }

    @Override
    public void skillActivate() {
        if(timeCount >= skillCooldown){
            skill();
        }
    }

    
    @Override
    public void skillReset(){
        
    }
}
