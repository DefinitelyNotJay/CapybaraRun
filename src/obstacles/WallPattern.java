
package obstacles;

import java.awt.Graphics;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.*;

import main.GamePanel;

public class WallPattern {
    private GamePanel gp;
    private WallGround wo1, wo2, wo3, wo4, wt1, wt3, wth1, wth2;

    private WallHanging wog1, wog2, wthg1, wt2;
    private ArrayList<Wall> wallPattern;
    //private HashSet<WallPattern> wall_Set;
    
    public WallPattern(GamePanel gp){
        this.gp = gp;
        wallPattern = new ArrayList<Wall>();
        loadWalls();
    }
    
    public void loadWalls(){
        //set1
        wo1 = new WallGround(gp,440, 250, gp.tileSize, gp.tileSize);
        wo2 = new WallGround(gp,850, 250, gp.tileSize, gp.tileSize);
        wog1 = new WallHanging(gp,1750,170, gp.tileSize, gp.tileSize+20);
        wo3 = new WallGround(gp, 1100, 250, gp.tileSize, gp.tileSize);
        wog2 = new WallHanging(gp, 1350, 170, gp.tileSize, gp.tileSize+20);
        
        //set2


        Collections.addAll(wallPattern, wo2, wo3, wog1, wo3, wog2);
    }
    

    public ArrayList<Wall> getWallPattern() {
        return wallPattern;
    }

    public void setWallPattern(ArrayList<Wall> wallPattern) {
        this.wallPattern = wallPattern;
    }
    public void paint(Graphics g){
        
    }
}
