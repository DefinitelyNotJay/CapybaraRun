
package screen;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import static constant.Constants.*;
import javax.swing.JPanel;

import org.w3c.dom.events.MouseEvent;

import main.GamePanel;

public class DeathPanel extends JPanel implements MouseListener, KeyListener{
    private GamePanel gp;
    public DeathPanel(GamePanel gp){
        this.gp = gp;
        addMouseListener(this);
    }
    @Override
    public void paintComponent(Graphics g){

        g.drawString("GAME OVER", 640, 256);
    }

    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
        System.out.println("HEYYY");
        GamePanel.GameState = GAMESTATE_PLAYING;
    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {
    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {
    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {
    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}


