
package inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
                    GamePanel.playSE(4);
                    break;
                case KeyEvent.VK_S:
                    gp.getPlayer().setDown(true);
                    break;

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
