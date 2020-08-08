package towerOfHanoi;

import engine.scene;
import engine.window;
import engine.ui.button;
import engine.ui.slider;

public class WelcomeScene extends scene {
    Hanoi hanoi;

    public WelcomeScene(window Parrent, String id) {
        super(Parrent, id);
        hanoi = (Hanoi) Parrent.getScene("Hanoi").getEntity("hanoi");

        addUIEntity(new button((Parrent.width / 2) - 300, Parrent.height / 2, 200, 20, "play", this, Parrent),
                "playButton");
        addUIEntity(new button((Parrent.width / 2) + 100, Parrent.height / 2, 200, 20, "exit", this, Parrent),
                "exitButton");

        addUIEntity(new text(Parrent.width/2, (Parrent.height / 2)-100, 200, 20,  this, Parrent,"Towers of Hanoi"),
                "title");
    }

    

    @Override
    public void tick() {

        if (((button) getUIEntity("playButton")).pressed) {
            ((button) getUIEntity("playButton")).pressed = false;
            hanoi.reset();
            Parrent.selectScene("Hanoi");
        }
    }

}
