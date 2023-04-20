/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import entity.Entity;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

import constant.Constants;
import main.GamePanel;
import methods.Animations;
import methods.Utilz;

public abstract class Player extends Entity implements Animations{
    protected boolean jump, down, left, right;
    protected int width, height, HP, rateDecreaseHP = 1;
    protected int jumpHeight = 20;
    protected final int gravity = 1;
    protected int velocity = jumpHeight;
    protected int slideNum = 0;
    protected int first_y;
    public BufferedImage[] runningAni;
    public BufferedImage slideAni;
    private int aniTick, aniIndex, aniSpeed=10;
    // public abstract void updateAnimations();
    // public abstract void draw(Graphics g2);

    public Player(int HP, double x, double y, int width, int height){
        super(x, y);
        this.HP = HP;
        first_y = (int)y;
        this.width = width;
        this.height = height;
    }

    public void update(){
        move();
        updateAnimations(); //ควรไปอยู่ใน paint
    }
    
    public void updateAnimations(){
        aniTick++;
        if(aniTick>=aniSpeed){
            aniTick = 0;
            aniIndex++;
        }

        if(aniIndex>=7){
            aniIndex = 0;
        }
    }

    public void draw(Graphics g2){
    if(down && (y == Constants.GROUND+(slideAni.getHeight()))){
        g2.drawImage(slideAni, (int)x, (int)y, 90, 40, null);
    }
    else{
        // 4 is missing T-T
        g2.drawImage(runningAni[aniIndex], (int)x, (int)y-4, Utilz.gp.tileSize, Utilz.gp.tileSize+2, null);
    }

}

    public void move(){
        if(jump){
            jump();
        } 
      else if(down && (y == Constants.GROUND)){
            slide(Constants.GROUND+(slideAni.getHeight()));
            // slideReset();
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

    public int getSlideNum() {
        return slideNum;
    }

    public void setSlideNum(int slideNum) {
        this.slideNum = slideNum;
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
}
