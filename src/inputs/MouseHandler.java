package inputs;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import entity.*;

import static constant.Constants.*;

import main.GamePanel;
import screen.ChooseCharacter;
import screen.Credits;
import screen.MenuGame;
import screen.Pause;
import screen.Result;

import static main.GamePanel.GameState;

public class MouseHandler implements MouseListener {
    GamePanel gp;
    MenuGame mg;
    ChooseCharacter cc;
    Result r;
    Pause p;
    Credits cd;

    public MouseHandler(GamePanel gp, MenuGame mg, Result r, ChooseCharacter cc, Pause p, Credits cd) {
        this.gp = gp;
        this.mg = mg;
        this.r = r;
        this.cc = cc;
        this.p = p;
        this.cd = cd;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (GamePanel.GameState == RESULT) {
            boolean yButtonYArea = r.getBackBtn().getY() <= e.getY() &&
                    r.getBackBtn().getY() + r.getBackBtn().getWidth() >= e.getY();

            boolean isInBackButtonArea = e.getX() >= r.getBackBtn().getX()
                    && e.getX() <= r.getBackBtn().getX() + r.getBackBtn().getWidth()
                    && yButtonYArea;

            boolean isInRestartButtonArea = e.getX() >= r.getRestartBtn().getX()
                    && e.getX() <= r.getRestartBtn().getX() + r.getRestartBtn().getWidth()
                    && yButtonYArea;
            if (isInBackButtonArea) {
                GameState = MENU;
                // gp.gameReset();
                GamePanel.stopMusic();
                GamePanel.playMusic(0);
            } else if (isInRestartButtonArea) {
                GameState = SELECT;
                GamePanel.stopMusic();
                GamePanel.playMusic(1);
            }

        } else if (GamePanel.GameState == MENU) {
            boolean yButtonArea = mg.getPlayBtn().getX() <= e.getX() &&
                    mg.getPlayBtn().getX() + mg.getPlayBtn().getWidth() >= e.getX();

            boolean isInPlaybuttonArea = e.getY() >= mg.getPlayBtn().getY()
                    && e.getY() <= mg.getPlayBtn().getY() + mg.getPlayBtn().getHeight()
                    && yButtonArea;

            boolean isInCreditsButtonArea = e.getY() >= mg.getCreditsBtn().getY()
                    && e.getY() <= mg.getCreditsBtn().getY() + mg.getCreditsBtn().getHeight()
                    && yButtonArea;

            boolean isInQuitButtonArea = e.getY() >= mg.getQuitBtn().getY()
                    && e.getY() <= mg.getQuitBtn().getY() + mg.getQuitBtn().getHeight()
                    && yButtonArea;

            if (isInPlaybuttonArea) {
                GamePanel.playSE(7);
                GameState = SELECT;
                GamePanel.stopMusic();
                GamePanel.playMusic(1);
            } else if (isInQuitButtonArea) {
                GamePanel.playSE(7);
                gp.getLeaderboard().writeData();
                System.exit(0);
            } else if (isInCreditsButtonArea) {
                GamePanel.playSE(7);
                GamePanel.GameState = CREDITS;
            }

        }

        else if (GameState == SELECT) {
            // Select

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

            // Page slide methods
            if (isInLeftBtnArea) {
                GamePanel.playSE(7);
                if (cc.getPage() == CAPY)
                    cc.setPage(ZOMBIE);
                else
                    cc.setPage(cc.getPage() - 1);
            } else if (isInRightBtnArea) {
                GamePanel.playSE(7);
                if (cc.getPage() == ZOMBIE) {
                    cc.setPage(CAPY);
                } else {
                    cc.setPage(cc.getPage() + 1);
                }
            } else if (isInBackBtnArea) {
                GamePanel.playSE(7);
                GamePanel.GameState = MENU;
                GamePanel.stopMusic();
                GamePanel.playMusic(0);
            } else if (isInGoBtnArea) {
                int player = cc.getPage();
                switch (player) {
                    case CAPY:
                        gp.setPlayer(new Capybara(gp, CAPY, 150, gp.tileSize * 2, 320, gp.tileSize, gp.tileSize));
                        break;
                    case GHOST:
                        gp.setPlayer(new Ghost(gp, GHOST, 100, gp.tileSize * 2, 320, gp.tileSize, gp.tileSize));
                        break;
                    case ZOMBIE:
                        gp.setPlayer(new Zombie(gp, ZOMBIE, 100, gp.tileSize * 2, 320, gp.tileSize, gp.tileSize));
                        break;
                    case MUSCLE:
                        gp.setPlayer(new Muscle(gp, MUSCLE, 170, gp.tileSize * 2, 320, gp.tileSize, gp.tileSize));
                        break;
                    case NINJA:
                        gp.setPlayer(new Ninja(gp, NINJA, 100, gp.tileSize * 2, 320, gp.tileSize, gp.tileSize));
                        break;
                }
                GamePanel.stopMusic();
                GamePanel.playSE(9);
                gp.gameReset();
                gp.getTile().tileUpdate();
                GameState = PLAYING;
            }
        }

        else if (GameState == PAUSE) {
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

            if (isInResumeBtnArea) {
                GamePanel.playSE(7);
                GamePanel.GameState = PLAYING;
                gp.getMusic().resumeSound();
            } else if (isInBackBtnArea) {
                GamePanel.playSE(7);
                GamePanel.playMusic(0);
                GamePanel.GameState = MENU;
            } else if (isInRestartBtnArea) {
                GamePanel.playSE(7);
                GamePanel.playMusic(1);
                GamePanel.GameState = SELECT;
            }

        } else if (GameState == CREDITS) {
            boolean isInBackBtnArea = e.getX() >= cd.getBackBtn().getX()
                    && e.getX() <= cd.getBackBtn().getX() + cd.getBackBtn().getWidth()
                    && e.getY() >= cd.getBackBtn().getY()
                    && e.getY() <= cd.getBackBtn().getY() + cd.getBackBtn().getHeight();

            if (isInBackBtnArea) {
                GamePanel.playSE(7);
                GamePanel.GameState = MENU;
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
