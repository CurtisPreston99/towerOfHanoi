package towerOfHanoi;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import engine.scene;

public class HanoiTest {

    @Test void CorrectGen() {
        App w= new App();
        scene s=new scene(w,"test");
        Hanoi h=new Hanoi(s, w, "hanoi");

        int[][] start ={{0,1,2},{},{}};
        ArrayList<ArrayList<Integer>> outcome=new ArrayList<ArrayList<Integer>>();
        for(int[] i:start){
            ArrayList<Integer> e=new ArrayList<>();
            for(int x:i){
                e.add(x);
            }
            outcome.add(e);
        }


        assertTrue(outcome.equals(h.disks));
    }

    @Test void CorrectSolving() {
        App w= new App();
        scene s=new scene(w,"test");
        Hanoi h=new Hanoi(s, w, "hanoi");
        h.solve();
        while(h.solveStep()){

        }
        int[][] start ={{},{},{0,1,2}};
        ArrayList<ArrayList<Integer>> outcome=new ArrayList<ArrayList<Integer>>();
        for(int[] i:start){
            ArrayList<Integer> e=new ArrayList<>();
            for(int x:i){
                e.add(x);
            }
            outcome.add(e);
        }
        assertTrue(outcome.equals(h.disks));
    }

    @Test void CorrectSolvingAfterMoves() {
        App w= new App();
        scene s=new scene(w,"test");
        Hanoi h=new Hanoi(s, w, "hanoi");
        HanoiSolver.swap(0, 2, h.disks);
        HanoiSolver.swap(0, 1, h.disks);
        h.solve();
        while(h.solveStep()){

        }
        int[][] start ={{},{},{0,1,2}};
        ArrayList<ArrayList<Integer>> outcome=new ArrayList<ArrayList<Integer>>();
        for(int[] i:start){
            ArrayList<Integer> e=new ArrayList<>();
            for(int x:i){
                e.add(x);
            }
            outcome.add(e);
        }
        assertTrue(outcome.equals(h.disks));
    }

    @Test void genSizes2() {
        App w= new App();
        scene s=new scene(w,"test");
        Hanoi h=new Hanoi(s, w, "hanoi");
        h.size=2;
        h.reset();
        

        int[][] start ={{0,1},{},{}};
        ArrayList<ArrayList<Integer>> outcome=new ArrayList<ArrayList<Integer>>();
        for(int[] i:start){
            ArrayList<Integer> e=new ArrayList<>();
            for(int x:i){
                e.add(x);
            }
            outcome.add(e);
        }
        assertTrue(outcome.equals(h.disks));
    }

    @Test void genSizes4() {
        App w= new App();
        scene s=new scene(w,"test");
        Hanoi h=new Hanoi(s, w, "hanoi");
        h.size=4;
        h.reset();
        

        int[][] start ={{0,1,2,3},{},{}};
        ArrayList<ArrayList<Integer>> outcome=new ArrayList<ArrayList<Integer>>();
        for(int[] i:start){
            ArrayList<Integer> e=new ArrayList<>();
            for(int x:i){
                e.add(x);
            }
            outcome.add(e);
        }
        assertTrue(outcome.equals(h.disks));
    }


    @Test void correctsolvingSize4() {
        App w= new App();
        scene s=new scene(w,"test");
        Hanoi h=new Hanoi(s, w, "hanoi");
        h.size=4;
        h.reset();
        h.solve();

        while(h.solveStep());
        

        int[][] start ={{},{},{0,1,2,3}};
        ArrayList<ArrayList<Integer>> outcome=new ArrayList<ArrayList<Integer>>();
        for(int[] i:start){
            ArrayList<Integer> e=new ArrayList<>();
            for(int x:i){
                e.add(x);
            }
            outcome.add(e);
        }
        assertTrue(outcome.equals(h.disks));
    }
}