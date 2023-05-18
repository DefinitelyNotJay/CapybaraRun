package screen;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import entity.Entity;
import methods.Utilz;

public class Button extends Entity {
    private double width, height;
    private boolean isHover = false;
    private BufferedImage defaultPic, hoverPic;

    public Button(int x, int y, double width, double height) {
        super(x, y);
        this.width = width;
        this.height = height;

    }

    public void setImages(String fileName) {
        defaultPic = Utilz.GetImage(fileName + ".png");
        try {
            hoverPic = ImageIO.read(getClass().getResourceAsStream(fileName + "_hover.png"));
        } catch (IOException ex) {
            hoverPic = Utilz.GetImage(fileName + ".png");
        }
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

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public boolean isIsHover() {
        return isHover;
    }

    public void setIsHover(boolean isHover) {
        this.isHover = isHover;
    }

    public BufferedImage getDefaultPic() {
        return defaultPic;
    }

    public void setDefaultPic(BufferedImage defaultPic) {
        this.defaultPic = defaultPic;
    }

    public BufferedImage getHoverPic() {
        return hoverPic;
    }

    public void setHoverPic(BufferedImage hoverPic) {
        this.hoverPic = hoverPic;
    }

}
