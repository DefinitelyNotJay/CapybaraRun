package screen;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.UTFDataFormatException;

import methods.Animations;
import methods.ScreenTools;
import methods.Utilz;

public class ChooseCharacter implements ScreenTools, Animations {
    private BufferedImage bgImg, frame, skill, name, model, characterFrame;
    private final int CAPY = 0, GHOST = 1, MUSCLE = 2, NINJA = 3, ZOMBIE = 4;
    private int page = 1;

    public ChooseCharacter() {
        loadImages();
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

    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(bgImg, 0, 0, null);
        g.drawImage(frame, 380 + 23, 43, null);
        g.drawImage(characterFrame, -200 + 23, 57, (int) (320 * 3.2), (int) (180 * 2.9), null);
        g.drawImage(name, 563, 80, null);
        g.drawImage(model, 240, 190, (int) (2560 / 12), (int) (1440 / 12), null);
    }

    @Override
    public void updateAnimations() {

    }

    public void getModelAndNameImage() {
        switch (page) {
            case CAPY:
                model = Utilz.GetImage("/res/screen/select/characters/1_capy_sample.png");
                name = Utilz.GetImage("/res/screen/select/characters/name_capy.png");
                break;
            case ZOMBIE:
                model = Utilz.GetImage("/res/screen/select/characters/5_zombie.png");
                name = Utilz.GetImage("/res/screen/select/characters/name_zombie.png");
                break;
            case NINJA:
                model = Utilz.GetImage("/res/screen/select/characters/4_ninja.png");
                name = Utilz.GetImage("/res/screen/select/characters/name_ninja.png");
                break;
            case MUSCLE:
                model = Utilz.GetImage("/res/screen/select/characters/3_muscle.png");
                name = Utilz.GetImage("/res/screen/select/characters/name_muscle.png");
                break;
            case GHOST:
                model = Utilz.GetImage("/res/screen/select/characters/2_ghost.png");
                name = Utilz.GetImage("/res/screen/select/characters/name_ghost.png");
                break;

        }
    }

}
