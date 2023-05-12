package inputs;

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
import screen.MenuGame;
import screen.Result;

import static main.GamePanel.GameState;
import tiles.*;

public class MouseHandler implements MouseListener {
    private GamePanel gp;
    private MenuGame mg;
    private ChooseCharacter cc;
    private Result r;

    public MouseHandler(GamePanel gp, MenuGame mg, Result r, ChooseCharacter cc) {
        this.gp = gp;
        this.mg = mg;
        this.r = r;
        this.cc = cc;

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (GamePanel.GameState == RESULT) {
            boolean yButtonArea = e.getY() >= 290 && e.getY() <= 290 + 50;

            boolean isInBackButtonArea = e.getX() >= 365 && e.getX() <= 365 + 125;

            boolean isInRestartButtonArea = e.getX() >= 787 && e.getX() <= 787 + 125;
            if (isInBackButtonArea && yButtonArea) {
                GamePanel.GameState = MENU;
                // GamePanel.stopMusic();
                // GamePanel.playMusic(0);
            } else if (isInRestartButtonArea && yButtonArea) {
                gp.gameReset();
                gp.getPlayer().playerReset();
                GamePanel.GameState = PLAYING;
                // GamePanel.stopMusic();
                // GamePanel.playMusic(3);
            }

        }
        if (GamePanel.GameState == MENU) {
            boolean yButtonArea = e.getX() >= 570 && e.getX() <= 570 + 125;

            boolean isInPlaybuttonArea = e.getY() >= 170 && e.getY() <= 170 + 54;

            boolean isInCreditsButtonArea = e.getY() >= 230 && e.getY() <= 230 + 54;

            boolean isInQuitButtonArea = e.getY() >= 290 && e.getY() <= 290 + 54;

            if (yButtonArea) {
                if (isInPlaybuttonArea) {
                    GamePanel.GameState = SELECT;
                } else if (isInQuitButtonArea) {
                    System.exit(0);
                } else if (isInCreditsButtonArea) {

                }
            }

        }

        if (GameState == SELECT) {
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
                if (cc.getPage() == CAPY)
                    cc.setPage(ZOMBIE);
                else
                    cc.setPage(cc.getPage() - 1);
            } else if (isInButtonYArea && isInRightBtnArea) {
                if (cc.getPage() == ZOMBIE) {
                    cc.setPage(CAPY);
                } else {
                    cc.setPage(cc.getPage() + 1);
                }
            } else if (isInGoBtnArea) {
                int player = cc.getPage();
                switch (player) {
                    case CAPY:
                        gp.setPlayer(new Capybara(gp, 100, gp.tileSize * 2, 320, gp.tileSize, gp.tileSize));
                        break;
                    case GHOST:
                        gp.setPlayer(new Ghost(gp, 100, gp.tileSize * 2, 320, gp.tileSize, gp.tileSize));
                        break;
                    case ZOMBIE:
                        gp.setPlayer(new Zombie(gp, 100, gp.tileSize * 2, 320, gp.tileSize, gp.tileSize));
                        break;
                    case MUSCLE:
                        gp.setPlayer(new Muscle(gp, 200, gp.tileSize * 2, 320, gp.tileSize, gp.tileSize));
                        break;
                    case NINJA:
                        gp.setPlayer(new Ninja(gp, 100, gp.tileSize * 2, 320, gp.tileSize, gp.tileSize));
                        break;
                }
                gp.setWp(new WallPattern(gp));
                GameState = PLAYING;
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
