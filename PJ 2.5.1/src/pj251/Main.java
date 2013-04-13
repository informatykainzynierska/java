package pj251;

import java.util.*;

/**
 *
 * @author Thunder
 */
class Wspolrzedna implements Comparable{
    private int x, y;

    public Wspolrzedna (int x, int y){
        this.x=x;
        this.y=y;
    }

    @Override
    public String toString(){
        return "("+x+","+y+")";
    }
    
    public int compareTo(Object o) {
        if (this.x<((Wspolrzedna)o).x) return -1;
        else if (this.x>((Wspolrzedna)o).x) return 1;
        else if (this.y<((Wspolrzedna)o).y) return -1;
        else if (this.y>((Wspolrzedna)o).y) return 1;
        else return 0;
    }
}

public class Main {
    public static void wypiszElementy(TreeSet zbior){
        Iterator it=zbior.iterator();
        while (it.hasNext()){
            System.out.println((it.next()).toString());
        }
    }

    public static void main(String[] args) {
        TreeSet zbior = new TreeSet();
        zbior.add(new Wspolrzedna(2,3));
        zbior.add(new Wspolrzedna(-3,0));
        zbior.add(new Wspolrzedna(-1,2));
        zbior.add(new Wspolrzedna(-1,2));
        zbior.add(new Wspolrzedna(-3,-2));
        wypiszElementy(zbior);
    }

}
