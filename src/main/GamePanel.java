package main;

import player.*;
import screen.DeathPanel;
import screen.MenuGame;
import entity.Player;
import obstacles.Wall;
import obstacles.WallPattern;
import inputs.KeyboardListener;
import inputs.MouseHandler;

import java.awt.*;
import java.util.concurrent.TimeUnit;

import javax.swing.*;

import object.AssetSetter;
import object.SuperObjects;
import constant.Constants;
import static constant.Constants.*;
import methods.Utilz;

public class GamePanel extends JPanel{
    final int originalTileSize = 32;
    public final int scale = 2; 
    public final int tileSize = originalTileSize*scale;
    final int maxScreenCol = 20;
    final int maxScreenRow = 8;
    final int screenWidth = tileSize * maxScreenCol; // 1280 px
    final int screenHeight = tileSize * maxScreenRow; // 512 px
    private Player player;
    private WallPattern wp;
    private Utilz utilz;
    private Constants c;
    private MenuGame mg;
    public SuperObjects obj[] = new SuperObjects[10];
    public AssetSetter aSetter = new AssetSetter(this);
    public static int GameState = GAMESTATE_MENU;
    public GamePanel(){
        // player = new Muscle(this, 100, tileSize*2,Constants.GROUND, tileSize, tileSize);
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        addKeyListener(new KeyboardListener(this));
        addMouseListener(new MouseHandler(this));
        wp = new WallPattern(this);
        new Utilz(this);
        mg = new MenuGame();
    }

public void setUpGame(){
    aSetter.serObject();
}
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        if(GameState == GAMESTATE_PLAYING){
            player.draw(g2);
            for(int i=0; i<wp.getWallPattern().size(); i++){
                wp.getWallPattern().get(i).draw(g2);
            }
         } 
         else if(GameState == GAMESTATE_DEATH){
            g2.drawString("GAME OVER", 640, 256);
         } 
         else if(GameState == GAMESTATE_MENU){
            mg.paint(g2);
        }

        g2.dispose();

    }

    public void update(){
        if(GameState == GAMESTATE_PLAYING){
            player.update();
            for (int i=0; i<wp.getWallPattern().size(); i++){
                wp.getWallPattern().get(i).update();
                }
        }

        }

    public void updateEverySec(){
        if(GameState == GAMESTATE_PLAYING){
            player.updateEverySec();;
        }
    }

    public void gameReset(){
        player.setHP(100);
        // waiting for reset obstacles method
    }
    
    public Player getPlayer() {
        return player;
    }
    
    public void setPlayer(Player player) {
        this.player = player;
    }
}
