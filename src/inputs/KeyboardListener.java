/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import main.GamePanel;

/**
 *
 * @author ASUS
 */
public class KeyboardListener implements KeyListener{
    private GamePanel gp;
    public KeyboardListener(GamePanel gp){
        this.gp = gp;
    }
    @Override
    public void keyTyped(KeyEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()){
            case KeyEvent.VK_W &
                KeyEvent.VK_SPACE:
                gp.getPlayer().setJump(true);
                break;
            case KeyEvent.VK_S:
                gp.getPlayer().setDown(true);
                break;
//            case KeyEvent.VK_A:
//                gp.getPlayer().setLeft(true);
//                break;
//            case KeyEvent.VK_D:
//                gp.getPlayer().setRight(true);
//                break;
                
                
        }
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void keyReleased(KeyEvent e) {
            switch(e.getKeyCode()){
//            case KeyEvent.VK_SPACE:
//                gp.getPlayer().setJump(false);
//                break;
            case KeyEvent.VK_W:
                gp.getPlayer().setJump(true);
                break;
            case KeyEvent.VK_S:
                gp.getPlayer().setDown(false);
                // gp.getPlayer().slideReset();
                break;
//            case KeyEvent.VK_A:
//                gp.getPlayer().setLeft(false);
//                break;
//            case KeyEvent.VK_D:
//                gp.getPlayer().setRight(false);
//                break;
                
                
        }
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

