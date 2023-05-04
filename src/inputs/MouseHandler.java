package inputs;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import constant.Constants;
import entity.Muscle;

import static constant.Constants.*;

import main.GamePanel;
import methods.Animations;
import methods.Utilz;

import static main.GamePanel.GameState;
import tiles.*;

public class MouseHandler implements MouseListener {
    private GamePanel gp;

    public MouseHandler(GamePanel gp) {
        this.gp = gp;

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (GamePanel.GameState == RESULT) {
            boolean yButtonArea = e.getY() >= 290 && e.getY() <= 290 + 50;

            boolean isInBackButtonArea = e.getX() >= 365 && e.getX() <= 365 + 125;

            boolean isInRestartButtonArea = e.getX() >= 787 && e.getX() <= 787 + 125;

            if (isInBackButtonArea && yButtonArea) {
                GamePanel.GameState = MENU;
            } else if (isInRestartButtonArea && yButtonArea) {
                GamePanel.GameState = PLAYING;
            }

        }
        if (GamePanel.GameState == MENU) {
            boolean yButtonArea = e.getX() >= 570 && e.getX() <= 570 + 125;

            boolean isInPlaybuttonArea = e.getY() >= 170 && e.getY() <= 170 + 54;

            boolean isInCreditsButtonArea = e.getY() >= 230 && e.getY() <= 230 + 54;

            boolean isInQuitButtonArea = e.getY() >= 290 && e.getY() <= 290 + 54;

            if (yButtonArea) {
                if (isInPlaybuttonArea) {
                    gp.setPlayer(new Muscle(gp, 100, gp.tileSize * 2, Constants.GROUND, gp.tileSize, gp.tileSize));
                    GamePanel.GameState = PLAYING;
                } else if (isInQuitButtonArea) {
                    System.exit(0);
                } else if (isInCreditsButtonArea) {

                }
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
