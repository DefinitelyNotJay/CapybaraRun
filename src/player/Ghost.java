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
    private BufferedImage skillAniRun[], normalAnirun[];
    private BufferedImage skillAniSlide, normalAniSlide;
    public Ghost(int HP, double x, double y, int xSize, int ySize) {
        super(HP, x, y, xSize, ySize);
        loadImages();
    }
    
    @Override
    public void loadImages() {
        normalAnirun = Utilz.getRunningImg("/res/player/ghost/capyrun.png");
        normalAniSlide = Utilz.GetImage("/res/player/ghost/capyslide.png");
        skillAniRun = Utilz.getRunningImg("/res/player/ghost/capyskill.png");
        // skillAniSlide = Utilz.GetImage("/res/player/ghost/capyrun.png");
        runningAni = normalAnirun;
        slideAni = normalAniSlide;

    }

    @Override
    public void skill() {
        WALLDAMAGE = 0;
        skillOnUse = true;
        runningAni = skillAniRun;
        GAMESPEED += 10;
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
        skillActivate();
        super.updateEverySec();
        if(skillDurationCount+1 == skillDuration){
            GAMESPEED -= 10;
        }
        if(skillDurationCount == skillDuration){
            System.out.println("No Skill!");
            skillReset();
        }
        if(skillOnUse)
        skillDurationCount++;
    }

    
    @Override
    public void skillReset(){
        runningAni = normalAnirun;

        WALLDAMAGE = 10;
        // reset animation
        skillDurationCount = 0;
        timeCount = 0;
        skillOnUse = false;
    }
}
