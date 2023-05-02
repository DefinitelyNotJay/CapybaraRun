package inputs;

import constant.Constants;
import static constant.Constants.*;
import entity.Muscle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import main.GamePanel;
import static main.GamePanel.GameState;
import screen.MenuGame;

public class MouseMotionHandler implements MouseMotionListener {
    private GamePanel gp;
    private MenuGame mg;

    public MouseMotionHandler(GamePanel gp, MenuGame mg) {
        this.gp = gp;
        this.mg = mg;
    }

    @Override
    public void mouseDragged(MouseEvent e) {

        //
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        boolean yButtonArea = e.getY() >= 263 && e.getY() <= 263 + 72;

        boolean isInPlaybuttonArea = e.getX() >= 517 && e.getX() <= 517 + 230;

        boolean isInCreditsButtonArea = e.getX() >= 284 && e.getX() <= 284 + 230;

        boolean isInQuitButtonArea = e.getX() >= 752 && e.getX() <= 752 + 230;

        if (GameState == MENU) {
            mg.button[1].isHover = (isInPlaybuttonArea && yButtonArea) ? true : false;
            mg.button[0].isHover = (isInCreditsButtonArea && yButtonArea) ? true : false;
            mg.button[2].isHover = (isInQuitButtonArea && yButtonArea) ? true : false;

            // boolean creditsButtonStat
            // boolean quitButtonStat
        }
    }

}
