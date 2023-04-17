
package methods;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.Array;

import javax.imageio.ImageIO;
import main.GamePanel;


public class Utilz {
    public static GamePanel gp;
    public static int tileSize;
    public static BufferedImage[] runningAni;
    public Utilz(GamePanel gp){
        Utilz.gp = gp;
    }
    public static BufferedImage GetImage(String fileName){
        BufferedImage img = null;
        try{
            img = ImageIO.read(Utilz.class.getResourceAsStream(fileName)); 
        }catch(IOException e){
            e.printStackTrace();
        }
        return img;
    }
    public static BufferedImage[] getRunningImg(String fileName){
        BufferedImage img = null;
        try{
            img = ImageIO.read(Utilz.class.getResourceAsStream(fileName)); 
        }catch(IOException e){
            e.printStackTrace();
        }
        runningAni = new BufferedImage[7];
        for(int i=0; i<7; i++){
            runningAni[i] = img.getSubimage(32*i, 2, 32, 32);
        }
        return runningAni;
    }
}
