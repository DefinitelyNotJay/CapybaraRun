package inputs;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import static constant.Constants.*;
import main.GamePanel;

public class MouseHandler implements MouseListener{
    private GamePanel gp;
    public MouseHandler(GamePanel gp){
        this.gp = gp;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if(GamePanel.GameState == GAMESTATE_DEATH){
            GamePanel.GameState = GAMESTATE_PLAYING;
            gp.gameReset();
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
