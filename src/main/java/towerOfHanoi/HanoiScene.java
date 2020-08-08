package towerOfHanoi;

import engine.scene;
import engine.window;
import engine.ui.button;
import engine.ui.dropdown;

public class HanoiScene extends scene {
    Hanoi h;
    String selected;

    public HanoiScene(window Parrent, String id) {
        super(Parrent, id);
        h = new Hanoi(this, Parrent, "hanoi");
        addEntity(h, "hanoi");
        addEntity(new button(Parrent.width / 10, Parrent.height / 10, 200, 30, "solve", this, Parrent), "solve");
        addEntity(new button(Parrent.width / 10, (Parrent.height / 10) + 60, 200, 30, "reset", this, Parrent), "reset");
        addEntity(new button(Parrent.width - (Parrent.width / 10) - 200, Parrent.height / 10, 200, 30, "home", this,
                Parrent), "home");
        addEntity(
                new hanoiDone((Parrent.width / 2) - 100, Parrent.height / 10, 200, 100, this, Parrent, "hanoiData", h),
                "hanoiDone");
        addEntity(
                new dropdown(Parrent.width - (Parrent.width / 10) - 200, (Parrent.height / 10) + 60, 200, 30,
                        new String[] { "2", "3", "4", "5", "6", "7", "8", "9" ,"10"}, this, Parrent, "drop down test"),
                "sizeDrop");
        ((dropdown) getEntity("sizeDrop")).select(1);

        selected = ((dropdown) getEntity("sizeDrop")).getSelected();
    }

    @Override
    public void tick() {

        if (((button) getEntity("reset")).pressed) {
            ((button) getEntity("reset")).pressed = false;
            h.reset();
        }

        if (((button) getEntity("solve")).pressed) {
            ((button) getEntity("solve")).pressed = false;
            h.solve();
        }

        if (((button) getEntity("home")).pressed) {
            ((button) getEntity("home")).pressed = false;
            Parrent.selectScene("main");
        }

        if (((dropdown) getEntity("sizeDrop")).getSelected() != selected) {
            selected = ((dropdown) getEntity("sizeDrop")).getSelected();
            h.size = Integer.valueOf(selected);
            h.reset();
        }
        // System.out.println(((dropdown) getEntity("sizeDrop")).getSelected());

    }

}
