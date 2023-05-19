package inputs;

import static constant.Constants.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import main.GamePanel;
import static main.GamePanel.GameState;

import screen.ChooseCharacter;
import screen.Credits;
import screen.MenuGame;
import screen.Pause;
import screen.Result;

public class MouseMotionHandler implements MouseMotionListener {
        private GamePanel gp;

        public MouseMotionHandler(GamePanel gp) {
                this.gp = gp;

        }

        @Override
        public void mouseDragged(MouseEvent e) {
        }

        @Override
        public void mouseMoved(MouseEvent e) {

                if (GameState == MENU) {
                        boolean yButtonArea = gp.getMenuGame().getPlayBtn().getY() <= e.getY() &&
                                        gp.getMenuGame().getPlayBtn().getY()
                                                        + gp.getMenuGame().getPlayBtn().getHeight() >= e.getY();

                        boolean isInPlayButtonArea = e.getX() >= gp.getMenuGame().getPlayBtn().getX()
                                        && e.getX() <= gp.getMenuGame().getPlayBtn().getX()
                                                        + gp.getMenuGame().getPlayBtn().getWidth()
                                        && yButtonArea;

                        boolean isInCreditsButtonArea = e.getX() >= gp.getMenuGame().getCreditsBtn().getX()
                                        && e.getX() <= gp.getMenuGame().getCreditsBtn().getX()
                                                        + gp.getMenuGame().getCreditsBtn().getWidth()
                                        && yButtonArea;

                        boolean isInQuitButtonArea = e.getX() >= gp.getMenuGame().getQuitBtn().getX()
                                        && e.getX() <= gp.getMenuGame().getQuitBtn().getX()
                                                        + gp.getMenuGame().getQuitBtn().getWidth()
                                        && yButtonArea;

                        boolean isInScoreButtonArea = e.getX() >= gp.getMenuGame().getScoreBtn().getX()
                                        && e.getX() <= gp.getMenuGame().getScoreBtn().getX()
                                                        + gp.getMenuGame().getScoreBtn().getWidth()
                                        && yButtonArea;

                        boolean isInHowToButtonArea = e.getX() >= gp.getMenuGame().getHowToBtn().getX()
                                        && e.getX() <= gp.getMenuGame().getHowToBtn().getX()
                                                        + gp.getMenuGame().getHowToBtn().getWidth()
                                        && yButtonArea;

                        gp.getMenuGame().getPlayBtn().setIsHover(isInPlayButtonArea);
                        gp.getMenuGame().getCreditsBtn().setIsHover(isInCreditsButtonArea);
                        gp.getMenuGame().getQuitBtn().setIsHover(isInQuitButtonArea);
                        gp.getMenuGame().getScoreBtn().setIsHover(isInScoreButtonArea);
                        gp.getMenuGame().getHowToBtn().setIsHover(isInHowToButtonArea);

                } else if (GameState == RESULT) {
                        boolean yButtonYArea = gp.getResult().getBackBtn().getY() <= e.getY() &&
                                        gp.getResult().getBackBtn().getY() + gp.getResult().getBackBtn().getWidth() >= e
                                                        .getY();

                        boolean isInBackButtonArea = e.getX() >= gp.getResult().getBackBtn().getX()
                                        && e.getX() <= gp.getResult().getBackBtn().getX()
                                                        + gp.getResult().getBackBtn().getWidth()
                                        && yButtonYArea;

                        boolean isInRestartButtonArea = e.getX() >= gp.getResult().getRestartBtn().getX()
                                        && e.getX() <= gp.getResult().getRestartBtn().getX()
                                                        + gp.getResult().getRestartBtn().getWidth()
                                        && yButtonYArea;

                        gp.getResult().getBackBtn().setIsHover(isInBackButtonArea);
                        gp.getResult().getRestartBtn().setIsHover(isInRestartButtonArea);

                } else if (GameState == SELECT) {
                        boolean isInButtonYArea = gp.getChooseCharacter().getLeftBtn().getY() <= e.getY() &&
                                        gp.getChooseCharacter().getLeftBtn().getY()
                                                        + gp.getChooseCharacter().getLeftBtn().getWidth() >= e
                                                                        .getY();

                        boolean isInLeftBtnArea = e.getX() >= gp.getChooseCharacter().getLeftBtn().getX()
                                        && e.getX() <= gp.getChooseCharacter().getLeftBtn().getX()
                                                        + gp.getChooseCharacter().getLeftBtn().getWidth()
                                        && isInButtonYArea;

                        boolean isInRightBtnArea = e.getX() >= gp.getChooseCharacter().getRightBtn().getX()
                                        && e.getX() <= gp.getChooseCharacter().getRightBtn().getX()
                                                        + gp.getChooseCharacter().getRightBtn().getWidth()
                                        && isInButtonYArea;

                        boolean isInGoBtnArea = e.getY() >= gp.getChooseCharacter().getGoBtn().getY()
                                        && e.getY() <= gp.getChooseCharacter().getGoBtn().getY()
                                                        + gp.getChooseCharacter().getGoBtn().getHeight()
                                        && e.getX() >= gp.getChooseCharacter().getGoBtn().getX()
                                        && e.getX() <= gp.getChooseCharacter().getGoBtn().getX()
                                                        + gp.getChooseCharacter().getGoBtn().getWidth();
                        boolean isInBackBtnArea = e.getY() >= gp.getChooseCharacter().getBackBtn().getY()
                                        && e.getY() <= gp.getChooseCharacter().getBackBtn().getY()
                                                        + gp.getChooseCharacter().getBackBtn().getHeight()
                                        && e.getX() >= gp.getChooseCharacter().getBackBtn().getX()
                                        && e.getX() <= gp.getChooseCharacter().getBackBtn().getX()
                                                        + gp.getChooseCharacter().getBackBtn().getWidth();
                        gp.getChooseCharacter().getLeftBtn().setIsHover(isInLeftBtnArea);
                        gp.getChooseCharacter().getRightBtn().setIsHover(isInRightBtnArea);
                        gp.getChooseCharacter().getGoBtn().setIsHover(isInGoBtnArea);
                        gp.getChooseCharacter().getBackBtn().setIsHover(isInBackBtnArea);

                } else if (GameState == PAUSE) {
                        boolean isInButtonXArea = gp.getPause().getButton()[0].getX() <= e.getX() &&
                                        gp.getPause().getButton()[0].getX()
                                                        + gp.getPause().getButton()[0].getWidth() >= e.getX();

                        boolean isInResumeBtnArea = e.getY() >= gp.getPause().getButton()[0].getY()
                                        && e.getY() <= gp.getPause().getButton()[0].getY()
                                                        + gp.getPause().getButton()[0].getHeight()
                                        && isInButtonXArea;

                        boolean isInBackBtnArea = e.getY() >= gp.getPause().getButton()[1].getY()
                                        && e.getY() <= gp.getPause().getButton()[1].getY()
                                                        + gp.getPause().getButton()[1].getHeight()
                                        && isInButtonXArea;

                        boolean isInRestartBtnArea = e.getY() >= gp.getPause().getButton()[2].getY()
                                        && e.getY() <= gp.getPause().getButton()[2].getY()
                                                        + gp.getPause().getButton()[2].getHeight()
                                        && isInButtonXArea;

                        gp.getPause().getButton()[0].setIsHover(isInResumeBtnArea);
                        gp.getPause().getButton()[1].setIsHover(isInBackBtnArea);
                        gp.getPause().getButton()[2].setIsHover(isInRestartBtnArea);
                } else if (GameState == CREDITS) {
                        boolean isInBackBtnArea = e.getX() >= gp.getCredits().getBackBtn().getX()
                                        && e.getX() <= gp.getCredits().getBackBtn().getX()
                                                        + gp.getCredits().getBackBtn().getWidth()
                                        && e.getY() >= gp.getCredits().getBackBtn().getY()
                                        && e.getY() <= gp.getCredits().getBackBtn().getY()
                                                        + gp.getCredits().getBackBtn().getHeight();
                        gp.getCredits().getBackBtn().setIsHover(isInBackBtnArea);
                } else if (GameState == LEADERBOARD) {
                        boolean isInBackBtnArea = e.getX() >= gp.getLeaderboard().getBackBtn().getX()
                                        && e.getX() <= gp.getLeaderboard().getBackBtn().getX()
                                                        + gp.getLeaderboard().getBackBtn().getWidth()
                                        && e.getY() >= gp.getLeaderboard().getBackBtn().getY()
                                        && e.getY() <= gp.getLeaderboard().getBackBtn().getY()
                                                        + gp.getLeaderboard().getBackBtn().getHeight();
                        gp.getLeaderboard().getBackBtn().setIsHover(isInBackBtnArea);
                } else if (GameState == HOWTO1) {
                        boolean isInBackBtnArea = e.getX() >= gp.getHowto1().getBackBtn().getX()
                                        && e.getX() <= gp.getHowto1().getBackBtn().getX()
                                                        + gp.getHowto1().getBackBtn().getWidth()
                                        && e.getY() >= gp.getHowto1().getBackBtn().getY()
                                        && e.getY() <= gp.getHowto1().getBackBtn().getY()
                                                        + gp.getHowto1().getBackBtn().getHeight();

                        boolean isInNextBtnArea = e.getX() >= gp.getHowto1().getNextBtn().getX()
                                        && e.getX() <= gp.getHowto1().getNextBtn().getX()
                                                        + gp.getHowto1().getNextBtn().getWidth()
                                        && e.getY() >= gp.getHowto1().getNextBtn().getY()
                                        && e.getY() <= gp.getHowto1().getNextBtn().getY()
                                                        + gp.getHowto1().getNextBtn().getHeight();

                        gp.getHowto1().getBackBtn().setIsHover(isInBackBtnArea);
                        gp.getHowto1().getNextBtn().setIsHover(isInNextBtnArea);
                }

        }
}
