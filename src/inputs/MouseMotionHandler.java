package inputs;

import constant.Constants;
import static constant.Constants.*;
import entity.Muscle;
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
        GamePanel gp;
        MenuGame mg;
        Result rs;
        ChooseCharacter cc;
        Pause p;
        Credits cd;

        public MouseMotionHandler(GamePanel gp, MenuGame mg, Result rs, ChooseCharacter cc, Pause p, Credits cd) {
                this.gp = gp;
                this.mg = mg;
                this.rs = rs;
                this.cc = cc;
                this.p = p;
                this.cd = cd;
        }

        @Override
        public void mouseDragged(MouseEvent e) {
        }

        @Override
        public void mouseMoved(MouseEvent e) {

                if (GameState == MENU) {
                        boolean yButtonArea = mg.getPlayBtn().getX() <= e.getX() &&
                                        mg.getPlayBtn().getX() + mg.getPlayBtn().getWidth() >= e.getX();

                        boolean isInPlayButtonArea = e.getY() >= mg.getPlayBtn().getY()
                                        && e.getY() <= mg.getPlayBtn().getY() + mg.getPlayBtn().getHeight()
                                        && yButtonArea;

                        boolean isInCreditsButtonArea = e.getY() >= mg.getCreditsBtn().getY()
                                        && e.getY() <= mg.getCreditsBtn().getY() + mg.getCreditsBtn().getHeight()
                                        && yButtonArea;

                        boolean isInQuitButtonArea = e.getY() >= mg.getQuitBtn().getY()
                                        && e.getY() <= mg.getQuitBtn().getY() + mg.getQuitBtn().getHeight()
                                        && yButtonArea;

                        mg.getPlayBtn().setIsHover(isInPlayButtonArea);
                        mg.getCreditsBtn().setIsHover(isInCreditsButtonArea);
                        mg.getQuitBtn().setIsHover(isInQuitButtonArea);

                } else if (GameState == RESULT) {
                        boolean yButtonArea = rs.getBackBtn().getY() <= e.getY() &&
                                        rs.getBackBtn().getY() + rs.getBackBtn().getWidth() >= e.getY();

                        boolean isInBackButtonArea = e.getX() >= rs.getBackBtn().getX()
                                        && e.getX() <= rs.getBackBtn().getX() + rs.getBackBtn().getWidth()
                                        && yButtonArea;

                        boolean isInRestartButtonArea = e.getX() >= rs.getRestartBtn().getX()
                                        && e.getX() <= rs.getRestartBtn().getX() + rs.getRestartBtn().getWidth()
                                        && yButtonArea;

                        rs.getBackBtn().setIsHover(isInBackButtonArea);
                        rs.getRestartBtn().setIsHover(isInRestartButtonArea);

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

                        boolean isInBackBtnArea = e.getY() >= cc.getBackBtn().getY()
                                        && e.getY() <= cc.getBackBtn().getY() + cc.getBackBtn().getHeight()
                                        && e.getX() >= cc.getBackBtn().getX()
                                        && e.getX() <= cc.getBackBtn().getX() + cc.getBackBtn().getWidth();

                        cc.getLeftBtn().setIsHover(isInLeftBtnArea);
                        cc.getRightBtn().setIsHover(isInRightBtnArea);
                        cc.getGoBtn().setIsHover(isInGoBtnArea);
                        cc.getBackBtn().setIsHover(isInBackBtnArea);

                } else if (GameState == PAUSE) {
                        boolean isInButtonXArea = p.getButton()[0].getX() <= e.getX() &&
                                        p.getButton()[0].getX() + p.getButton()[0].getWidth() >= e.getX();

                        boolean isInResumeBtnArea = e.getY() >= p.getButton()[0].getY()
                                        && e.getY() <= p.getButton()[0].getY() + p.getButton()[0].getHeight()
                                        && isInButtonXArea;

                        boolean isInBackBtnArea = e.getY() >= p.getButton()[1].getY()
                                        && e.getY() <= p.getButton()[1].getY() + p.getButton()[1].getHeight()
                                        && isInButtonXArea;

                        boolean isInRestartBtnArea = e.getY() >= p.getButton()[2].getY()
                                        && e.getY() <= p.getButton()[2].getY() + p.getButton()[2].getHeight()
                                        && isInButtonXArea;

                        p.getButton()[0].setIsHover(isInResumeBtnArea);
                        p.getButton()[1].setIsHover(isInBackBtnArea);
                        p.getButton()[2].setIsHover(isInRestartBtnArea);
                } else if (GameState == CREDITS) {
                        boolean isInBackBtnArea = e.getX() >= cd.getBackBtn().getX()
                                        && e.getX() <= cd.getBackBtn().getX() + cd.getBackBtn().getWidth()
                                        && e.getY() >= cd.getBackBtn().getY()
                                        && e.getY() <= cd.getBackBtn().getY() + cd.getBackBtn().getHeight();
                        cd.getBackBtn().setIsHover(isInBackBtnArea);
                }
        }
}
