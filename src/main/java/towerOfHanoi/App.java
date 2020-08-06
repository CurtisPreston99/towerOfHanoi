
package towerOfHanoi;

import engine.scene;
import engine.window;

public class App extends window{

    public static void main(String[] args) {
        window.main("towerOfHanoi.App", args);
    }

    @Override
    public void keyUpdate() {

    }

    @Override
    public void mouseClick() {

    }

    @Override
    public void mouseWheel() {
    }

    @Override
    public void settings() {
        size(900,800);
        addScene(new scene(this, "Hanoi"));
        getScene("Hanoi").addEntity(new Hanoi(getScene("Hanoi"),this, "hanoi"), "hanoi");
        addScene(new WelcomeScene(this, "main"));
        selectScene("main");

    }

    @Override
    public void setup() {
        
    }

    @Override
    public void update() {

    }
}
