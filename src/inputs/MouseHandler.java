package inputs;

import java.awt.Menu;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import constant.Constants;
import entity.*;

import static constant.Constants.*;

import main.GamePanel;
import methods.Animations;
import methods.Utilz;
import obstacles.WallPattern;
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
            boolean yButtonArea = e.getY() >= 290 && e.getY() <= 290 + 50;

            boolean isInBackButtonArea = e.getX() >= 365 && e.getX() <= 365 + 125;

            boolean isInRestartButtonArea = e.getX() >= 787 && e.getX() <= 787 + 125;
            if (isInBackButtonArea && yButtonArea) {
                GameState = MENU;
                // gp.gameReset();
                GamePanel.stopMusic();
                GamePanel.playMusic(0);
            } else if (isInRestartButtonArea && yButtonArea) {
                GameState = SELECT;
                GamePanel.stopMusic();
                GamePanel.playMusic(1);
            }

        } else if (GamePanel.GameState == MENU) {
            boolean yButtonArea = e.getX() >= 570 && e.getX() <= 570 + 125;

            boolean isInPlaybuttonArea = e.getY() >= 170 && e.getY() <= 170 + 54;

            boolean isInCreditsButtonArea = e.getY() >= 230 && e.getY() <= 230 + 54;

            boolean isInQuitButtonArea = e.getY() >= 290 && e.getY() <= 290 + 54;

            if (yButtonArea) {
                if (isInPlaybuttonArea) {
                    GamePanel.playSE(7);
                    GameState = SELECT;
                    GamePanel.stopMusic();
                    GamePanel.playMusic(1);
                } else if (isInQuitButtonArea) {
                    GamePanel.playSE(7);
                    System.exit(0);
                } else if (isInCreditsButtonArea) {
                    GamePanel.playSE(7);
                    GamePanel.GameState = CREDITS;
                }
            }
        }

        else if (GameState == SELECT) {
            // Select

            boolean isInButtonYArea = cc.getLeftBtn().getY() <= e.getY() &&
                    cc.getLeftBtn().getY() + cc.getLeftBtn().getWidth() >= e.getY();

            boolean isInLeftBtnArea = e.getX() >= cc.getLeftBtn().getX()
                    && e.getX() <= cc.getLeftBtn().getX() + cc.getLeftBtn().getWidth();

            boolean isInRightBtnArea = e.getX() >= cc.getRightBtn().getX()
                    && e.getX() <= cc.getRightBtn().getX() + cc.getRightBtn().getWidth();

            boolean isInGoBtnArea = e.getY() >= cc.getGoBtn().getY()
                    && e.getY() <= cc.getGoBtn().getY() + cc.getGoBtn().getHeight()
                    && cc.getGoBtn().getX() >= cc.getGoBtn().getX()
                    && e.getX() <= cc.getGoBtn().getX() + cc.getGoBtn().getWidth();

            // Page slide methods
            if (isInButtonYArea && isInLeftBtnArea) {
                GamePanel.playSE(7);
                if (cc.getPage() == CAPY)
                    cc.setPage(ZOMBIE);
                else
                    cc.setPage(cc.getPage() - 1);
            } else if (isInButtonYArea && isInRightBtnArea) {
                GamePanel.playSE(7);
                if (cc.getPage() == ZOMBIE) {
                    cc.setPage(CAPY);
                } else {
                    cc.setPage(cc.getPage() + 1);
                }
            } else if (isInGoBtnArea) {
                int player = cc.getPage();
                switch (player) {
                    case CAPY:
                        gp.setPlayer(new Capybara(gp, CAPY, 100, gp.tileSize * 2, 320, gp.tileSize, gp.tileSize));
                        break;
                    case GHOST:
                        gp.setPlayer(new Ghost(gp, GHOST, 100, gp.tileSize * 2, 320, gp.tileSize, gp.tileSize));
                        break;
                    case ZOMBIE:
                        gp.setPlayer(new Zombie(gp, ZOMBIE, 100, gp.tileSize * 2, 320, gp.tileSize, gp.tileSize));
                        break;
                    case MUSCLE:
                        gp.setPlayer(new Muscle(gp, MUSCLE, 200, gp.tileSize * 2, 320, gp.tileSize, gp.tileSize));
                        break;
                    case NINJA:
                        gp.setPlayer(new Ninja(gp, NINJA, 100, gp.tileSize * 2, 320, gp.tileSize, gp.tileSize));
                        break;
                }
                GamePanel.playSE(9);
                gp.gameReset();
                GamePanel.stopMusic();
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
                GamePanel.GameState = PLAYING;
                gp.getMusic().resumeSound();
            } else if (isInBackBtnArea) {
                GamePanel.playMusic(0);
                GamePanel.GameState = MENU;
            } else if (isInRestartBtnArea) {
                GamePanel.playMusic(1);
                GamePanel.GameState = SELECT;
            }

        } else if (GameState == CREDITS) {
            boolean isInBackBtnArea = e.getX() >= cd.getBackBtn().getX()
                    && e.getX() <= cd.getBackBtn().getX() + cd.getBackBtn().getWidth()
                    && e.getY() >= cd.getBackBtn().getY()
                    && e.getY() <= cd.getBackBtn().getY() + cd.getBackBtn().getHeight();

            if (isInBackBtnArea) {
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
