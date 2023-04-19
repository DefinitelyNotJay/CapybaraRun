
package entity;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import main.GamePanel;

public class WallPattern {
    private GamePanel gp;
    private WallGround w1, w2, w3;

    private WallHanging wg1;
    private ArrayList<Wall> wallPattern;
    
    public WallPattern(GamePanel gp){
        this.gp = gp;
        wallPattern = new ArrayList<Wall>();
        loadWalls();
    }
    
    public void loadWalls(){
        Set<Object> WallSet = new HashSet<Object>();
        Set<Object> collect = new HashSet<Object>();
        w1 = new WallGround(gp,330, 250, gp.tileSize, gp.tileSize);
        w2 = new WallGround(gp,550, 250, gp.tileSize, gp.tileSize);
        w3 = new WallGround(gp,820, 250, gp.tileSize, gp.tileSize);
        wg1 = new WallHanging(gp,1120, 180, gp.tileSize, gp.tileSize+20);
        collect.add(w1);
        collect.add(w2);
        collect.add(w3);
        collect.add(wg1);
        WallSet.addAll(collect);//kuysus

        Collections.addAll(wallPattern);
    }
    

    public ArrayList<Wall> getWallPattern() {
        return wallPattern;
    }

    public void setWallPattern(ArrayList<Wall> wallPattern) {
        this.wallPattern = wallPattern;
    }
}
