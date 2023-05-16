package entity;

import java.awt.*;
import java.awt.image.BufferedImage;

import static constant.Constants.*;
import constant.Constants;
import main.GamePanel;
import methods.Animations;
import methods.Utilz;

public abstract class Player extends Entity implements Animations {

    protected GamePanel gp;
    protected int character;
    protected boolean jump, down, left, right, skillOnUse = false, isSlide = false, flinching = false,
            appear = true, immune = false, itemImmune = false;
    protected int width, height, HP, maxHP, rateDecreaseHP = 1, flinchingCount = 0, flinchPerSec = 8;
    protected int fps = 0;
    protected int timeCount = 0;
    protected int jumpHeight = 16;
    protected int customSize = 1;
    protected int crashAreaWidth = 1, crashAreaHeight = 3;
    protected int skillCooldown, skillDuration, skillDurationCount;
    protected final int gravity = 1;
    protected double healthMultiply;
    protected int velocity = jumpHeight;
    protected int moveReset = 0;
    public BufferedImage[] runningAni;
    protected BufferedImage skillAniRun[], normalAnirun[];
    protected BufferedImage skillAniSlide, normalAniSlide;
    public BufferedImage slideAni, healthBar, emptyHealthBar, skillBar, skillOnUseBar, skillCooldownBar,
            skillDurationBar;
    protected int aniTick, aniIndex, aniSpeed = 7;

    // public abstract void updateAnimations();
    // public abstract void draw(Graphics g2);
    public abstract void skill();

    public abstract void skillActivate();

    public abstract void skillReset();

    public abstract void playerReset();

    public Player(GamePanel gp, int character, int HP, int x, int y, int width, int height) {
        super(x, y);
        this.gp = gp;
        this.character = character;
        this.HP = HP;
        this.width = width;
        this.height = height;
        maxHP = HP;
        healthMultiply = (100 + 0.0) / HP;
        getStatusImage();
        moveReset = gp.tileSize * 5;
    }

    public void getStatusImage() {
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
        getImmune();

    }

    public void draw(Graphics g2) {
        // 60FPS
        getFlinching();
        drawPlayerStatusBar(g2);
        drawPlayer(g2);
    }

    public void drawPlayer(Graphics g2) {
        if (down && !jump) {
            if (appear) {
                if (skillOnUse) {
                    g2.drawImage(skillAniSlide, (int) x, (int) y, (int) (90 * 1.3 * customSize),
                            (int) (40 * 1.3 * customSize),
                            null);
                }

                else {
                    g2.drawImage(normalAniSlide, (int) x, (int) y, (int) (90 * 1.3 * customSize),
                            (int) (40 * 1.3 * customSize),
                            null);
                }
            }

        } else {
            if (appear) {
                if (skillOnUse) {
                    g2.drawImage(skillAniRun[aniIndex], (int) x, (int) y + 5,
                            (int) (Utilz.gp.tileSize * 1.3 * customSize),
                            (int) (Utilz.gp.tileSize * 1.3 * customSize), null);
                } else {
                    g2.drawImage(normalAnirun[aniIndex], (int) x, (int) y + 5,
                            (int) (Utilz.gp.tileSize * 1.3 * customSize),
                            (int) (Utilz.gp.tileSize * 1.3 * customSize), null);
                }
            }

        }
    }

    public void drawPlayerStatusBar(Graphics g2) {

        g2.drawImage(healthBar, (int) (gp.tileSize * 2.5), (int) (gp.tileSize /
                1.18),
                (int) (HP * healthMultiply * 1.75),
                (int) (gp.tileSize / 5.33), null);
        // System.out.println(healthMultiply);
        g2.drawImage(emptyHealthBar, (int) (gp.tileSize * 1.61), (int) (gp.tileSize / 2.37), (int) (gp.tileSize * 3.75),
                (int) (gp.tileSize / 1.06), null);
    }

    public void updateEverySec() {
        decreaseHP();
    }

    public void updateAnimations() {
        aniTick++;
        if (aniTick >= aniSpeed) {
            aniTick = 0;
            aniIndex++;
        }

        if (aniIndex >= 7) {
            aniIndex = 0;
        }
    }

    public void move() {
        if (jump) {
            y -= velocity;
            velocity -= gravity;
            if (velocity < -jumpHeight) {
                jump = false;
                velocity = jumpHeight;
            }
        }

        else if (down && (y >= Constants.GROUND)) {
            y = 360;
        } else if (!down) {
            slideReset();
        }
    }

    public void healthCheck() {
        if (HP <= 0) {
            HP = 0;
            GamePanel.GameState = DEAD;
            // GamePanel.stopMusic();
            // GamePanel.playMusic(3);

        } else if (HP >= maxHP) {
            HP = maxHP;
        }

    }

    public void getImmune() {
        if (immune) {
            rateDecreaseHP = 0;
            WALLDAMAGE = 0;
        } else {
            rateDecreaseHP = 1;
            WALLDAMAGE = 10;
        }
    }

    public void getFlinching() {

        // immune state start
        if (flinching) {
            flinchingCount++;
            flinchingBlink();
            immune = true;
        }

        // immune state end
        if (flinchingCount >= 80) {
            appear = true;
            flinching = false;
            flinchingCount = 0;
            if (!skillOnUse && !itemImmune)
                immune = false;
        }
    }

    public void getSkillSprites() {
        runningAni = skillAniRun;
        slideAni = skillAniSlide;
    }

    public void getNormalSprites() {
        runningAni = normalAnirun;
        slideAni = normalAniSlide;
    }

    public void flinchingBlink() {
        if (flinchingCount % 2 == 0) {
            appear = true;
        } else {
            appear = false;
        }
    }

    public boolean isFlying() {
        if (this.x > GROUND) {
            return true;
        } else {
            return false;
        }
    }

    public void decreaseHP() {
        HP -= rateDecreaseHP;
    }

    public void slide(int num) {
        this.y = num;
    }

    public void slideReset() {
        this.y = moveReset;
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

    public boolean isSkillOnUse() {
        return skillOnUse;
    }

    public void setSkillOnUse(boolean skillOnUse) {
        this.skillOnUse = skillOnUse;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public boolean isFlinching() {
        return flinching;
    }

    public void setFlinching(boolean flinching) {
        this.flinching = flinching;
    }

    public int getFlinchingCount() {
        return flinchingCount;
    }

    public void setFlinchingCount(int flinchingCount) {
        this.flinchingCount = flinchingCount;
    }

    public boolean isImmune() {
        return immune;
    }

    public void setImmune(boolean immune) {
        this.immune = immune;
    }

    public int getCustomSize() {
        return customSize;
    }

    public void setCustomSize(int customSize) {
        this.customSize = customSize;
    }

    public void setMoveReset(int moveReset) {
        this.moveReset = moveReset;
    }

    public int getMoveReset() {
        return moveReset;
    }

    public int getCharacter() {
        return character;
    }

    public boolean getItemImmune() {
        return itemImmune;
    }

    public void setItemImmune(boolean itemImmune) {
        this.itemImmune = itemImmune;

    }

}
