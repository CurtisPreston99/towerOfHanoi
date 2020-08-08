package towerOfHanoi;

import java.util.ArrayList;

import engine.scene;
import engine.window;
import engine.entity.entity;
import engine.input.mouse;
import processing.core.PGraphics;

class Hanoi extends entity {
    ArrayList<ArrayList<Integer>> disks;
    int size = 3;
    int moves = 0;
    boolean carry = false;
    int carrySize = 0;
    int from = 0;
    boolean done = false;

    boolean solving = false;
    int place = 0;
    ArrayList<int[]> solvingM;
    int MoveSpeed = 10;

    public Hanoi(scene s, window w, String name) {
        super(0, 0, w.width, w.height, s, w, name);
        reset();
    }

    void reset() {
        disks = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> t = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            t.add(i);
        }
        disks.add(t);
        disks.add(new ArrayList<>());
        disks.add(new ArrayList<>());
        moves = 0;
        carry = false;
        done = false;
        solving = false;

    }

    @Override
    public void click() {
        mouse m = w.input.Mouse;
        int y = m.Y();
        if (!solving && y > w.height / 4 && !done) {
            // if (true) {

            if (m.left) {
                if (m.X() < (w.width / 8) * 3 && disks.get(0).size() > 0) {
                    carry = true;
                    from = 0;
                    carrySize = disks.get(0).get(0);
                    disks.get(0).remove(0);
                }
                if (m.X() >= (w.width / 8) * 3 && m.X() <= (w.width / 8) * 5 && disks.get(1).size() > 0) {
                    carry = true;
                    from = 1;
                    carrySize = disks.get(1).get(0);
                    disks.get(1).remove(0);
                }
                if (m.X() > (w.width / 8) * 5 && disks.get(2).size() > 0) {
                    carry = true;
                    from = 2;
                    carrySize = disks.get(2).get(0);
                    disks.get(2).remove(0);
                }

            } else if (carry) {
                int too = 0;
                if (m.X() < (w.width / 8) * 3) {
                    too = 0;
                }
                if (m.X() >= (w.width / 8) * 3 && m.X() <= (w.width / 8) * 5) {
                    too = 1;
                }
                if (m.X() > (w.width / 8) * 5) {
                    too = 2;
                }
                carry = false;

                if (disks.get(too).size() == 0 || disks.get(too).get(0) > carrySize && too != from) {
                    moves++;
                    disks.get(too).add(0, carrySize);
                } else {
                    disks.get(from).add(0, carrySize);
                }

            }

        }

    }

    @Override
    public void draw(PGraphics b) {
        b.rectMode(b.CORNER);

        int poleWidth = 10;
        // poles
        b.rect((b.width / 4) - poleWidth / 2, b.height / 4, poleWidth, (b.height / 4) * 3);
        b.rect((b.width / 2) - poleWidth / 2, b.height / 4, poleWidth, (b.height / 4) * 3);
        b.rect(((b.width / 4) * 3) - poleWidth / 2, b.height / 4, poleWidth, (b.height / 4) * 3);
        // base
        b.rect(0, b.height - poleWidth, b.width, poleWidth);

        b.rectMode(b.CENTER);
        // disks
        int diskWidth = 20;
        for (int i = 0; i < disks.size(); i++) {
            ArrayList<Integer> pole = disks.get(i);
            for (int e = 0; e < pole.size(); e++) {
                switch (i) {
                    case 0:
                        b.rect(b.width / 4, b.height - ((pole.size() - e) * diskWidth), (pole.get(e) + 1) * diskWidth,
                                diskWidth);
                        break;
                    case 1:
                        b.rect(b.width / 2, b.height - ((pole.size() - e) * diskWidth), (pole.get(e) + 1) * diskWidth,
                                diskWidth);
                        break;
                    case 2:
                        b.rect((b.width / 4) * 3, b.height - ((pole.size() - e) * diskWidth),
                                (pole.get(e) + 1) * diskWidth, diskWidth);
                        break;

                    default:
                        break;
                }
            }
        }

        if (carry) {
            int x = w.input.Mouse.X();
            int y = w.input.Mouse.Y();
            b.rect(x, y, (carrySize + 1) * diskWidth, diskWidth);
        }
        b.rectMode(b.CORNER);

    }

    public boolean complete(ArrayList<ArrayList<Integer>> d) {
        // last peg check
        ArrayList<Integer> baseLine = new ArrayList<Integer>();
        for (int i = 0; i < size; i++) {
            baseLine.add(i);
        }
        // first two poles empty and 3rd has all disks in order
        return (d.get(0).size() == 0 && d.get(1).size() == 0 && d.get(2).equals(baseLine));

    }

    public void solve() {
        if (!solving) {
            long start = System.currentTimeMillis();
            w.print("start");
            solvingM = HanoiSolver.solve((ArrayList<ArrayList<Integer>>) disks.clone(), size);
            long after = System.currentTimeMillis();

            System.out.println(solvingM.size());
            System.out.println(after - start);
            solving = true;
            place = 0;
        }
    }

    public Boolean solveStep() {
        if (solving) {
            int[] p = solvingM.get(place);
            // System.out.println("-");
            // win.printArray(p);
            // System.out.println("-");
            HanoiSolver.swap(p[0], p[1], disks);
            // System.out.println(place);
            moves++;
            place++;
            if (place >= solvingM.size()) {
                solving = false;
            }
        }
        return solving;
    }

    @Override
    public void key() {

        if (w.input.Lastkey == 's' && !solving) {
            solve();
        }
        if (solving) {
            MoveSpeed -= 1;
            if (MoveSpeed < 2) {
                while (solveStep()) {
                }
            }
        }

    }

    @Override
    public void update(window win) {
        if (win.frameCount % 10 == 0) {
            done = complete(disks);
        }

        if (win.frameCount % MoveSpeed == 0) {
            if (solving == true) {
                solveStep();
            }
        }

    }

    public ArrayList<ArrayList<Integer>> getState() {
        return disks;
    }

}