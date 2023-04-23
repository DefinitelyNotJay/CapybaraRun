
package player;

import entity.Player;
import methods.SpecialAbility;
import methods.Utilz;

public class Ninja extends Player implements SpecialAbility{
    
    public Ninja(int HP, double x, double y, int xSize, int ySize){
        super(HP, x, y, xSize, ySize);
        loadImages();
    }
    
    @Override
    public void loadImages(){
        runningAni = Utilz.getRunningImg("/res/player/ninja/capyrun.png");
        slideAni = Utilz.GetImage("/res/player/ninja/capyslide.png");
    }
    @Override
    public void skill() {
        
    }

    @Override
    public void skillActivate() {
        
    }
    
}
