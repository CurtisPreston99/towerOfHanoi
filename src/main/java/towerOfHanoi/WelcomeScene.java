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
