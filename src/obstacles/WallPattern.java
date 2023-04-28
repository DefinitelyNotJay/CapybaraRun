
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

    private WallHanging wog1, wtg1, wthg1, wt2;
    public ArrayList<Wall> wallPattern, wallPattern1, wallPattern2;
    public ArrayList wallStage;
    private int start=440;
    private List<Integer> arr;
    //private HashSet<WallPattern> wall_Set;
    
    public WallPattern(GamePanel gp){
        this.gp = gp;
        wallPattern = new ArrayList<Wall>();
        wallPattern1 = new ArrayList<Wall>();
        randomWallSequence(7);
        loadWalls();
    }
    
    private void randomWallSequence(int max) {
        Set<Integer> num = new HashSet<>();
        while(num.size() != max){
            num.add((int)Math.floor(Math.random() * (max - 1+1) + 1));
        }
        arr = new ArrayList<>(num);
        Collections.shuffle(arr);
        for(int i=0; i<arr.size(); i++){
            arr.set(i, arr.get(i)*gp.screenWidth);
        }
        System.out.println(arr);

    }

    public void loadWalls(){
        //ArrayList<Object> aList = new ArrayList<Object>();
        //wo1 = new WallGround(gp,300, 350, gp.tileSize, gp.tileSize);
        wo2 = new WallGround(gp,440, 250, gp.tileSize, gp.tileSize);
        wo3 = new WallGround(gp,850, 250, gp.tileSize, gp.tileSize);
        wog1 = new WallHanging(gp,1250,170, gp.tileSize, gp.tileSize+20);

        wt1 = new WallGround(gp, 1100, 250, gp.tileSize, gp.tileSize);
        wt2 = new WallHanging(gp, 1350, 170, gp.tileSize, gp.tileSize+20);
        
        //wt3 = new WallGround(gp, 2035, 350, gp.tileSize, gp.tileSize);
        // wtg1 = new WallHanging(gp, 1300, 120, gp.tileSize, gp.tileSize+20);
//
        // create wallPattern 1
        Collections.addAll(wallPattern1, 
        new WallGround(gp, 2270, 360, gp.tileSize, gp.tileSize),
        new WallGround(gp, 330, 250, gp.tileSize, gp.tileSize),
        new WallHanging(gp, 350, 250, gp.tileSize, gp.tileSize),
        new WallHanging(gp, 1400, 90, gp.tileSize, gp.tileSize+20)
        );
        Collections.addAll(wallPattern,
        //0 
        new WallGround(gp,start+150+arr.get(0), 255, gp.tileSize, gp.tileSize),
        new WallGround(gp,start+150+250+arr.get(0), 255, gp.tileSize, gp.tileSize),
        new WallGround(gp,start+150+250+250+arr.get(0), 255, gp.tileSize, gp.tileSize),
        new WallGround(gp,start+150+250+250+250+arr.get(0), 255, gp.tileSize, gp.tileSize),
        //1
        new WallGround(gp,start+arr.get(1), 255, gp.tileSize, gp.tileSize),
        new WallHanging(gp,start+arr.get(1)+250, 200, gp.tileSize, gp.tileSize),
        new WallGround(gp,start+arr.get(1)+250+250, 255, gp.tileSize, gp.tileSize),
        new WallHanging(gp,start+arr.get(1)+250+250+250, 200, gp.tileSize, gp.tileSize),
        //2
        new WallGround(gp,start+arr.get(2), 255, gp.tileSize, gp.tileSize),
        new WallHanging(gp,start+arr.get(2)+200, 200, gp.tileSize, gp.tileSize),
        new WallHanging(gp,start+arr.get(2)+200+60, 200, gp.tileSize, gp.tileSize),
        new WallHanging(gp,start+arr.get(2)+200+60+60, 200, gp.tileSize, gp.tileSize),
        new WallHanging(gp,start+arr.get(2)+200+60+60+60, 200, gp.tileSize, gp.tileSize),
        new WallHanging(gp,start+arr.get(2)+200+60+60+60+60, 200, gp.tileSize, gp.tileSize),
        new WallHanging(gp,start+arr.get(2)+200+60+60+60+60+60, 200, gp.tileSize, gp.tileSize),
        new WallHanging(gp,start+arr.get(2)+200+60+60+60+60+60+60, 200, gp.tileSize, gp.tileSize),
        new WallHanging(gp,start+arr.get(2)+200+60+60+60+60+60+60+60, 200, gp.tileSize, gp.tileSize),
        new WallHanging(gp,start+arr.get(2)+200+60+60+60+60+60+60+60+60, 200, gp.tileSize, gp.tileSize),
        new WallHanging(gp,start+arr.get(2)+200+60+60+60+60+60+60+60+60+60, 200, gp.tileSize, gp.tileSize),
        new WallHanging(gp,start+arr.get(2)+200+60+60+60+60+60+60+60+60+60+60, 200, gp.tileSize, gp.tileSize),
        //3
        new WallHanging(gp,start+arr.get(3), 200, gp.tileSize, gp.tileSize),
        new WallGround(gp,start+arr.get(3)+200, 255, gp.tileSize, gp.tileSize),
        new WallHanging(gp,start+arr.get(3)+200+200, 200, gp.tileSize, gp.tileSize),
        new WallHanging(gp,start+arr.get(3)+200+200+150, 200, gp.tileSize, gp.tileSize),
        new WallHanging(gp,start+arr.get(3)+200+200+150+100, 200, gp.tileSize, gp.tileSize),
        new WallGround(gp,start+arr.get(3)+200+200+150+100+200, 255, gp.tileSize, gp.tileSize),
        //4
        new WallHanging(gp,start+arr.get(4), 200, gp.tileSize, gp.tileSize),
        new WallHanging(gp,start+arr.get(4)+100, 200, gp.tileSize, gp.tileSize),
        new WallGround(gp,start+arr.get(4)+100+200, 255, gp.tileSize, gp.tileSize),
        new WallGround(gp,start+arr.get(4)+100+200+250, 255, gp.tileSize, gp.tileSize),
        new WallHanging(gp,start+arr.get(4)+100+200+250+200, 200, gp.tileSize, gp.tileSize),
        //5
        new WallGround(gp,start+arr.get(5), 255, gp.tileSize, gp.tileSize),
        new WallHanging(gp,start+arr.get(5)+200, 150, gp.tileSize, gp.tileSize),
        new WallHanging(gp,start+arr.get(5)+200+200, 150, gp.tileSize, gp.tileSize),
        new WallHanging(gp,start+arr.get(5)+200+200+200, 200, gp.tileSize, gp.tileSize),
        new WallHanging(gp,start+arr.get(5)+200+200+200+150, 200, gp.tileSize, gp.tileSize),
        //6
        new WallHanging(gp,start+arr.get(6), 50, gp.tileSize, gp.tileSize),
        new WallHanging(gp,start+arr.get(6)+64, 70, gp.tileSize, gp.tileSize),
        new WallHanging(gp,start+arr.get(6)+64+64, 90, gp.tileSize, gp.tileSize),
        new WallHanging(gp,start+arr.get(6)+64+64+64, 110, gp.tileSize, gp.tileSize),
        new WallHanging(gp,start+arr.get(6)+64+64+64+64, 130, gp.tileSize, gp.tileSize),
        new WallHanging(gp,start+arr.get(6)+64+64+64+64+64, 150, gp.tileSize, gp.tileSize),
        new WallHanging(gp,start+arr.get(6)+64+64+64+64+64+64, 170, gp.tileSize, gp.tileSize),
        new WallHanging(gp,start+arr.get(6)+64+64+64+64+64+64+64, 190, gp.tileSize, gp.tileSize),
        new WallHanging(gp,start+arr.get(6)+64+64+64+64+64+64+64+64, 210, gp.tileSize, gp.tileSize)
        

        
//         new WallGround(gp,start+arr.get(0), 250, gp.tileSize, gp.tileSize),
//         new WallGround(gp,(start+410)+arr.get(0), 250, gp.tileSize, gp.tileSize),
//         new WallGround(gp, (start+660)+arr.get(0), 250, gp.tileSize, gp.tileSize),
// //      (gp, x, y, width, height)
//         new WallGround(gp,start+arr.get(1), 250, gp.tileSize, gp.tileSize),
//         new WallGround(gp,(start+410)+arr.get(1), 250, gp.tileSize, gp.tileSize),
//         new WallGround(gp, (start+660)+arr.get(1), 250, gp.tileSize, gp.tileSize)


        );
        //wth1 = new WallGround(gp, 2270, 360, gp.tileSize, gp.tileSize);
        // wth2 = new WallGround(gp, 330, 250, gp.tileSize, gp.tileSize);
        // wthg1 = new WallHanging(gp, 350, 250, gp.tileSize, gp.tileSize);
        //wthg2 = new WallHanging(gp, 1400, 90, gp.tileSize, gp.tileSize+20);

        // Collections.addAll(wallPattern, wo2, wo3, wog1);
        // Collections.addAll(wallPattern,wt1, wt2);
        // wallPattern.addAll(wallPattern);
        wallPattern.addAll(wallPattern);
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

    public ArrayList<WallPattern> getWallStage(){
        return wallStage;
    }

    public void setWallStage(ArrayList<WallPattern> wallStage){
        this.wallStage = wallStage;
    }
    public void paint(Graphics g){
        
    }
}
