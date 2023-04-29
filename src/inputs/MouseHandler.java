package inputs;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import constant.Constants;

import static constant.Constants.*;

import main.Game;
import main.GamePanel;
import player.*;

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
        if(GamePanel.GameState == GAMESTATE_MENU){
            if(e.getY()>= 263 && e.getY() <= 263+72){
                if(e.getX()>=520 && e.getX()<=520+230){
                    gp.setPlayer(new Ghost(gp,  100, gp.tileSize*2,Constants.GROUND, gp.tileSize, gp.tileSize));
                    GamePanel.GameState = GAMESTATE_PLAYING;
                }
                else if(e.getX()>=754 && e.getX()<=754+230){
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
