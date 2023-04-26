package entity;

import java.awt.*;
import java.awt.image.BufferedImage;

import static constant.Constants.*;
import constant.Constants;
import main.GamePanel;
import methods.Animations;
import methods.LoadImages;
import methods.Utilz;

public abstract class Player extends Entity implements Animations, LoadImages {

    protected GamePanel gp;
    protected boolean jump, down, left, right, skillOnUse = false, isSlide = false, isCrash = false;
    protected int width, height, HP, rateDecreaseHP = 1;
    protected int timeCount = 0;
    protected int jumpHeight = 16;
    protected int crashAreaWidth = 1, crashAreaHeight = 3;
    protected int skillCooldown, skillDuration, skillDurationCount;
    protected final int gravity = 1;
    protected int velocity = jumpHeight;
    public BufferedImage[] runningAni;
    public BufferedImage slideAni, healthBar, emptyHealthBar, skillBar, skillOnUseBar, skillCooldownBar, skillDurationBar;
    protected int aniTick, aniIndex, aniSpeed = 7;
    // public abstract void updateAnimations();
    // public abstract void draw(Graphics g2);
    public abstract void skill();
    public abstract void skillActivate();
    public abstract void skillReset();

    public Player(GamePanel gp, int HP, double x, double y, int width, int height) {
        super(x, y);
        this.gp = gp;
        this.HP = HP;
        this.width = width;
        this.height = height;
        getStatusImage();
    }

    public void getStatusImage(){
        emptyHealthBar = Utilz.GetImage("/res/player/object/EmptyHealthBar.png");
        healthBar = Utilz.GetImage("/res/player/object/HealthBarFixed.png");
        skillBar = Utilz.GetImage("/res/player/object/emptySkill.png");
        skillOnUseBar = Utilz.GetImage("/res/player/object/skillOnUseBar.png");
        skillCooldownBar = Utilz.GetImage("/res/player/object/skillCooldownBar.png");
        skillDurationBar = Utilz.GetImage("/res/player/object/skillDurationBar.png");
    }
    

    public void update() {
            move();
            updateAnimations();
            healthCheck();
    }

    public void draw(Graphics g2) {
        drawPlayerStatusBar(g2);
        drawPlayer(g2);
    }

    public void drawPlayer(Graphics g2){
        if (isSlide) {
            g2.drawImage(slideAni, (int) x, (int) y-4, 90, 40, null);
            isSlide = false;
        } else {
            g2.drawImage(runningAni[aniIndex], (int) x, (int) y, Utilz.gp.tileSize, Utilz.gp.tileSize + 2, null);
        }
    }

    public void drawPlayerStatusBar(Graphics g2){
        if(skillOnUse){
            g2.drawImage(skillOnUseBar, (int)(x*0.9), (int)(y*0.845), (int)(5*2), (int)(5*2), null);
            g2.drawImage(skillDurationBar, (int)(x*0.976), (int)(y*0.85), (int)((90/skillDuration)*(skillDuration - skillDurationCount)), (int)(4*2), null);
        }
            g2.drawImage(skillCooldownBar, (int)(x*0.91), (int)(y*0.88), (int)((90/skillCooldown-1)*(timeCount)), (int)(10*0.8), null);
            g2.drawImage(skillBar, (int)(x*0.9), (int)(y*0.85), (int)(65*1.5), (int)(10*1.5), null);
            g2.drawImage(healthBar, (int)(gp.tileSize*2.5), (int)(gp.tileSize/1.18), (int)(HP*1.75), (int)(gp.tileSize/5.33), null);
            g2.drawImage(emptyHealthBar, (int)(gp.tileSize*1.61), (int)(gp.tileSize/2.37), (int)(gp.tileSize*3.75), (int)(gp.tileSize/1.06), null);
    }
    
    public void updateEverySec(){
        decreaseHP();
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
            HP = 0;
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

    public void setIsCrash(boolean isCrash){
        this.isCrash = isCrash;

    }

    public boolean isSkillOnUse() {
        return skillOnUse;
    }

    public void setSkillOnUse(boolean skillOnUse) {
        this.skillOnUse = skillOnUse;
    }
    
    
}
