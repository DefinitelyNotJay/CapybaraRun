/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.awt.Color;
import java.awt.Graphics;
import main.GamePanel;

public class WallGround extends Wall {

    public WallGround(GamePanel gp, double x, double y, int sizeX, int sizeY) {
        super(gp, x, y, sizeX, sizeY);
    }

    @Override
    public void crash() {
        if (gp.getPlayer().x >= this.x && gp.getPlayer().x <= this.x + width) {
            if (gp.getPlayer().y+gp.getPlayer().getHeight() >= this.y + height) {
                System.out.println("Hit");
            }

        } else {

        }
    }

    @Override
    public void draw(Graphics g2) {
        g2.setColor(Color.black);
        g2.fillRect((int) x, (int) y, width, height);
    }

}
