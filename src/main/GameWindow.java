package main;

import javax.swing.*;


public class GameWindow {
    private JFrame jframe;
    private GamePanel gamePanel;
    public GameWindow(GamePanel gamePanel){
        jframe = new JFrame();
        this.gamePanel = gamePanel;
        jframe.add(gamePanel);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setLocationRelativeTo(null);
        jframe.setResizable(false);
        jframe.pack();
        jframe.setLocation(0, 50);
        gamePanel.requestFocus();
        jframe.setVisible(true);
        //gamePanel.setUpGame();
    }
}
