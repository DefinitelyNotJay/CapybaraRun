package methods;

import java.awt.Graphics;

public interface ScreenTools {
    public void loadImages();

    public void buttonCreate();

    public boolean isInButton(int x, int y, int num);

    public void paint(Graphics g);
}
