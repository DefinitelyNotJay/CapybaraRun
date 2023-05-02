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
    private int start = 440;
    private List<Integer> arr;
    // private HashSet<WallPattern> wall_Set;

    public WallPattern(GamePanel gp) {
        this.gp = gp;

        wallPattern1 = new ArrayList<Wall>();
        randomWallSequence(21);
        loadWalls();
        System.out.println(gp.tileSize);
    }

    public void randomWallSequence(int max) {
        wallPattern = new ArrayList<Wall>();
        Set<Integer> num = new HashSet<>();
        while (num.size() != max) {
            num.add((int) Math.floor(Math.random() * (max - 1 + 1) + 1));
        }
        arr = new ArrayList<>(num);
        Collections.shuffle(arr);
        for (int i = 0; i < arr.size(); i++) {
            arr.set(i, arr.get(i) * gp.screenWidth);
        }
        System.out.println(arr);

    }

    public void loadWalls() {
        // ArrayList<Object> aList = new ArrayList<Object>();
        // wo1 = new WallGround(gp,300, 350, gp.tileSize, gp.tileSize);
        wo2 = new WallGround(gp, 440, 250, gp.tileSize, gp.tileSize);
        wo3 = new WallGround(gp, 850, 250, gp.tileSize, gp.tileSize);
        wog1 = new WallHanging(gp, 1250, 170, gp.tileSize, gp.tileSize + 20);

        wt1 = new WallGround(gp, 1100, 250, gp.tileSize, gp.tileSize);
        wt2 = new WallHanging(gp, 1350, 170, gp.tileSize, gp.tileSize + 20);

        // wt3 = new WallGround(gp, 2035, 350, gp.tileSize, gp.tileSize);
        // wtg1 = new WallHanging(gp, 1300, 120, gp.tileSize, gp.tileSize+20);
        //
        // create wallPattern 1
        Collections.addAll(wallPattern1,
                new WallGround(gp, 2270, 360, gp.tileSize, gp.tileSize),
                new WallGround(gp, 330, 250, gp.tileSize, gp.tileSize),
                new WallHanging(gp, 350, 250, gp.tileSize, gp.tileSize),
                new WallHanging(gp, 1400, 90, gp.tileSize, gp.tileSize + 20));
        Collections.addAll(wallPattern,
                // 0
                new WallGround(gp, start + arr.get(0)+ 150, 342, gp.tileSize, gp.tileSize),
                new WallGround(gp, start + arr.get(0)+ 150 + 250, 342, gp.tileSize, gp.tileSize),
                new WallGround(gp, start + arr.get(0)+ 150 + 250 + 250, 342, gp.tileSize,gp.tileSize),
                new WallGround(gp, start + arr.get(0)+ 150 + 250 + 250 + 250, 342, gp.tileSize,gp.tileSize),
                // 1
                new WallGround(gp, start + arr.get(1), 342, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(1) + 250, 280, gp.tileSize, gp.tileSize),
                new WallGround(gp, start + arr.get(1) + 250 + 250, 342, gp.tileSize,gp.tileSize),
                new WallHanging(gp, start + arr.get(1) + 250 + 250 + 250, 280, gp.tileSize,gp.tileSize),
                // 2
                new WallGround(gp, start + arr.get(2), 342, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(2) + 200, 280, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(2) + 200 + 60, 280, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(2) + 200 + 60 + 60, 280, gp.tileSize,gp.tileSize),
                new WallHanging(gp, start + arr.get(2) + 200 + 60 + 60 + 60, 280, gp.tileSize,gp.tileSize),
                new WallHanging(gp, start + arr.get(2) + 200 + 60 + 60 + 60 + 60, 280, gp.tileSize,gp.tileSize),
                new WallHanging(gp, start + arr.get(2) + 200 + 60 + 60 + 60 + 60 + 60, 280, gp.tileSize,gp.tileSize),
                new WallHanging(gp, start + arr.get(2) + 200 + 60 + 60 + 60 + 60 + 60 + 60, 280,gp.tileSize,gp.tileSize),
                new WallHanging(gp, start + arr.get(2) + 200 + 60 + 60 + 60 + 60 + 60 + 60 + 60, 280,gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(2) + 200 + 60 + 60 + 60 + 60 + 60 + 60 + 60 + 60, 280,gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(2) + 200 + 60 + 60 + 60 + 60 + 60 + 60 + 60 + 60 + 60,280,gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(2) + 200 + 60 + 60 + 60 + 60 + 60 + 60 + 60 + 60 + 60+ 60, 280,gp.tileSize, gp.tileSize),
                // 3
                new WallHanging(gp, start + arr.get(3), 280, gp.tileSize, gp.tileSize),
                new WallGround(gp, start + arr.get(3) + 220, 342, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(3) + 200 + 200, 280, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(3) + 200 + 200 + 150, 280, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(3) + 200 + 200 + 150 + 100, 280, gp.tileSize,gp.tileSize),
                new WallGround(gp, start + arr.get(3) + 200 + 200 + 150 + 100 + 200, 342, gp.tileSize,gp.tileSize),
                // 4
                new WallHanging(gp, start + arr.get(4) , 280, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(4) + 100, 280, gp.tileSize, gp.tileSize),
                new WallGround(gp, start + arr.get(4) + 100 + 200, 342, gp.tileSize, gp.tileSize),
                new WallGround(gp, start + arr.get(4) + 100 + 200 + 250, 342, gp.tileSize,gp.tileSize),
                new WallHanging(gp, start + arr.get(4) + 100 + 200 + 250 + 250, 280, gp.tileSize,gp.tileSize),
                // 5
                new WallGround(gp, start + arr.get(5), 342, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(5) + 200, 280, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(5) + 200 + 200, 240, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(5) + 200 + 200 + 200, 280, gp.tileSize,gp.tileSize),
                new WallHanging(gp, start + arr.get(5) + 200 + 200 + 200 + 150, 240, gp.tileSize,gp.tileSize),
                // 6
                new WallHanging(gp, start + arr.get(6), 80, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(6) + 64, 100, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(6) + 64 + 64, 120, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(6) + 64 + 64 + 64, 140, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(6) + 64 + 64 + 64 + 64, 160, gp.tileSize,gp.tileSize),
                new WallHanging(gp, start + arr.get(6) + 64 + 64 + 64 + 64 + 64, 180, gp.tileSize,gp.tileSize),
                new WallHanging(gp, start + arr.get(6) + 64 + 64 + 64 + 64 + 64 + 64, 200, gp.tileSize,gp.tileSize),
                new WallHanging(gp, start + arr.get(6) + 64 + 64 + 64 + 64 + 64 + 64 + 64, 220,gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(6) + 64 + 64 + 64 + 64 + 64 + 64 + 64 + 64, 240,gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(6) + 64 + 64 + 64 + 64 + 64 + 64 + 64 + 64 + 64, 260,gp.tileSize,gp.tileSize),
                new WallHanging(gp, start + arr.get(6) + 64 + 64 + 64 + 64 + 64 + 64 + 64 + 64 + 64 + 64,280, gp.tileSize,gp.tileSize),
                // 7
                new WallGround(gp, start + arr.get(7), 342, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(7) + 200, 260, gp.tileSize, gp.tileSize),
                new WallGround(gp, start + arr.get(7) + 200 + 200, 342, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(7) + 200 + 200 + 200, 260, gp.tileSize, gp.tileSize),
                new WallGround(gp, start + arr.get(7) + 200 + 200 + 200 + 200, 342, gp.tileSize,gp.tileSize),
                new WallHanging(gp, start + arr.get(7) + 200 + 200 + 200 + 200 + 200, 260, gp.tileSize,gp.tileSize),
                // 8
                new WallGround(gp, start + arr.get(8) , 342, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(8) + 165, 200, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(8) + 165 + 75, 200, gp.tileSize, gp.tileSize),
                new WallGround(gp, start + arr.get(8) + 200 + 200, 342, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(8) + 200 + 200 + 165, 200, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(8) + 200 + 200 + 165 + 75, 200, gp.tileSize,gp.tileSize),
                new WallGround(gp, start + arr.get(8) + 200 + 200 + 200 + 200, 342, gp.tileSize,gp.tileSize),
                // 9
                new WallGround(gp, start + arr.get(9), 342, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(9) + 180, 260, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(9) + 170 + 150, 260, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(9) + 170 + 150 + 150, 260, gp.tileSize, gp.tileSize),
                new WallGround(gp, start + arr.get(9) + 180 + 170 + 150 + 170, 342, gp.tileSize,gp.tileSize),
                // 10
                new WallHanging(gp, start + arr.get(10) , 280, gp.tileSize, gp.tileSize),
                new WallGround(gp, start + arr.get(10) + 200, 342, gp.tileSize, gp.tileSize),
                new WallGround(gp, start + arr.get(10) + 200 + 250, 342, gp.tileSize, gp.tileSize),
                new WallGround(gp, start + arr.get(10) + 200 + 250 + 250, 342, gp.tileSize, gp.tileSize),
                // 11
                new WallGround(gp, start + arr.get(11) , 342, gp.tileSize, gp.tileSize),
                new WallGround(gp, start + arr.get(11) + 280, 342, gp.tileSize, gp.tileSize),
                new WallGround(gp, start + arr.get(11) + 280 + 280, 342, gp.tileSize, gp.tileSize),
                new WallGround(gp, start + arr.get(11) + 280 + 280 + 280, 342, gp.tileSize, gp.tileSize),
                // 12
                new WallGround(gp, start + arr.get(12) , 342, gp.tileSize, gp.tileSize),
                new WallGround(gp, start + arr.get(12) + 280, 342, gp.tileSize, gp.tileSize),
                new WallGround(gp, start + arr.get(12) + 280 + 280, 342, gp.tileSize, gp.tileSize),
                new WallGround(gp, start + arr.get(12) + 280 + 280 + 280, 342, gp.tileSize, gp.tileSize),
                // 13
                new WallGround(gp, start + arr.get(13) , 342, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(13) + 280, 280, gp.tileSize, gp.tileSize),
                new WallGround(gp, start + arr.get(13) + 280 + 280, 342, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(13) + 280 + 280 + 280, 280, gp.tileSize, gp.tileSize),
                // 14
                new WallGround(gp, start + arr.get(14) , 342, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(14) + 200, 280, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(14) + 200 + 200, 280, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(14) + 200 + 200 + 200, 280, gp.tileSize, gp.tileSize),
                new WallGround(gp, start + arr.get(14) + 200 + 200 + 200 + 200, 342, gp.tileSize, gp.tileSize),
                // 15
                new WallGround(gp, start + arr.get(15) , 342, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(15) + 250, 240, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(15) + 250 + 200, 280, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(15) + 250 + 200 + 200, 240, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(15) + 250 + 200 + 200 + 200, 280, gp.tileSize, gp.tileSize),
                // 16
                new WallGround(gp, start + arr.get(16) , 342, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(16) + 250, 240, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(16) + 250 + 200, 280, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(16) + 250 + 200 + 200, 240, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(16) + 250 + 200 + 200 + 200, 280, gp.tileSize, gp.tileSize),
                // 17
                new WallGround(gp, start + arr.get(17) , 342, gp.tileSize, gp.tileSize),
                new WallGround(gp, start + arr.get(17) + 300, 342, gp.tileSize, gp.tileSize),
                new WallGround(gp, start + arr.get(17) + 300 + 300, 342, gp.tileSize, gp.tileSize),
                new WallGround(gp, start + arr.get(17) + 300 + 300 + 300, 342, gp.tileSize, gp.tileSize),
                // 18
                new WallGround(gp, start + arr.get(18) , 342, gp.tileSize, gp.tileSize),
                new WallGround(gp, start + arr.get(18) + 300, 342, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(18) + 300 + 250, 280, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(18) + 300 + 250 + 250, 280, gp.tileSize, gp.tileSize),
                // 19
                new WallHanging(gp, start + arr.get(19) , 280, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(19) + 250, 280, gp.tileSize, gp.tileSize),
                new WallGround(gp, start + arr.get(19) + 250 + 300, 342, gp.tileSize, gp.tileSize),
                new WallGround(gp, start + arr.get(19) + 250 + 300 + 300, 342, gp.tileSize, gp.tileSize),
                // 20
                new WallHanging(gp, start + arr.get(20) , 100, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(20) + 64, 100, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(20) + 64 + 64, 100, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(20) + 64 + 64 + 64, 100, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(20) + 64 + 64 + 64 + 64, 100, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(20) + 64 + 64 + 64 + 64 + 64, 100, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(20) + 64 + 64 + 64 + 64 + 64 + 64, 100, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(20) + 64 + 64 + 64 + 64 + 64 + 64 + 52, 100, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(20) + 64 + 64 + 64 + 64 + 64 + 64 + 52, 90, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(20) + 64 + 64 + 64 + 64 + 64 + 64 + 32, 80, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(20) + 64 + 64 + 64 + 64 + 64 + 76, 70, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(20) + 64 + 64 + 64 + 64 + 64 + 56, 60, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(20) + 64 + 64 + 64 + 64 + 64 + 36, 50, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(20) + 64 + 64 + 64 + 64 + 80, 40, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(20) + 64 + 64 + 64 + 64 + 60, 30, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(20) + 64 + 64 + 64 + 64 + 40 , 20, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(20) + 64 + 64 + 64 + 64 + 20 , 10, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(20) + 64 + 64 + 64 + 64 + 20 , 190, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(20) + 64 + 64 + 64 + 64 + 40 , 180, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(20) + 64 + 64 + 64 + 64 + 60 , 170, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(20) + 64 + 64 + 64 + 64 + 80 , 160, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(20) + 64 + 64 + 64 + 64 + 64 + 36 , 150, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(20) + 64 + 64 + 64 + 64 + 64 + 56 , 140, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(20) + 64 + 64 + 64 + 64 + 64 + 76 , 130, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(20) + 64 + 64 + 64 + 64 + 64 + 64 + 32 , 120, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(20) + 64 + 64 + 64 + 64 + 64 + 64 + 52 , 110, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(20) + 64 + 64 + 64 + 64 + 64 + 64 + 52 , 100, gp.tileSize, gp.tileSize)


        );
        // wth1 = new WallGround(gp, 2270, 360, gp.tileSize, gp.tileSize);
        // wth2 = new WallGround(gp, 330, 250, gp.tileSize, gp.tileSize);
        // wthg1 = new WallHanging(gp, 350, 250, gp.tileSize, gp.tileSize);
        // wthg2 = new WallHanging(gp, 1400, 90, gp.tileSize, gp.tileSize+20);

        // Collections.addAll(wallPattern, wo2, wo3, wog1);
        // Collections.addAll(wallPattern,wt1, wt2);
        // wallPattern.addAll(wallPattern);
        wallPattern.addAll(wallPattern);
        // Collections.addAll(wallPattern, wth1, wth2, wthg1, wthg2);
        // Collections.addAll(aList, wallPattern);
        // Set<WallPattern> wall_Set = new HashSet<WallPattern>();
    }

    public ArrayList<Wall> getWallPattern() {
        return wallPattern;
    }

    public void setWallPattern(ArrayList<Wall> wallPattern) {
        this.wallPattern = wallPattern;
    }

    public ArrayList<WallPattern> getWallStage() {
        return wallStage;
    }

    public void setWallStage(ArrayList<WallPattern> wallStage) {
        this.wallStage = wallStage;
    }

    public void paint(Graphics g) {

    }
}
