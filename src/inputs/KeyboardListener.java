
package inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import entity.Ninja;
import main.GamePanel;
import static main.GamePanel.GameState;
import static constant.Constants.*;

public class KeyboardListener implements KeyListener {
    private GamePanel gp;

    public KeyboardListener(GamePanel gp) {
        this.gp = gp;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (GameState == PLAYING) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_W:
                    gp.getPlayer().setJump(true);
                    switch(gp.getPlayer().getCharacter()){
                        case CAPY:
                            GamePanel.playSE(4);
                            break;
                        case NINJA:
                            GamePanel.playSE(23);
                            break;
                        case MUSCLE:
                            GamePanel.playSE(24);
                            break;
                        case GHOST:
                            GamePanel.playSE(25);
                            break;
                        case ZOMBIE:
                            GamePanel.playSE(26);
                            break;
                    }
                    break;
                case KeyEvent.VK_S:
                    gp.getPlayer().setDown(true);
                    break;
                case KeyEvent.VK_ESCAPE:
                    GamePanel.GameState = PAUSE;
                    // ใส่ method หยุดเพลง
            }
        }

        else if (GameState == PAUSE) {
            if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                GamePanel.GameState = PLAYING;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (GameState == PLAYING) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_W:
                case KeyEvent.VK_SPACE:
                case KeyEvent.VK_UP:
                    gp.getPlayer().setJump(true);
                    break;
                case KeyEvent.VK_S:
                case KeyEvent.VK_DOWN:
                    gp.getPlayer().setDown(false);
                    break;
            }

        }
    }
}
