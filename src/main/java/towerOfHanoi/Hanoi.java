package towerOfHanoi;

import java.util.ArrayList;

import engine.scene;
import engine.window;
import engine.entity.entity;
import engine.input.mouse;
import processing.core.PGraphics;

class Hanoi extends entity {
    ArrayList<ArrayList<Integer>> disks;
    int size=3;
    int moves =0;


    boolean carry=false;
    int carrySize=0;
    int from=0;

    public Hanoi(scene s, window w, String name) {
        super(0, 0, w.width, w.height, s, w, name);
        reset();
    }

    void reset(){
        disks= new ArrayList<ArrayList<Integer>>(); 
        ArrayList<Integer> t=new  ArrayList<>();
        for(int i=0;i<size;i++){
            t.add(i);
        }
        disks.add(t);
        disks.add(new  ArrayList<>());
        disks.add(new  ArrayList<>());

    }

    @Override
    public void click() {
        mouse m=w.input.Mouse;
        int x=m.X();
        w.print(x);
        if(m.left){
            if(m.X()<(w.width/8)*3 && disks.get(0).size()>0){
                carry=true;
                from=0;
                carrySize=disks.get(0).get(0);
                disks.get(0).remove(0);
            }
            if(m.X()>=(w.width/8)*3 && m.X()<=(w.width/8)*5 && disks.get(1).size()>0){
                carry=true;
                from=1;
                carrySize=disks.get(1).get(0);
                disks.get(1).remove(0);
            }
            if(m.X()>(w.width/8)*5 && disks.get(2).size()>0){
                carry=true;
                from=2;
                carrySize=disks.get(2).get(0);
                disks.get(2).remove(0);
            }

        }else if(carry){
            int too=0;
            if(m.X()<(w.width/8)*3){
                too=0;
            }
            if(m.X()>=(w.width/8)*3 && m.X()<=(w.width/8)*5){
                too=1;
            }
            if(m.X()>(w.width/8)*5){
                too=2;
            }
            carry=false;

            if(disks.get(too).size()==0 || disks.get(too).get(0)>carrySize ){
                disks.get(too).add(0,carrySize);
            }else{
                disks.get(from).add(0,carrySize);
            }

        }

    }



    @Override
    public void draw(PGraphics b) {
        b.rectMode(b.CORNER);

        int poleWidth = 10;
        // poles
        b.rect((b.width/4)-poleWidth/2, b.height/4, poleWidth,(b.height/4)*3);
        b.rect((b.width/2)-poleWidth/2, b.height/4, poleWidth,(b.height/4)*3);
        b.rect(((b.width/4)*3)-poleWidth/2, b.height/4, poleWidth,(b.height/4)*3);
        // base
        b.rect(0,b.height-poleWidth,b.width,poleWidth);

        b.rectMode(b.CENTER);
        // disks
        int diskWidth = 20;
        for(int i=0;i<disks.size();i++){
            ArrayList<Integer> pole = disks.get(i);
            for(int e=0;e<pole.size();e++){
                switch (i) {
                    case 0:
                        b.rect(b.width/4, b.height-((pole.size()-e)*diskWidth), (pole.get(e)+1)*diskWidth,diskWidth);
                    break;
                    case 1:
                        b.rect(b.width/2, b.height-((pole.size()-e)*diskWidth), (pole.get(e)+1)*diskWidth,diskWidth);
                    break;
                    case 2:
                        b.rect((b.width/4)*3, b.height-((pole.size()-e)*diskWidth), (pole.get(e)+1)*diskWidth,diskWidth);
                    break;
                
                    default:
                        break;
                }
            }
        }

        if(carry){
            int x=w.input.Mouse.X();
            int y=w.input.Mouse.Y();
            b.rect(x, y,(carrySize+1)*diskWidth, diskWidth);
        }

    }

    @Override
    public void key() {

    }

    @Override
    public void update(window arg0) {
        // for(ArrayList<Integer>i:disks){
        //     w.println(i);
        // }
        // if(carry){
        //     w.print("carry: ");
        //     w.print(carrySize);
        // }
        // w.println("----");

    }



}