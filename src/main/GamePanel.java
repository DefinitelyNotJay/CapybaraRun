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
    public Tile t1;

    public GamePanel() {
        player = new Muscle(this, 100, tileSize * 2, 320, tileSize, tileSize);
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));

        wp = new WallPattern(this);
        new Utilz(this);
        mg = new MenuGame();
        cc = new ChooseCharacter();
        music = new Sound();
        rs = new Result();
        t1 = new Tile(this);
        addKeyListener(new KeyboardListener(this));
        addMouseListener(new MouseHandler(this));
        addMouseMotionListener(new MouseMotionHandler(this, mg, rs));
        // playMusic(0);
    }

    public void setUpGame() {
        aSetter.setObject();
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
        }
    }

    public void updateEverySec() {
        if (GameState == PLAYING) {
            player.updateEverySec();
        }
    }

    public void gameReset() {
        player.setHP(100);
        wp.randomWallSequence(31);
        wp.loadWalls();

        // waiting for reset obstacles method
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public static void playMusic(int i) {
        music.setFiles(i);
        music.playsound();
        // music.setVolume(SettingPanel.getMusicVolume());
        music.loopsound();
    }
}
