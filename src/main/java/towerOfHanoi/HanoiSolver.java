package towerOfHanoi;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class HanoiSolver {




    public static ArrayList<int[]> solve(ArrayList<ArrayList<Integer>> s,int size){
        // System.out.println(s);
        // System.out.println(new state(s,size));

        ArrayList<state> f=new ArrayList<state>();
        f.add(new state(s,size));
        state done=solver(f,new HashSet<state>());

        System.out.println(done);
        System.out.println(done.moves);
        return done.moves;

    }

    private static state solver(ArrayList<state> frontier,Set<state> checked){
        // System.out.println(frontier);
        // System.out.println(frontier.size());        
        // System.out.println(checked);
        // System.out.println(checked.size());
        // System.out.println("--------");

        ArrayList<state> NewFrountier=new ArrayList<state>();
        int[][] moves={{0,1},{0,2},{1,0},{1,2},{2,0},{2,1}};
        for(state f:frontier){
            for(int[] i:moves){
                state tmp=f.clone();
                swap(i[0], i[1], tmp);
                tmp.moves.add(i);
                NewFrountier.add(tmp);
                if(complete(tmp)) {
                    System.out.println("good");
                    return tmp;
                }
                

            }
        }
        checked.addAll(frontier);
        NewFrountier.removeAll(checked);

        return solver(NewFrountier, checked);

    }

    public static boolean swap(int f, int t, ArrayList<ArrayList<Integer>> pegs) {
        boolean can=false;
        if(pegs.get(f).size()>0){
            int size=pegs.get(f).get(0);

            if(pegs.get(t).size()==0){
                can=true;
            }else if(pegs.get(t).get(0)>size){
                can=true;
            }

        }

        if(can){
            int size=pegs.get(f).get(0);
            pegs.get(f).remove(0);
            pegs.get(t).add(0,size);
        }

        return can;
    }

    public static boolean swap(int f, int t, state s) {
        return swap(f,t,s.s);
    }

    public static boolean complete(state s) {
        ArrayList<ArrayList<Integer>> d = s.s;
        // last peg check
        ArrayList<Integer> baseLine= new ArrayList<Integer>();
        for(int i=0;i<s.size;i++){
            baseLine.add(i);
        }
        // first two poles empty and 3rd has all disks in order 
        return (d.get(0).size()==0 && d.get(1).size()==0 && d.get(2).equals(baseLine));

    }
    
    static class state{
        ArrayList<ArrayList<Integer>> s;
        ArrayList<int[]> moves;
        int size;
        state(ArrayList<ArrayList<Integer>> st,int si){
            size=si;
            this.moves=new ArrayList<>();
            s=st;
        }
        @Override
        public String toString() {
            String st="";
            for(ArrayList<Integer> i:s){
                st+="[";
                for(int e:i){
                    st+=e;
                }
                st+="]";
            }
            return st;
        }

        @Override
        public int hashCode() {
            return toString().hashCode();
        }

        @Override
        protected state clone(){
            ArrayList<ArrayList<Integer>> newS=new ArrayList<ArrayList<Integer>>();
            for(ArrayList<Integer> l:s){
                ArrayList<Integer> tmpL = (ArrayList<Integer>) l.clone();
                newS.add(tmpL);
            }
            state n=new state(newS,size);
            
            ArrayList<int[]> mo=(ArrayList<int[]>) moves.clone();
            n.moves=mo;
            return n;
        }


        @Override
        public boolean equals(Object obj) {
            return obj.hashCode()==this.hashCode();
        }
    }
}