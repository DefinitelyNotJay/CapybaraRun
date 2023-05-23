package screen;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Comparator;

import static constant.Constants.*;

import main.GamePanel;
import methods.ScreenTools;
import methods.Utilz;

public class Leaderboard implements ScreenTools {
    private GamePanel gp;
    private Button btn;
    private ArrayList<Score> allScore;
    private BufferedImage bgImg;

    public Leaderboard(GamePanel gp) {
        this.gp = gp;
        allScore = new ArrayList<Score>();
        buttonCreate();
        loadImages();
    }

    public void writeData() {
        try {
            FileOutputStream fOut = new FileOutputStream("score.capy");
            ObjectOutputStream oOs = new ObjectOutputStream(fOut);
            oOs.writeObject(allScore);
            oOs.close();
            fOut.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            allScore.sort(Comparator.comparing(Score::getScore, Comparator.reverseOrder()));
        }
    }

    public void readData() {
        try {
            FileInputStream fIn = new FileInputStream("score.capy");
            ObjectInputStream oIs = new ObjectInputStream(fIn);
            Object obj = oIs.readObject();
            allScore = (ArrayList<Score>) obj;
            oIs.close();
            fIn.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            allScore.sort(Comparator.comparing(Score::getScore, Comparator.reverseOrder()));
        }
    }

    public void addData(Score score) {
        if (allScore.size() >= 1)
            if (score.getScore() > allScore.get(allScore.size() - 1).getScore() && allScore.size() > 6) {
                allScore.remove(allScore.size() - 1);
            }
        allScore.add(score);
        allScore.sort(Comparator.comparing(Score::getScore, Comparator.reverseOrder()));
    }

    @Override
    public void loadImages() {
        bgImg = Utilz.GetImage("/res/screen/Leaderboard/Score.png");
    }

    @Override
    public void buttonCreate() {
        btn = new Button(550, 440, 154, 55);

        btn.setImages("/res/screen/Leaderboard/back");
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(bgImg, 0, 0, null);
        g.setFont(new Font("Arcade Normal", Font.PLAIN, gp.tileSize / 4));
        g.setColor(Color.BLACK);
        if (allScore.size() > 0)
            for (int i = 0; i < allScore.size(); i++) {
                int y = 150 + (i * 40);
                g.drawString((i + 1) + "", 200, y);
                g.drawString(allScore.get(i).getDate(), 300, y);
                g.drawString(convertCharacter(allScore.get(i).getCharacter()), 700, y);
                g.drawString(allScore.get(i).getScore() + "", 900, y);
            }
        btn.draw(g);

    }

    public String convertCharacter(int num) {
        String result = "";
        switch (num) {
            case CAPY:
                result = "Capy";
                break;
            case ZOMBIE:
                result = "Zombie";
                break;
            case GHOST:
                result = "Ghost";
                break;
            case MUSCLE:
                result = "Muscle";
                break;
            case NINJA:
                result = "Ninja";
                break;
        }
        return result;
    }

    public boolean isInButton(int x, int y, int num) {
        return x >= btn.getX() && x <= btn.getX() + btn.getWidth()
                && y >= btn.getY() && y <= btn.getY() + btn.getHeight();
    }

    public boolean isInButton(int x, int y) {
        return x >= btn.getX() && x <= btn.getX() + btn.getWidth()
                && y >= btn.getY() && y <= btn.getY() + btn.getHeight();
    }

    public Button getBackBtn() {
        return btn;
    }

    public ArrayList<Score> getAllScore() {
        return allScore;
    }

}
