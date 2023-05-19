package main;

import javax.swing.*;

import inputs.WindowHandler;

public class GameWindow {
    private JFrame frame;
    private GamePanel gamePanel;

    public GameWindow(GamePanel gamePanel) {
        frame = new JFrame();
        this.gamePanel = gamePanel;
        frame.add(gamePanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setLocation(0, 50);
        frame.addWindowListener(new WindowHandler(gamePanel));
        gamePanel.requestFocus();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    public JFrame getFrame() {
        return frame;
    }
}
