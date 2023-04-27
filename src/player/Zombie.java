
package player;

import entity.Player;
import main.GamePanel;
import methods.SpecialAbility;
import methods.Utilz;
import static constant.Constants.*;

import java.util.concurrent.TimeUnit;

public class Zombie extends Player{
    private int lives = 5;
    public Zombie(GamePanel gp, int HP, double x, double y, int xSize, int ySize){
        super(gp, HP, x, y, xSize, ySize);
        loadImages();
    }
    @Override
    public void loadImages() {
        runningAni = Utilz.getRunningImg("/res/player/zombie/runCapy.png");
        slideAni = Utilz.GetImage("/res/player/zombie/slideCapy.png");
    }
    @Override
    public void healthCheck(){
        if(HP <= 0 && lives == 0){
            GamePanel.GameState = GAMESTATE_DEATH;
            lives = 5;
        }
        else if(HP <= 0 && lives >= 1){
            HP = 10;
            rateDecreaseHP = 1;
            lives--;
        }
    }

    @Override
    public void skill() {
        
    }

    @Override
    public void skillActivate() {

    }

    
    @Override
    public void skillReset(){
        
    }
    
}
