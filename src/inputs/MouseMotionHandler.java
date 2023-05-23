package inputs;

import static constant.Constants.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import main.GamePanel;
import static main.GamePanel.GameState;

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
                        gp.getMenuGame().getPlayBtn().setIsHover(gp.getMenuGame().isInButton(e.getX(), e.getY(), 1));
                        gp.getMenuGame().getCreditsBtn().setIsHover(gp.getMenuGame().isInButton(e.getX(), e.getY(), 0));
                        gp.getMenuGame().getQuitBtn().setIsHover(gp.getMenuGame().isInButton(e.getX(), e.getY(), 2));
                        gp.getMenuGame().getScoreBtn().setIsHover(gp.getMenuGame().isInButton(e.getX(), e.getY(), 3));
                        gp.getMenuGame().getHowToBtn().setIsHover(gp.getMenuGame().isInButton(e.getX(), e.getY(), 4));

                } else if (GameState == RESULT) {
                        gp.getResult().getBackBtn().setIsHover(gp.getResult().isInButton(e.getX(), e.getY(), 0));
                        gp.getResult().getRestartBtn().setIsHover(gp.getResult().isInButton(e.getX(), e.getY(), 1));
                } else if (GameState == SELECT) {
                        gp.getChooseCharacter().getLeftBtn()
                                        .setIsHover(gp.getChooseCharacter().isInButton(e.getX(), e.getY(), 0));
                        gp.getChooseCharacter().getRightBtn()
                                        .setIsHover(gp.getChooseCharacter().isInButton(e.getX(), e.getY(), 1));
                        gp.getChooseCharacter().getGoBtn()
                                        .setIsHover(gp.getChooseCharacter().isInButton(e.getX(), e.getY(), 2));
                        gp.getChooseCharacter().getBackBtn()
                                        .setIsHover(gp.getChooseCharacter().isInButton(e.getX(), e.getY(), 3));

                } else if (GameState == PAUSE) {
                        gp.getPause().getButton()[0].setIsHover(gp.getPause().isInButton(e.getX(), e.getY(), 0));
                        gp.getPause().getButton()[1].setIsHover(gp.getPause().isInButton(e.getX(), e.getY(), 1));
                        gp.getPause().getButton()[2].setIsHover(gp.getPause().isInButton(e.getX(), e.getY(), 2));
                } else if (GameState == CREDITS) {
                        gp.getCredits().getBackBtn().setIsHover(gp.getCredits().isInButton(e.getX(), e.getY(), 0));
                } else if (GameState == LEADERBOARD) {
                        gp.getLeaderboard().getBackBtn()
                                        .setIsHover(gp.getLeaderboard().isInButton(e.getX(), e.getY(), 0));
                } else if (GameState == HOWTO1) {
                        gp.getHowto1().getBackBtn().setIsHover(gp.getHowto1().isInButton(e.getX(), e.getY(), 0));
                        gp.getHowto1().getNextBtn().setIsHover(gp.getHowto1().isInButton(e.getX(), e.getY(), 1));
                } else if (GameState == HOWTO2) {
                        gp.getHowto2().getBackBtn().setIsHover(gp.getHowto1().isInButton(e.getX(), e.getY(), 0));
                        gp.getHowto2().getMenuBtn().setIsHover(gp.getHowto1().isInButton(e.getX(), e.getY(), 1));
                }

        }
}
