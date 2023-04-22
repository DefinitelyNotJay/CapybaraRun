
package player;

import entity.Player;
import methods.SpecialAbility;
import methods.Utilz;

public class Zombie extends Player implements SpecialAbility{
    public Zombie(int HP, double x, double y, int xSize, int ySize){
        super(HP, x, y, xSize, ySize);
        loadImages();
    }
    @Override
    public void loadImages() {
        runningAni = Utilz.getRunningImg("/res/player/zombie/runCapy.png");
        slideAni = Utilz.GetImage("/res/player/zombie/slideCapy.png");
    }

    @Override
    public void skill() {

    }

    @Override
    public void skillActivate() {

    }
    
}
