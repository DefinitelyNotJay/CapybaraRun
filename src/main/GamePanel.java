package main;

import player.NormalKapy;
import screen.DeathPanel;
import entity.Player;
import obstacles.Wall;
import obstacles.WallPattern;
import inputs.KeyboardListener;
import inputs.MouseHandler;

import java.awt.*;
import java.util.concurrent.TimeUnit;

import javax.swing.*;

import constant.Constants;
import static constant.Constants.*;
import methods.Utilz;

public class GamePanel extends JPanel{
    final int originalTileSize = 32;
    final int scale = 2;
    public final int tileSize = originalTileSize*scale;
    final int maxScreenCol = 20;
    final int maxScreenRow = 8;
    final int screenWidth = tileSize * maxScreenCol; // 1280 px
    final int screenHeight = tileSize * maxScreenRow; // 512 px
    private Player player;
    private WallPattern wp;
    private Utilz utilz;
    private Constants c;
    private DeathPanel deathScreen;
    public static int GameState = GAMESTATE_PLAYING;
    public GamePanel(){
        player = new NormalKapy(100, 120,Constants.GROUND, tileSize, tileSize);
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        addKeyListener(new KeyboardListener(this));
        addMouseListener(new MouseHandler(this));
        wp = new WallPattern(this);
        new Utilz(this);
        deathScreen = new DeathPanel(this);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        if(GameState == GAMESTATE_PLAYING){
            player.drawPlaying(g2);
            for (int i=0; i<wp.getWallPattern().size(); i++){
                wp.getWallPattern().get(i).draw(g2);
            }
        } else if(GameState == GAMESTATE_DEATH){
            player.drawDeath(g2);
            
        } else if(GameState == GAMESTATE_MENU){
            
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
        player.decreaseHP();
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
