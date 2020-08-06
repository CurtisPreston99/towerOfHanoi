package towerOfHanoi;

import engine.scene;
import engine.window;
import engine.ui.UIelement;
import engine.ui.UItheme;
import engine.ui.slider;
import processing.core.PGraphics;

public class HanoiData extends UIelement {
    Hanoi h;
    public HanoiData(Hanoi ha,int x, int y, int sizex, int sizey, scene s, window w, String name) {
        super(x, y, sizex, sizey, s, w, name);
        h=ha;
    }

    @Override
    public void ValUpdate() {

    }

    @Override
    public void draw(PGraphics b) {
        b.fill(UItheme.Singleton().c_text_color);
        b.textAlign(b.CENTER);

        if(h.moves>0){
            b.text("moves :"+String.valueOf(h.moves),x+(sizex/2),y);
        }

        b.text("minimum moves :"+String.valueOf((int)Math.pow(2, h.size)-1),x+(sizex/2),y+14);
        b.text("disks :"+String.valueOf(h.size),x+(sizex/2),y+28);
        b.text("slider :"+String.valueOf(((int)((slider)s.getUIEntity("diskSlider")).getVal())),x+(sizex/2),y+42);
        b.textAlign(b.CORNER);   
    }

    @Override
    public void key() {

    }

}
