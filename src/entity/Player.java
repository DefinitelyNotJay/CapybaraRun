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
import main.GamePanel;
import methods.Animations;

public abstract class Player extends Entity implements Animations{
    private boolean jump, down, left, right;
    protected int width, height;
    private int jumpHeight = 20;
    private final int gravity = 1;
    private int velocity = jumpHeight;
    private int slideNum = 0;
    private int first_y;
    private int HP;
    public BufferedImage[] runningAni;
    public BufferedImage[][] jumpingAni;

    public abstract void updateAnimations();
    public abstract void getRunningImg();
    public abstract void getJumpingImg();
    public abstract void getSlideImg();
    public Player(int HP, double x, double y, int width, int height){
        super(x, y);
        this.HP = HP;
        first_y = (int)y;
        this.width = width;
        this.height = height;
//        this.tileSize = tileSize;
        
    }
    public void draw(Graphics g2){
        g2.setColor(Color.pink);
        g2.fillRect((int)x, (int)y, width, height);
        g2.drawLine((int)x, (int)y, 500, 2);
//        g2.dispose()
    }
    public void update(){
        move();
        updateAnimations();
    }
    public void move(){
        if(jump){
            jump();
        } 
      else if(down && (this.y == first_y)){
            slide(300);
        }
        down = false;
        
    }
    public void jump(){

            y -= velocity;
            velocity -= gravity;
            if (velocity < -jumpHeight){
                jump = false;
                velocity = jumpHeight;
            }
    }
    public void slide(int num){
        this.y = num;
    }
    public void slideReset(){
        this.y = first_y;
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
}
