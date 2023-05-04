package inputs;

import constant.Constants;
import static constant.Constants.*;
import entity.Muscle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import main.GamePanel;
import static main.GamePanel.GameState;
import screen.MenuGame;
import screen.Result;

public class MouseMotionHandler implements MouseMotionListener {
    private GamePanel gp;
    private MenuGame mg;
    private Result rs;

    public MouseMotionHandler(GamePanel gp, MenuGame mg, Result rs) {
        this.gp = gp;
        this.mg = mg;
        this.rs = rs;
    }

    @Override
    public void mouseDragged(MouseEvent e) {

        //
    }

    @Override
    public void mouseMoved(MouseEvent e) {

        if (GameState == MENU) {
            boolean yButtonArea = e.getX() >= 570 && e.getX() <= 570 + 125;

            boolean isInPlaybuttonArea = e.getY() >= 170 && e.getY() <= 170 + 54;

            boolean isInCreditsButtonArea = e.getY() >= 230 && e.getY() <= 230 + 54;

            boolean isInQuitButtonArea = e.getY() >= 290 && e.getY() <= 290 + 54;
            mg.button[1].isHover = (isInPlaybuttonArea && yButtonArea) ? true : false;
            mg.button[0].isHover = (isInCreditsButtonArea && yButtonArea) ? true : false;
            mg.button[2].isHover = (isInQuitButtonArea && yButtonArea) ? true : false;

        } else if (GameState == RESULT) {
            boolean yButtonArea = e.getY() >= 290 && e.getY() <= 290 + 50;

            boolean isInbackButtonArea = e.getX() >= 365 && e.getX() <= 365 + 125;

            boolean isInRestartButtonArea = e.getX() >= 787 && e.getX() <= 787 + 125;

            rs.getButton()[0].isHover = (isInbackButtonArea && yButtonArea) ? true : false;

            rs.getButton()[1].isHover = (isInRestartButtonArea && yButtonArea) ? true : false;

        }
    }

}
