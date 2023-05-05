package screen;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import entity.Entity;
import methods.Utilz;

public class Button extends Entity {
    private double width, height;
    public boolean isHover = false;
    public BufferedImage defaultPic, hoverPic;

    public Button(int x, int y, double width, double height) {
        super(x, y);
        this.width = width;
        this.height = height;

    }

    public void setImages(String fileName) {
        defaultPic = Utilz.GetImage(fileName + ".png");
        // hoverPic = Utilz.GetImage(fileName + "_hover" + ".png");

    }

    public BufferedImage getImage() {
        if (isHover) {
            return hoverPic;
        } else {
            return defaultPic;
        }
    }

    public void draw(Graphics g) {
        g.drawImage(getImage(), x, y, (int) width, (int) height, null);
    }
}
