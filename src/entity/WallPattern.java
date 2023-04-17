
package entity;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import main.GamePanel;

public class WallPattern {
    private GamePanel gp;
    private WallGround w1, w2, w3, w4;
    private WallHanging wg1;
    private ArrayList<Wall> wallPattern;
    
    public WallPattern(GamePanel gp){
        this.gp = gp;
        wallPattern = new ArrayList<Wall>();
        loadWalls();
    }
    
    public void loadWalls(){
        w1 = new WallGround(gp,320+100, 250, gp.tileSize, gp.tileSize);
        w2 = new WallGround(gp,450+100, 250, gp.tileSize, gp.tileSize);
        w3 = new WallGround(gp,820, 250, gp.tileSize, gp.tileSize);
        wg1 = new WallHanging(gp,620+500, 90, gp.tileSize*2, gp.tileSize*2+60);
        Collections.addAll(wallPattern, w1, w2, w3, wg1);
    }
    

    public ArrayList<Wall> getWallPattern() {
        return wallPattern;
    }

    public void setWallPattern(ArrayList<Wall> wallPattern) {
        this.wallPattern = wallPattern;
    }
        
    
}
