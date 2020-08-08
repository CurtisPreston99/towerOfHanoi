package towerOfHanoi;

import engine.scene;
import engine.window;
import engine.ui.UIelement;
import processing.core.PGraphics;

public class text extends UIelement {

    public text(int x, int y, int sizex, int sizey, scene s, window w, String name) {
        super(x, y, sizex, sizey, s, w, name);
    }

    @Override
    public void draw(PGraphics b) {
        b.textSize(30);
        b.textAlign(b.CENTER);
        b.text(name,x,y);
        b.textSize(10);
    }

    @Override
    public void ValUpdate() {
        // TODO Auto-generated method stub

    }

    @Override
    public void key() {
        // TODO Auto-generated method stub

    }

}
