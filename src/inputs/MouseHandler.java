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
            if (gp.getResult().isInButton(e.getX(), e.getY(), 0)) {
                GameState = MENU;
                GamePanel.stopMusic();
                GamePanel.playMusic(0);
            } else if (gp.getResult().isInButton(e.getX(), e.getY(), 1)) {
                GameState = SELECT;
                GamePanel.stopMusic();
                GamePanel.playMusic(1);
            }

        } else if (GamePanel.GameState == MENU) {
            if (gp.getMenuGame().isInButton(e.getX(), e.getY(), 1)) {
                GamePanel.playSE(7);
                GameState = SELECT;
                GamePanel.stopMusic();
                GamePanel.playMusic(1);
            } else if (gp.getMenuGame().isInButton(e.getX(), e.getY(), 2)) {
                GamePanel.playSE(7);
                gp.getLeaderboard().writeData();
                System.exit(0);
            } else if (gp.getMenuGame().isInButton(e.getX(), e.getY(), 0)) {
                GamePanel.playSE(7);
                GamePanel.GameState = CREDITS;
            } else if (gp.getMenuGame().isInButton(e.getX(), e.getY(), 3)) {
                GamePanel.playSE(7);
                GamePanel.GameState = LEADERBOARD;
            } else if (gp.getMenuGame().isInButton(e.getX(), e.getY(), 4)) {
                GamePanel.playSE(7);
                GamePanel.GameState = HOWTO1;
            }

        }

        else if (GameState == SELECT) {

            // Page slide methods
            if (gp.getChooseCharacter().isInButton(e.getX(), e.getY(), 0)) {
                GamePanel.playSE(7);
                if (gp.getChooseCharacter().getPage() == CAPY)
                    gp.getChooseCharacter().setPage(ZOMBIE);
                else
                    gp.getChooseCharacter().setPage(gp.getChooseCharacter().getPage() - 1);
            } else if (gp.getChooseCharacter().isInButton(e.getX(), e.getY(), 1)) {
                GamePanel.playSE(7);
                if (gp.getChooseCharacter().getPage() == ZOMBIE) {
                    gp.getChooseCharacter().setPage(CAPY);
                } else {
                    gp.getChooseCharacter().setPage(gp.getChooseCharacter().getPage() + 1);
                }
            } else if (gp.getChooseCharacter().isInButton(e.getX(), e.getY(), 3)) {
                GamePanel.playSE(7);
                GamePanel.GameState = MENU;
                GamePanel.stopMusic();
                GamePanel.playMusic(0);
            } else if (gp.getChooseCharacter().isInButton(e.getX(), e.getY(), 2)) {
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

            if (gp.getPause().isInButton(e.getX(), e.getY(), 0)) {
                GamePanel.playSE(7);
                GamePanel.GameState = PLAYING;
                gp.getMusic().resumeSound();
            } else if (gp.getPause().isInButton(e.getX(), e.getY(), 1)) {
                GamePanel.playSE(7);
                GamePanel.playMusic(0);
                GamePanel.GameState = MENU;
            } else if (gp.getPause().isInButton(e.getX(), e.getY(), 2)) {
                GamePanel.playSE(7);
                GamePanel.playMusic(1);
                GamePanel.GameState = SELECT;
            }

        } else if (GameState == CREDITS) {
            if (gp.getCredits().isInButton(e.getX(), e.getY(), 0)) {
                GamePanel.playSE(7);
                GamePanel.GameState = MENU;
            }

        } else if (GameState == LEADERBOARD) {
            if (gp.getLeaderboard().isInButton(e.getX(), e.getY())) {
                GamePanel.playSE(7);
                GamePanel.GameState = MENU;
            }
        } else if (GameState == HOWTO1) {
            if (gp.getHowto1().isInButton(e.getX(), e.getY(), 0)) {
                GamePanel.playSE(7);
                GamePanel.GameState = MENU;
            } else if (gp.getHowto1().isInButton(e.getX(), e.getY(), 1)) {
                GamePanel.playSE(7);
                GamePanel.GameState = HOWTO2;
            }
        } else if (GameState == HOWTO2) {

            if (gp.getHowto2().isInButton(e.getX(), e.getY(), 0)) {
                GamePanel.playSE(7);
                GamePanel.GameState = HOWTO1;
            } else if (gp.getHowto2().isInButton(e.getX(), e.getY(), 1)) {
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
