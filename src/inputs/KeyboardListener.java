
package inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import main.GamePanel;

public class KeyboardListener implements KeyListener {
    private GamePanel gp;

    public KeyboardListener(GamePanel gp) {
        this.gp = gp;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // throw new UnsupportedOperationException("Not supported yet."); // Generated
        // from
        // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                GamePanel.playSE(4);
                gp.getPlayer().setJump(true);
                break;
            case KeyEvent.VK_S:
                GamePanel.playSE(5);
                gp.getPlayer().setDown(true);
                break;
            // case KeyEvent.VK_A:
            // gp.getPlayer().setLeft(true);
            // break;
            // case KeyEvent.VK_D:
            // gp.getPlayer().setRight(true);
            // break;

        }
        // throw new UnsupportedOperationException("Not supported yet."); // Generated
        // from
        // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            // case KeyEvent.VK_SPACE:
            // gp.getPlayer().setJump(false);
            // break;
            case KeyEvent.VK_W:
                GamePanel.playMusic(4);
                // GamePanel.stopMusic();
                gp.getPlayer().setJump(true);
                break;
            case KeyEvent.VK_S:
                GamePanel.playMusic(5);
                // GamePanel.stopMusic();
                gp.getPlayer().setDown(false);
                // gp.getPlayer().slideReset();
                break;
            // case KeyEvent.VK_A:
            // gp.getPlayer().setLeft(false);
            // break;
            // case KeyEvent.VK_D:
            // gp.getPlayer().setRight(false);
            // break;

        }
    }
}
