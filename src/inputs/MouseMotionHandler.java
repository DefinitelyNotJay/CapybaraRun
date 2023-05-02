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
        boolean yButtonArea = e.getX() >= 410 && e.getX() <= 410 + 431;

        boolean isInPlaybuttonArea = e.getY() >= 418 && e.getY() <= 418 + 70;

        boolean isInCreditsButtonArea = e.getY() >= 444 && e.getY() <= 444 + 230;

        boolean isInQuitButtonArea = e.getY() >= 752 && e.getY() <= 752 + 230;

        if (GameState == MENU) {
            mg.button[1].isHover = (isInPlaybuttonArea && yButtonArea) ? true : false;
            mg.button[0].isHover = (isInCreditsButtonArea && yButtonArea) ? true : false;
            mg.button[2].isHover = (isInQuitButtonArea && yButtonArea) ? true : false;

            // boolean creditsButtonStat
            // boolean quitButtonStat
        }
    }

}
