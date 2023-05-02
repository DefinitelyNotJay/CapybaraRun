package inputs;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import constant.Constants;
import entity.Muscle;

import static constant.Constants.*;

import main.GamePanel;
import static main.GamePanel.GameState;
import tiles.*;

public class MouseHandler implements MouseListener {
    private GamePanel gp;

    public MouseHandler(GamePanel gp) {
        this.gp = gp;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (GamePanel.GameState == RESULT) {
            gp.gameReset();
            GamePanel.GameState = PLAYING;
        }
        if (GamePanel.GameState == MENU) {
            if (e.getY() >= 263 && e.getY() <= 263 + 72) {
                if (e.getX() >= 520 && e.getX() <= 520 + 230) {
                    gp.setPlayer(new Muscle(gp, 100, gp.tileSize * 2, Constants.GROUND, gp.tileSize, gp.tileSize));
                    GamePanel.GameState = PLAYING;
                } else if (e.getX() >= 754 && e.getX() <= 754 + 230) {
                    System.exit(0);
                }
            }

        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
