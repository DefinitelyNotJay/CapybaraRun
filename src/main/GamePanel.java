package main;

import screen.*;
import tiles.*;
import entity.Player;
import obstacles.WallPattern;
import inputs.*;
import java.awt.*;
import javax.swing.*;

import Item.AssetSetter;
import static constant.Constants.*;
import inputs.MouseMotionHandler;
import methods.Utilz;

public class GamePanel extends JPanel {
    public final int originalTileSize = 32;
    public final int scale = 2;
    public final int tileSize = originalTileSize * scale;
    public final int maxScreenCol = 20;
    public final int maxScreenRow = 8;
    public final int screenWidth = tileSize * maxScreenCol; // 1280 px
    public final int screenHeight = tileSize * maxScreenRow; // 512 px

    private Player player;
    private WallPattern wp;
    private MenuGame mg;
    private Result rs;
    private ChooseCharacter cc;
    private Pause p;
    private AssetSetter as;
    private Credits cd;
    // test
    private Leaderboard lb;
    public static int GameState = MENU;
    private static Sound music, effect;
    private int score = 0, rateScore = 1, stageCountChange = 40, stageCount = 0;
    public Tile t1;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));

        new Utilz(this);
        // screen
        mg = new MenuGame();
        cc = new ChooseCharacter();
        rs = new Result(this);
        p = new Pause(this);
        cd = new Credits(this);
        lb = new Leaderboard(this);

        // item
        as = new AssetSetter(this);

        // listener
        addKeyListener(new KeyboardListener(this));
        addMouseListener(new MouseHandler(this, mg, rs, cc, p, cd));
        addMouseMotionListener(new MouseMotionHandler(this, mg, rs, cc, p, cd));
        // sound
        music = new Sound();
        effect = new Sound();
        playMusic(0);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        if (GameState == PLAYING || GameState == PAUSE) {
            paintGamePlay(g2);
            if (GameState == PAUSE) {
                p.paint(g2);
            }

        } else if (GameState == MENU) {
            mg.paint(g2);
        } else if (GameState == RESULT) {
            rs.paint(g2);
        } else if (GameState == SELECT) {
            cc.paint(g2);
        } else if (GameState == CREDITS) {
            cd.paint(g2);
        } else if (GameState == DEAD) {
            stopMusic();
            Utilz.sleep(2);
            lb.addData(new Score(score, player.getCharacter()));
            lb.writeData();
            GameState = RESULT;
            playMusic(3);
        } else if (GameState == LEADERBOARD) {
            lb.paint(g2);
        }
        g2.dispose();
    }

    public void update() {
        if (GameState == PLAYING) {
            score += rateScore;
            player.update();
            for (int i = 0; i < wp.getWallPattern().size(); i++) {
                wp.getWallPattern().get(i).update();
            }
            for (int i = 0; i < as.getAllItems().size(); i++) {
                as.getAllItems().get(i).update();
            }
        } else if (GameState == MENU) {
            mg.update();
        } else if (GameState == SELECT) {
            cc.update();
        }
    }

    public void updateEverySec() {
        if (GameState == PLAYING) {
            playScreenUpdate();
        }

    }

    public void paintGamePlay(Graphics2D g2) {
        t1.draw(g2);
        for (int i = 0; i < wp.getWallPattern().size(); i++) {
            wp.getWallPattern().get(i).draw(g2);
        }
        player.draw(g2);
        for (int i = 0; i < as.getAllItems().size(); i++) {
            as.getAllItems().get(i).draw(g2);
        }
        g2.setFont(new Font("Arcade Normal", Font.PLAIN, tileSize / 2));
        g2.setColor(Color.WHITE);
        g2.drawString(String.format("%06d", score), 1050, 65);
    }

    public void playScreenUpdate() {
        stageCount++;
        if (stageCount >= stageCountChange) {
            t1.stageChange();
            for (int i = 0; i < wp.getWallPattern().size(); i++) {
                wp.getWallPattern().get(i).updateWallSkin();
            }
            t1.tileUpdate();
            stageCount = 0;
        }
        player.updateEverySec();
        if (wp.getWallPattern().size() <= 0) {
            this.wp = new WallPattern(this);
            wp.init();
            for (int i = 0; i < wp.getWallPattern().size(); i++) {
                wp.getWallPattern().get(i).updateWallSkin();
            }
            as = new AssetSetter(this);
        }
    }

    public void gameReset() {
        player.setHP(player.getMaxHP());
        player.playerReset();
        this.wp = new WallPattern(this);
        wp.init();
        t1 = new Tile(this, wp);
        GAMESPEED = 4;
        for (int i = 0; i < wp.getWallPattern().size(); i++) {
            wp.getWallPattern().get(i).updateWallSkin();
        }
        stageCount = 0;
        score = 0;
    }

    public WallPattern getWp() {
        return wp;
    }

    public void setWp(WallPattern wp) {
        this.wp = wp;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public static void stopMusic() {
        music.stopSound();
    }

    public static void playMusic(int i) {
        music.setFiles(i);
        music.playSound();
        music.setVolume(30);
        music.loopSound();
    }

    public static void playSE(int i) {
        effect.setFiles(i);
        effect.setVolume(25);
        effect.playSound();
    }

    public static void playhit(int i) {
        effect.setFiles(i);
        effect.setVolume(80);
        effect.playSound();
    }

    public static Sound getEffect() {
        return effect;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getRateScore() {
        return rateScore;
    }

    public void setRateScore(int rateScore) {
        this.rateScore = rateScore;
    }

    public Tile getTile() {
        return t1;
    }

    public Sound getMusic() {
        return music;
    }

    public Leaderboard getLeaderboard() {
        return lb;
    }

}
