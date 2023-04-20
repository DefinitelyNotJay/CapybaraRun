
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
    private WallGround wo1, wo2, wo3, wo4, wt1, wt2, wt3, wth1, wth2;

    private WallHanging wog1, wtg1, wthg1, wthg2;
    private ArrayList<Wall> wallPattern;
    //private HashSet<WallPattern> wall_Set;
    
    public WallPattern(GamePanel gp){
        this.gp = gp;
        wallPattern = new ArrayList<Wall>();
        loadWalls();
    }
    
    public void loadWalls(){
        //ArrayList<Object> aList = new ArrayList<Object>();
        wo1 = new WallGround(gp,330, 250, gp.tileSize, gp.tileSize);
        wo2 = new WallGround(gp,650, 250, gp.tileSize, gp.tileSize);
        wo3 = new WallGround(gp,820, 250, gp.tileSize, gp.tileSize);
        wog1 = new WallHanging(gp,1120, 120, gp.tileSize, gp.tileSize+20);

        //wt1 = new WallGround(gp, 200, 260, gp.tileSize, gp.tileSize);
        //wt2 = new WallGround(gp, 300, 250, gp.tileSize, gp.tileSize);
        //wt3 = new WallGround(gp, 335, 250, gp.tileSize, gp.tileSize);
        //wtg1 = new WallHanging(gp, 1000, 90, gp.tileSize, gp.tileSize+20);
//
        //wth1 = new WallGround(gp, 270, 260, gp.tileSize, gp.tileSize);
        //wth2 = new WallGround(gp, 330, 250, gp.tileSize, gp.tileSize);
        //wthg1 = new WallHanging(gp, 350, 250, gp.tileSize, gp.tileSize);
        //wthg2 = new WallHanging(gp, 1400, 90, gp.tileSize, gp.tileSize+20);

        Collections.addAll(wallPattern, wo1, wo2, wo3, wog1);
        //Collections.addAll(wallPattern, wt1, wt2, wt3, wtg1);
        //Collections.addAll(wallPattern, wth1, wth2, wthg1, wthg2);
        //Collections.addAll(aList, wallPattern);
        //Set<WallPattern> wall_Set = new HashSet<WallPattern>();
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
