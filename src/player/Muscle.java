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

public class Muscle extends Player{
    private int skillCooldown = 5;
    private int skillDuration = 3;
    private int skillDurationCount = 0;
    public Muscle(int HP, double x, double y, int xSize, int ySize) {
        super(HP, x, y, xSize, ySize);
        loadImages();
    }
    
    @Override
    public void loadImages() {
        runningAni = Utilz.getRunningImg("/res/player/muscle/capyrun.png");
        slideAni = Utilz.GetImage("/res/player/muscle/capyslide.png");
    }

    @Override
    public void skill() {
        skillOnUse = true;
        WALLDAMAGE = 0;
        if(isCrash){
            HP += 99999999;

        }
    }

    @Override
    public void skillActivate() {
        if(timeCount == skillCooldown){
            System.out.println("Skill Activate");
            skill();
        }
    }
    
    @Override
    public void skillReset(){
        System.out.println("No Skill!");
        skillOnUse = false;
        WALLDAMAGE = 10;
        timeCount = 0;
        skillDurationCount = 0;
    }

    @Override
    public void updateEverySec(){
        super.updateEverySec();
        skillActivate();
        if(skillOnUse){
            skillDurationCount++;
        }
        if(skillDurationCount == skillDuration){
            skillReset();
        }

    }
}
