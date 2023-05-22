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

    public MouseHandler(GamePanel gp) {
        this.gp = gp;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (GamePanel.GameState == RESULT) {
            boolean yButtonYArea = gp.getResult().getBackBtn().getY() <= e.getY() &&
                    gp.getResult().getBackBtn().getY() + gp.getResult().getBackBtn().getWidth() >= e.getY();

            boolean isInBackButtonArea = e.getX() >= gp.getResult().getBackBtn().getX()
                    && e.getX() <= gp.getResult().getBackBtn().getX() + gp.getResult().getBackBtn().getWidth()
                    && yButtonYArea;

            boolean isInRestartButtonArea = e.getX() >= gp.getResult().getRestartBtn().getX()
                    && e.getX() <= gp.getResult().getRestartBtn().getX() + gp.getResult().getRestartBtn().getWidth()
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
            boolean yButtonArea = gp.getMenuGame().getPlayBtn().getY() <= e.getY() &&
                    gp.getMenuGame().getPlayBtn().getY() + gp.getMenuGame().getPlayBtn().getHeight() >= e.getY();

            boolean isInPlaybuttonArea = e.getX() >= gp.getMenuGame().getPlayBtn().getX()
                    && e.getX() <= gp.getMenuGame().getPlayBtn().getX() + gp.getMenuGame().getPlayBtn().getWidth()
                    && yButtonArea;

            boolean isInCreditsButtonArea = e.getX() >= gp.getMenuGame().getCreditsBtn().getX()
                    && e.getX() <= gp.getMenuGame().getCreditsBtn().getX() + gp.getMenuGame().getCreditsBtn().getWidth()
                    && yButtonArea;

            boolean isInQuitButtonArea = e.getX() >= gp.getMenuGame().getQuitBtn().getX()
                    && e.getX() <= gp.getMenuGame().getQuitBtn().getX() + gp.getMenuGame().getQuitBtn().getWidth()
                    && yButtonArea;

            boolean isInScoreButtonArea = e.getX() >= gp.getMenuGame().getScoreBtn().getX()
                    && e.getX() <= gp.getMenuGame().getScoreBtn().getX() + gp.getMenuGame().getScoreBtn().getWidth()
                    && yButtonArea;

            boolean isInHowToButtonArea = e.getX() >= gp.getMenuGame().getHowToBtn().getX()
                    && e.getX() <= gp.getMenuGame().getHowToBtn().getX() + gp.getMenuGame().getHowToBtn().getWidth()
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
            } else if (isInScoreButtonArea) {
                GamePanel.playSE(7);
                GamePanel.GameState = LEADERBOARD;
            } else if (isInHowToButtonArea) {
                GamePanel.playSE(7);
                GamePanel.GameState = HOWTO1;
            }

        }

        else if (GameState == SELECT) {
            boolean isInButtonYArea = gp.getChooseCharacter().getLeftBtn().getY() <= e.getY() &&
                    gp.getChooseCharacter().getLeftBtn().getY() + gp.getChooseCharacter().getLeftBtn().getWidth() >= e
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

            // Page slide methods
            if (isInLeftBtnArea) {
                GamePanel.playSE(7);
                if (gp.getChooseCharacter().getPage() == CAPY)
                    gp.getChooseCharacter().setPage(ZOMBIE);
                else
                    gp.getChooseCharacter().setPage(gp.getChooseCharacter().getPage() - 1);
            } else if (isInRightBtnArea) {
                GamePanel.playSE(7);
                if (gp.getChooseCharacter().getPage() == ZOMBIE) {
                    gp.getChooseCharacter().setPage(CAPY);
                } else {
                    gp.getChooseCharacter().setPage(gp.getChooseCharacter().getPage() + 1);
                }
            } else if (isInBackBtnArea) {
                GamePanel.playSE(7);
                GamePanel.GameState = MENU;
                GamePanel.stopMusic();
                GamePanel.playMusic(0);
            } else if (isInGoBtnArea) {
                int player = gp.getChooseCharacter().getPage();
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
            boolean isInButtonXArea = gp.getPause().getButton()[0].getX() <= e.getX() &&
                    gp.getPause().getButton()[0].getX() + gp.getPause().getButton()[0].getWidth() >= e.getX();

            boolean isInResumeBtnArea = e.getY() >= gp.getPause().getButton()[0].getY()
                    && e.getY() <= gp.getPause().getButton()[0].getY() + gp.getPause().getButton()[0].getHeight()
                    && isInButtonXArea;

            boolean isInBackBtnArea = e.getY() >= gp.getPause().getButton()[1].getY()
                    && e.getY() <= gp.getPause().getButton()[1].getY() + gp.getPause().getButton()[1].getHeight()
                    && isInButtonXArea;

            boolean isInRestartBtnArea = e.getY() >= gp.getPause().getButton()[2].getY()
                    && e.getY() <= gp.getPause().getButton()[2].getY() + gp.getPause().getButton()[2].getHeight()
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
            boolean isInBackBtnArea = e.getX() >= gp.getCredits().getBackBtn().getX()
                    && e.getX() <= gp.getCredits().getBackBtn().getX() + gp.getCredits().getBackBtn().getWidth()
                    && e.getY() >= gp.getCredits().getBackBtn().getY()
                    && e.getY() <= gp.getCredits().getBackBtn().getY() + gp.getCredits().getBackBtn().getHeight();

            if (isInBackBtnArea) {
                GamePanel.playSE(7);
                GamePanel.GameState = MENU;
            }

        } else if (GameState == LEADERBOARD) {
            boolean isInBackBtnArea = e.getX() >= gp.getLeaderboard().getBackBtn().getX()
                    && e.getX() <= gp.getLeaderboard().getBackBtn().getX()
                            + gp.getLeaderboard().getBackBtn().getWidth()
                    && e.getY() >= gp.getLeaderboard().getBackBtn().getY()
                    && e.getY() <= gp.getLeaderboard().getBackBtn().getY()
                            + gp.getLeaderboard().getBackBtn().getHeight();
            if (isInBackBtnArea) {
                GamePanel.playSE(7);
                GamePanel.GameState = MENU;
            }
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

            if (isInBackBtnArea) {
                GamePanel.playSE(7);
                GamePanel.GameState = MENU;
            } else if (isInNextBtnArea) {
                GamePanel.playSE(7);
                GamePanel.GameState = HOWTO2;
            }
        } else if (GameState == HOWTO2) {
            boolean isInBackBtnArea = e.getX() >= gp.getHowto2().getBackBtn().getX()
                    && e.getX() <= gp.getHowto2().getBackBtn().getX()
                            + gp.getHowto2().getBackBtn().getWidth()
                    && e.getY() >= gp.getHowto2().getBackBtn().getY()
                    && e.getY() <= gp.getHowto2().getBackBtn().getY()
                            + gp.getHowto2().getBackBtn().getHeight();

            boolean isInNextBtnArea = e.getX() >= gp.getHowto1().getNextBtn().getX()
                    && e.getX() <= gp.getHowto1().getNextBtn().getX()
                            + gp.getHowto1().getNextBtn().getWidth()
                    && e.getY() >= gp.getHowto1().getNextBtn().getY()
                    && e.getY() <= gp.getHowto1().getNextBtn().getY()
                            + gp.getHowto1().getNextBtn().getHeight();

            if (isInBackBtnArea) {
                GamePanel.playSE(7);
                GamePanel.GameState = HOWTO1;
            } else if (isInNextBtnArea) {
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
