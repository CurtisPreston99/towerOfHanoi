
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
        addScene(new scene(this, "test"));
        selectScene("test");
        getSelectedScene().addEntity(new Hanoi(getSelectedScene(),this, "hanoi"), "hanoi");
        println(this.dataPath(""));

    }

    @Override
    public void setup() {
        
    }

    @Override
    public void update() {

    }
}
