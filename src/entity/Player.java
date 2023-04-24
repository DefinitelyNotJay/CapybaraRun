package entity;

import entity.Entity;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

import static constant.Constants.*;
import constant.Constants;
import main.GamePanel;
import methods.Animations;
import methods.LoadImages;
import methods.SpecialAbility;
import methods.Utilz;

public abstract class Player extends Entity implements Animations, LoadImages {

    protected boolean jump, down, left, right, skillOnUse = false, isSlide = false;
    protected int width, height, HP, rateDecreaseHP = 1;
    protected int timeCount = 0;
    protected int jumpHeight = 20;
    protected int crashAreaWidth = 1, crashAreaHeight = 3;
    protected final int gravity = 1;
    protected int velocity = jumpHeight;
    public BufferedImage[] runningAni;
    public BufferedImage slideAni;
    private int aniTick, aniIndex, aniSpeed = 10;
    // public abstract void updateAnimations();
    // public abstract void draw(Graphics g2);
    public abstract void skill();
    public abstract void skillActivate();
    public abstract void skillReset();

    public Player(int HP, double x, double y, int width, int height) {
        super(x, y);
        this.HP = HP;
        this.width = width;
        this.height = height;
    }
    

    public void update() {
            move();
            updateAnimations();
            healthCheck();
    }

    public void drawPlaying(Graphics g2) {
        if (isSlide) {
            g2.drawImage(slideAni, (int) x, (int) y, 90, 40, null);
            isSlide = false;
        } else {
            g2.drawImage(runningAni[aniIndex], (int) x, (int) y - 4, Utilz.gp.tileSize, Utilz.gp.tileSize + 2, null);
        }
    }
    
    public void updateEverySec(){
        decreaseHP();
        timeCount++;
        skillActivate();
    }

    public void drawDeath(Graphics g2){
        // g2.drawString("GAME OVER", 640, 256);
    }

public void updateAnimations(){
    if (down && (y == Constants.GROUND+(slideAni.getHeight()))){
        isSlide = true;
    }
    aniTick++;
    if(aniTick>=aniSpeed){
        aniTick = 0;
        aniIndex++;
    }

    if(aniIndex>=7){
        aniIndex = 0;
    }
}

    public void move(){
        if(jump){
            jump();
        }
      else if(down && (y == Constants.GROUND)){
            slide(Constants.GROUND+(slideAni.getHeight()));
        }
        else if(!down){
            slideReset();
        }
    }
    public void jump(){
            y -= velocity;
            velocity -= gravity;
            if (velocity < -jumpHeight){
                jump = false;
                velocity = jumpHeight;
            }
    }
    public void healthCheck(){
        if(HP <= 0){
            GamePanel.GameState = GAMESTATE_DEATH;
            // showDeadScreen();

        }
    }
    public void decreaseHP(){
        HP -= rateDecreaseHP;
    }
    public void slide(int num){
        this.y = num;
    }
    public void slideReset(){
        this.y = Constants.GROUND;
    }

    public boolean isJump() {
        return jump;
    }

    public void setJump(boolean up) {
        this.jump = up;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }


    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getRateDecreaseHP() {
        return rateDecreaseHP;
    }

    public void setRateDecreaseHP(int rateDecreaseHP) {
        this.rateDecreaseHP = rateDecreaseHP;
    }

    public int getCrashAreaWidth() {
        return crashAreaWidth;
    }

    public void setCrashAreaWidth(int crashAreaWidth) {
        this.crashAreaWidth = crashAreaWidth;
    }

    public int getCrashAreaHeight() {
        return crashAreaHeight;
    }

    public void setCrashAreaHeight(int crashAreaHeight) {
        this.crashAreaHeight = crashAreaHeight;
    }
    
}
