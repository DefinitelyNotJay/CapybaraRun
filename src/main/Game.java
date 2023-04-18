package main;

public class Game implements Runnable{
    GameWindow gameWindow;
    GamePanel gamePanel;
    private final int FPS = 60;
    private final int UPS = 70;
    
    public Game(){
       
        gamePanel = new GamePanel();
        gameWindow = new GameWindow(gamePanel);
        startGameLoop();
        
    }

    
    public void startGameLoop(){
        Thread gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run(){
        double timePerFrame = 1000000000/FPS;
        double timePerUpdate = 1000000000/UPS;
        long previousTime = System.nanoTime();
        long lastCheck = System.currentTimeMillis();
        double deltaF = 0;
        double deltaU = 0;
        while(true){
            long currentTime = System.nanoTime();
            deltaF += (currentTime-previousTime)/timePerFrame;
            deltaU += (currentTime-previousTime)/timePerUpdate;
            if(deltaF>=1){
//                  repaint();
                  gamePanel.repaint();
                  deltaF--;
            }
            if(deltaU >= 1){
                gamePanel.update();
                deltaU--;
            }
            previousTime = currentTime;
            if(System.currentTimeMillis()-lastCheck>1000){
                lastCheck = System.currentTimeMillis();
                gamePanel.updateEverySec();
                System.out.println(gamePanel.getPlayer().getHP());

            }
        }
    }
}
