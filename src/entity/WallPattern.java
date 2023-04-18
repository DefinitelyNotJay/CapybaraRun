
package entity;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import main.GamePanel;

public class WallPattern {
    private GamePanel gp;
    private WallGround w1, w2, w3, w4;

    private WallHanging wg1, wg2;
    private ArrayList<Wall> wallPattern;
    
    public WallPattern(GamePanel gp){
        this.gp = gp;
        wallPattern = new ArrayList<Wall>();
        loadWalls();
    }
    
    public void loadWalls(){
        w1 = new WallGround(gp,330, 250, gp.tileSize, gp.tileSize);
        w2 = new WallGround(gp,550, 250, gp.tileSize, gp.tileSize);
        w3 = new WallGround(gp,820, 250, gp.tileSize, gp.tileSize);
        // wg1 = new WallHanging(gp,1120, 90, gp.tileSize*2, gp.tileSize*2+60);
        wg2 = new WallHanging(gp,1120, 90, gp.tileSize*8, gp.tileSize*2+60);
        
        Collections.addAll(wallPattern, w1, w2, w3, wg2);
    }
    

    public ArrayList<Wall> getWallPattern() {
        return wallPattern;
    }

    public void setWallPattern(ArrayList<Wall> wallPattern) {
        this.wallPattern = wallPattern;
    }
}
