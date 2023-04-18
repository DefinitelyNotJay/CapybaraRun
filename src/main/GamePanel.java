
package main;

import entity.NormalKapy;
import entity.Player;
import entity.Wall;
import entity.WallPattern;
import inputs.KeyboardListener;
import java.awt.*;
import javax.swing.*;
import methods.Utilz;

public class GamePanel extends JPanel{
    final int originalTileSize = 16;
    final int scale = 4;
    public final int tileSize = originalTileSize*scale;
    final int maxScreenCol = 20;
    final int maxScreenRow = 8;
    final int screenWidth = tileSize * maxScreenCol; // 960 px
    final int screenHeight = tileSize * maxScreenRow; // 384 px
    private Player player;
    private WallPattern wp;
    private Utilz utilz;
    public final int GROUND_H = 500;
    public GamePanel(){
        player = new NormalKapy(100, 120,250, tileSize, tileSize);
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        addKeyListener(new KeyboardListener(this));
        wp = new WallPattern(this);
        new Utilz(this);
//        this.setBackground(Color.PINK);
        
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        player.draw(g2);
        for (int i=0; i<wp.getWallPattern().size(); i++){
            wp.getWallPattern().get(i).draw(g2);
        }
        g2.dispose();

    }

    public void update(){
        player.update();
        for (int i=0; i<wp.getWallPattern().size(); i++){
            wp.getWallPattern().get(i).update();
            }
            
        }

    public void updateEverySec(){
        player.decreaseHP();
    }
    
    public Player getPlayer() {
        return player;
    }
    
    public void setPlayer(Player player) {
        this.player = player;
    }
}
