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
    private int skillDuration = 5;
    private int skillDurationCount = 0;
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
        skillOnUse = true;
    }

    @Override
    public void skillActivate() {
        if(timeCount == skillCooldown){
            System.out.println("Skill Activated");
            skill();
        }
    }

    @Override
    public void updateEverySec(){
        super.updateEverySec();
        if(skillDurationCount == skillDuration){
            System.out.println("No Skill!");
            skillReset();
        }
        if(skillOnUse)
        skillDurationCount++;
    }

    
    @Override
    public void skillReset(){
        WALLDAMAGE = 10;
        // reset animation
        skillDurationCount = 0;
        timeCount = 0;
        skillOnUse = false;
    }
}
