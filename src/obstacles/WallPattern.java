package obstacles;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.*;

import main.GamePanel;

public class WallPattern {
    private GamePanel gp;

    public ArrayList<Wall> wallPattern;
    private int start = 440;
    private List<Integer> arr;
    // private HashSet<WallPattern> wall_Set;

    public WallPattern(GamePanel gp) {
        this.gp = gp;

        randomWallSequence(31);
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
        Collections.addAll(wallPattern,
                // 0
                new WallGround(gp, start + arr.get(0)+ 200, 342, gp.tileSize, gp.tileSize),
                new WallGround(gp, start + arr.get(0)+ 200 + 250, 342, gp.tileSize, gp.tileSize),
                new WallGround(gp, start + arr.get(0)+ 200 + 250 + 250, 342, gp.tileSize,gp.tileSize),
                new WallGround(gp, start + arr.get(0)+ 200 + 250 + 250 + 250, 342, gp.tileSize,gp.tileSize),
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
                new WallHanging(gp, start + arr.get(7) + 220, 260, gp.tileSize, gp.tileSize),
                new WallGround(gp, start + arr.get(7) + 220 + 220, 342, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(7) + 220 + 220 + 220, 280, gp.tileSize, gp.tileSize),
                new WallGround(gp, start + arr.get(7) + 220 + 220 + 220 + 220, 342, gp.tileSize,gp.tileSize),
                new WallHanging(gp, start + arr.get(7) + 220 + 220 + 220 + 220 + 220, 280, gp.tileSize,gp.tileSize),
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
                new WallHanging(gp, start + arr.get(20) + 64 + 64 + 64 + 64 + 64 + 64 + 52 , 100, gp.tileSize, gp.tileSize),
                //21
                new WallHanging(gp, start + arr.get(21), 100, gp.tileSize, gp.tileSize),
                new WallGround(gp, start + arr.get(21), 342, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(21) + 250, 100, gp.tileSize, gp.tileSize),
                new WallGround(gp, start + arr.get(21) + 250, 342, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(21) + 250 + 250, 100, gp.tileSize, gp.tileSize),
                new WallGround(gp, start + arr.get(21) + 250 + 250, 342, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(21) + 250 + 250 + 250, 100, gp.tileSize, gp.tileSize),
                new WallGround(gp, start + arr.get(21) + 250 + 250 + 250, 342, gp.tileSize, gp.tileSize),
                // 22
                new WallHanging(gp, start + arr.get(22), 50, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(22) + 300, 50, gp.tileSize, gp.tileSize),
                // 23
                new WallGround(gp, start + arr.get(23), 342, gp.tileSize, gp.tileSize),
                new WallGround(gp, start + arr.get(23) + 400, 342, gp.tileSize, gp.tileSize),
                // 24
                new WallHanging(gp, start + arr.get(24) + 500, 280, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(24) + 200, 280, gp.tileSize, gp.tileSize),
                // 25
                new WallHanging(gp, start + arr.get(25), 100, gp.tileSize, gp.tileSize),
                new WallGround(gp, start + arr.get(25), 342, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(25) + 250, 100, gp.tileSize, gp.tileSize),
                new WallGround(gp, start + arr.get(25) + 250, 342, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(25) + 250 + 250, 100, gp.tileSize, gp.tileSize),
                new WallGround(gp, start + arr.get(25) + 250 + 250, 342, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(25) + 250 + 250 + 250, 100, gp.tileSize, gp.tileSize),
                new WallGround(gp, start + arr.get(25) + 250 + 250 + 250, 342, gp.tileSize, gp.tileSize),
                // 26
                new WallGround(gp, start + arr.get(26), 342, gp.tileSize, gp.tileSize),
                new WallGround(gp, start + arr.get(26) + 250, 342, gp.tileSize, gp.tileSize),
                new WallGround(gp, start + arr.get(26) + 250 + 250, 342, gp.tileSize, gp.tileSize),
                new WallGround(gp, start + arr.get(26) + 250 + 250 + 250, 342, gp.tileSize, gp.tileSize),
                // 27
                new WallGround(gp, start + arr.get(27), 342, gp.tileSize, gp.tileSize),
                new WallGround(gp, start + arr.get(27) + 250, 342, gp.tileSize, gp.tileSize),
                new WallGround(gp, start + arr.get(27) + 250 + 250, 342, gp.tileSize, gp.tileSize),
                new WallGround(gp, start + arr.get(27) + 250 + 250 + 250, 342, gp.tileSize, gp.tileSize),
                // 28
                new WallHanging(gp, start + arr.get(28), 280, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(28) + 200, 280, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(28) + 200 + 200, 280, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(28) + 200 + 200 + 200, 280, gp.tileSize, gp.tileSize),
                // 29
                new WallHanging(gp, start + arr.get(29) , 280, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(29) + 250, 280, gp.tileSize, gp.tileSize),
                new WallGround(gp, start + arr.get(29) + 250 + 300, 342, gp.tileSize, gp.tileSize),
                new WallGround(gp, start + arr.get(29) + 250 + 300 + 300, 342, gp.tileSize, gp.tileSize),
                // 30
                new WallGround(gp, start + arr.get(30), 342, gp.tileSize, gp.tileSize),
                new WallGround(gp, start + arr.get(30) + 400, 342, gp.tileSize, gp.tileSize),
                //35
                new WallGround(gp, start + arr.get(35), 342, gp.tileSize, gp.tileSize),
                new WallGround(gp, start + arr.get(35) + 400, 342, gp.tileSize, gp.tileSize),
                //36
                new WallHanging(gp, start + arr.get(36) , 100, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(36) + 64, 100, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(36) + 64 + 64, 100, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(36) + 64 + 64 + 64, 100, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(36) + 64 + 64 + 64 + 64, 100, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(36) + 64 + 64 + 64 + 64 + 64, 100, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(36) + 64 + 64 + 64 + 64 + 64 + 64, 100, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(36) + 64 + 64 + 64 + 64 + 64 + 64 + 52, 100, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(36) + 64 + 64 + 64 + 64 + 64 + 64 + 52, 90, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(36) + 64 + 64 + 64 + 64 + 64 + 64 + 32, 80, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(36) + 64 + 64 + 64 + 64 + 64 + 76, 70, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(36) + 64 + 64 + 64 + 64 + 64 + 56, 60, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(36) + 64 + 64 + 64 + 64 + 64 + 36, 50, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(36) + 64 + 64 + 64 + 64 + 80, 40, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(36) + 64 + 64 + 64 + 64 + 60, 30, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(36) + 64 + 64 + 64 + 64 + 40 , 20, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(36) + 64 + 64 + 64 + 64 + 20 , 10, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(36) + 64 + 64 + 64 + 64 + 20 , 190, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(36) + 64 + 64 + 64 + 64 + 40 , 180, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(36) + 64 + 64 + 64 + 64 + 60 , 170, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(36) + 64 + 64 + 64 + 64 + 80 , 160, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(36) + 64 + 64 + 64 + 64 + 64 + 36 , 150, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(36) + 64 + 64 + 64 + 64 + 64 + 56 , 140, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(36) + 64 + 64 + 64 + 64 + 64 + 76 , 130, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(36) + 64 + 64 + 64 + 64 + 64 + 64 + 32 , 120, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(36) + 64 + 64 + 64 + 64 + 64 + 64 + 52 , 110, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(36) + 64 + 64 + 64 + 64 + 64 + 64 + 52 , 100, gp.tileSize, gp.tileSize),
                //37
                new WallGround(gp, start + arr.get(37) , 342, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(37) + 250, 240, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(37) + 250 + 200, 280, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(37) + 250 + 200 + 200, 240, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(37) + 250 + 200 + 200 + 200, 280, gp.tileSize, gp.tileSize),
                //38
                new WallGround(gp, start + arr.get(38) , 342, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(38) + 250, 240, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(38) + 250 + 200, 280, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(38) + 250 + 200 + 200, 240, gp.tileSize, gp.tileSize),
                new WallHanging(gp, start + arr.get(38) + 250 + 200 + 200 + 200, 280, gp.tileSize, gp.tileSize),
                //39
                new WallHanging(gp, start + arr.get(39) , 280, gp.tileSize, gp.tileSize),
                new WallGround(gp, start + arr.get(39) + 200, 342, gp.tileSize, gp.tileSize),
                new WallGround(gp, start + arr.get(39) + 200 + 250, 342, gp.tileSize, gp.tileSize),
                new WallGround(gp, start + arr.get(39) + 200 + 250 + 250, 342, gp.tileSize, gp.tileSize),
                //40
                new WallHanging(gp, start + arr.get(40) , 280, gp.tileSize, gp.tileSize),
                new WallGround(gp, start + arr.get(40) + 200, 342, gp.tileSize, gp.tileSize),
                new WallGround(gp, start + arr.get(40) + 200 + 250, 342, gp.tileSize, gp.tileSize),
                new WallGround(gp, start + arr.get(40) + 200 + 250 + 250, 342, gp.tileSize, gp.tileSize)
        );

        wallPattern.addAll(wallPattern);

    }

    public ArrayList<Wall> getWallPattern() {
        return wallPattern;
    }

    public void setWallPattern(ArrayList<Wall> wallPattern) {
        this.wallPattern = wallPattern;
    }

    public void paint(Graphics g) {

    }
}
