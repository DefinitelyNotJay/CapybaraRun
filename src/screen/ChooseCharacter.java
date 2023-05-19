package screen;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import methods.Animations;
import methods.ScreenTools;
import methods.Utilz;
import static constant.Constants.*;

public class ChooseCharacter implements ScreenTools, Animations {
    private BufferedImage bgImg, frame, skill, name, model, characterFrame, left, right;
    private int page = CAPY;
    private String skillExplain = "";
    private Button btn[];

    public ChooseCharacter() {
        loadImages();
        buttonCreate();
    }

    @Override
    public void loadImages() {
        bgImg = Utilz.GetImage("/res/screen/select/choosecharacterbg.png");
        frame = Utilz.GetImage("/res/screen/select/frame.png");
        skill = Utilz.GetImage("/res/screen/select/skill.png");
        characterFrame = Utilz.GetImage("/res/screen/select/character.png");
        getModelAndNameImage();
    }

    @Override
    public void buttonCreate() {
        btn = new Button[4];
        btn[0] = new Button(520, 270, 75, 70);
        btn[0].setImages("/res/screen/select/left");

        btn[1] = new Button(1011, 270, 75, 70);
        btn[1].setImages("/res/screen/select/right");

        btn[2] = new Button(830, 380, 125, 55);
        btn[2].setImages("/res/screen/select/GO");

        btn[3] = new Button(660, 380, 125, 55);
        btn[3].setImages("/res/screen/select/back");

    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(bgImg, 0, 0, null);
        g.drawImage(frame, 380 + 23, 43, null);
        g.drawImage(characterFrame, -200 + 23, 57, (int) (320 * 3.2), (int) (180 * 2.9), null);
        g.drawImage(name, 563, 80, null);
        g.drawImage(skill, 520, 180, null);
        g.drawImage(model, 228, 195, (int) (878 / 4.7), (int) (986 / 4.7), null);
        btn[0].draw(g);
        btn[1].draw(g);
        btn[2].draw(g);
        btn[3].draw(g);
        g.setFont(new Font("2005_iannnnnCPU", Font.PLAIN, 40));
        g.drawString(skillExplain, 760, 320);
    }

    @Override
    public void updateAnimations() {

    }

    public void update() {
        getModelAndNameImage();

    }

    public void getModelAndNameImage() {
        switch (page) {
            case CAPY:
                model = Utilz.GetImage("/res/screen/select/characters/capy.png");
                name = Utilz.GetImage("/res/screen/select/characters/name_capy.png");
                skillExplain = "คาปิบาร่าสุดน่ารัก";

                break;
            case ZOMBIE:
                model = Utilz.GetImage("/res/screen/select/characters/zombie.png");
                name = Utilz.GetImage("/res/screen/select/characters/name_zombie.png");
                skillExplain = "ซอมบี้คาปี้ 5 ชีวิต";
                break;
            case NINJA:
                model = Utilz.GetImage("/res/screen/select/characters/ninja.png");
                name = Utilz.GetImage("/res/screen/select/characters/name_ninja.png");
                skillExplain = "นินจาฟาดฟันกำแพง";
                break;
            case MUSCLE:
                model = Utilz.GetImage("/res/screen/select/characters/muscle.png");
                name = Utilz.GetImage("/res/screen/select/characters/name_muscle.png");
                skillExplain = "ฟื้นฟูเลือดนักกล้าม";
                break;
            case GHOST:
                model = Utilz.GetImage("/res/screen/select/characters/ghost.png");
                name = Utilz.GetImage("/res/screen/select/characters/name_ghost.png");
                skillExplain = "คาปี้ผีหนีกำแพง";
                break;
        }
    }

    public Button getLeftBtn() {
        return btn[0];
    }

    public Button getRightBtn() {
        return btn[1];
    }

    public BufferedImage getLeft() {
        return left;
    }

    public Button getGoBtn() {
        return btn[2];
    }

    public Button getBackBtn() {
        return btn[3];
    }

    public void setLeft(BufferedImage left) {
        this.left = left;
    }

    public BufferedImage getRight() {
        return right;
    }

    public void setRight(BufferedImage right) {
        this.right = right;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

}
