package main;

import screen.ChooseCharacter;
import screen.MenuGame;
import screen.Result;
import tiles.*;
import entity.Muscle;
import entity.Player;
import obstacles.WallPattern;
import inputs.KeyboardListener;
import inputs.MouseHandler;
import java.awt.*;
import javax.swing.*;

import Item.AssetSetter;
import Item.SuperObjects;
import constant.Constants;
import static constant.Constants.*;
import inputs.MouseMotionHandler;
import methods.Utilz;

public class GamePanel extends JPanel {
    final int originalTileSize = 32;
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
    public SuperObjects obj[] = new SuperObjects[10];
    public AssetSetter aSetter = new AssetSetter(this);
    public static int GameState = MENU;
    private static Sound music;
    private static Sound effect;
    public Tile t1;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));

        new Utilz(this);
        // screen
        mg = new MenuGame();
        cc = new ChooseCharacter();
        rs = new Result();
        // wall

        t1 = new Tile(this);
        // listener
        addKeyListener(new KeyboardListener(this));
        addMouseListener(new MouseHandler(this, mg, rs, cc));
        addMouseMotionListener(new MouseMotionHandler(this, mg, rs));
        // sound
        music = new Sound();
        effect = new Sound();
        playMusic(0);
    }

    public void setUpGame() {
        aSetter.setObject();
    }

    public WallPattern getWp() {
        return wp;
    }

    public void setWp(WallPattern wp) {
        this.wp = wp;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        if (GameState == PLAYING) {
            t1.draw(g2);
            for (int i = 0; i < wp.getWallPattern().size(); i++) {
                wp.getWallPattern().get(i).draw(g2);
            }
            player.draw(g2);
            for (int i = 0; i < obj.length; i++) {
                if (obj[i] != null) {
                    // if (SuperObjects.getCollision() != true)
                    obj[i].draw(g2);
                }
            }
        } else if (GameState == DEAD) {
            Utilz.sleep(2);
            GameState = RESULT;
        } else if (GameState == MENU) {
            mg.paint(g2);
        } else if (GameState == RESULT) {
            rs.paint(g2);
        } else if (GameState == SELECT) {
            cc.paint(g2);
        }

        g2.dispose();
    }

    public void update() {
        if (GameState == PLAYING) {
            player.update();
            for (int i = 0; i < wp.getWallPattern().size(); i++) {
                wp.getWallPattern().get(i).update();
            }
            for (int i = 0; i < obj.length; i++) {
                if (obj[i] != null) {
                    obj[i].update();
                }
            }
        } else if (GameState == MENU) {
            mg.update();
        } else if (GameState == SELECT) {
            cc.update();
        }
    }

    public void updateEverySec() {
        if (GameState == PLAYING) {
            player.updateEverySec();
        }
    }

    public void gameReset() {
        player.setHP(player.getMaxHP());
        wp.randomWallSequence(wp.getWallAmount());
        wp.loadWalls();

        // waiting for reset obstacles method
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
        // music.setVolume(10);
        music.loopSound();
    }

    public static void playSE(int i) {
        effect.setFiles(i);
        effect.setVolume(20);
        effect.playSound();
    }

    public static Sound getEffect() {
        return effect;
    }
}
