package inputs;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import main.GamePanel;

public class WindowHandler implements WindowListener {
    private GamePanel gp;

    public WindowHandler(GamePanel gp) {
        this.gp = gp;
    }

    @Override
    public void windowOpened(WindowEvent e) {
        gp.getLeaderboard().readData();
        System.out.println(gp.getLeaderboard().getAllScore().toString());
    }

    @Override
    public void windowClosing(WindowEvent e) {
        gp.getLeaderboard().writeData();
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

}
