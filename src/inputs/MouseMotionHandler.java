package inputs;

import constant.Constants;
import static constant.Constants.*;
import entity.Muscle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import main.GamePanel;
import static main.GamePanel.GameState;

import screen.ChooseCharacter;
import screen.MenuGame;
import screen.Result;

public class MouseMotionHandler implements MouseMotionListener {
    private GamePanel gp;
    private MenuGame mg;
    private Result rs;
    private ChooseCharacter cc;

    public MouseMotionHandler(GamePanel gp, MenuGame mg, Result rs, ChooseCharacter cc) {
        this.gp = gp;
        this.mg = mg;
        this.rs = rs;
        this.cc = cc;
    }

    @Override
    public void mouseDragged(MouseEvent e) {

        //
    }

    @Override
    public void mouseMoved(MouseEvent e) {

        if (GameState == MENU) {
            boolean yButtonArea = e.getX() >= 570 && e.getX() <= 570 + 125;

            boolean isInPlayButtonArea = e.getY() >= 170 && e.getY() <= 170 + 54;

            boolean isInCreditsButtonArea = e.getY() >= 230 && e.getY() <= 230 + 54;

            boolean isInQuitButtonArea = e.getY() >= 290 && e.getY() <= 290 + 54;

            mg.getPlayBtn().setIsHover(yButtonArea && isInPlayButtonArea);
            mg.getCreditsBtn().setIsHover(yButtonArea && isInCreditsButtonArea);
            mg.getQuitBtn().setIsHover(yButtonArea && isInQuitButtonArea);

        } else if (GameState == RESULT) {
            boolean yButtonArea = e.getY() >= 290 && e.getY() <= 290 + 50;

            boolean isInBackButtonArea = e.getX() >= 365 && e.getX() <= 365 + 125;

            boolean isInRestartButtonArea = e.getX() >= 787 && e.getX() <= 787 + 125;

            rs.getBackBtn().setIsHover(isInBackButtonArea && yButtonArea);
            rs.getRestartBtn().setIsHover(isInRestartButtonArea && yButtonArea);

        } else if (GameState == SELECT) {
            boolean isInButtonYArea = cc.getLeftBtn().getY() <= e.getY() &&
                    cc.getLeftBtn().getY() + cc.getLeftBtn().getWidth() >= e.getY();

            boolean isInLeftBtnArea = e.getX() >= cc.getLeftBtn().getX()
                    && e.getX() <= cc.getLeftBtn().getX() + cc.getLeftBtn().getWidth()
                    && isInButtonYArea;

            boolean isInRightBtnArea = e.getX() >= cc.getRightBtn().getX()
                    && e.getX() <= cc.getRightBtn().getX() + cc.getRightBtn().getWidth()
                    && isInButtonYArea;
            boolean isInGoBtnArea = e.getY() >= cc.getGoBtn().getY()
                    && e.getY() <= cc.getGoBtn().getY() + cc.getGoBtn().getHeight()
                    && e.getX() >= cc.getGoBtn().getX()
                    && e.getX() <= cc.getGoBtn().getX() + cc.getGoBtn().getWidth();
            
            cc.getLeftBtn().setIsHover(isInLeftBtnArea && isInButtonYArea);
            cc.getRightBtn().setIsHover(isInRightBtnArea && isInButtonYArea);
            cc.getGoBtn().setIsHover(isInGoBtnArea);

            
        }
    }

}
