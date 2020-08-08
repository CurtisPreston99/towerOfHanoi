package towerOfHanoi;

import engine.scene;
import engine.window;
import engine.entity.entity;
import engine.ui.UItheme;
import processing.core.PGraphics;

public class hanoiDone extends entity {
    Hanoi hanoi;
        
    
    public hanoiDone(int x, int y, int sizex, int sizey, scene s, window w, String name,Hanoi ha) {
        super(x, y, sizex, sizey, s, w, name);
        hanoi=ha;
        // TODO Auto-generated constructor stub
    }

    @Override
    public void click() {
        // TODO Auto-generated method stub

    }

    @Override
    public void draw(PGraphics b) {
        int min=(int) (Math.pow(2, hanoi.size)-1);
        b.fill(UItheme.Singleton().c_mid);
        b.rect(x, y, sizex, sizey);

        b.textSize(15);
        b.textAlign(b.CENTER);
        b.fill(UItheme.Singleton().c_text_color);
        b.text("minimum moves: "+String.valueOf(min),x+(sizex/2),y+40);
        b.text("movies: "+String.valueOf(hanoi.moves),x+(sizex/2),y+60);
        if(hanoi.done){
            b.text("done",x+(sizex/2),y+80);
        }

    }

    @Override
    public void key() {
        // TODO Auto-generated method stub

    }

    @Override
    public void update(window arg0) {
        // TODO Auto-generated method stub

    }

}
