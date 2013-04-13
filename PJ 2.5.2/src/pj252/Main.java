package pj252;

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

    /*public boolean equals(Wspolrzedna w){
        if ((this.x==w.x)&&(this.y==w.y)) return true;
        else return false;
    }*/

    @Override
    public int hashCode(){
        return this.x*100+this.y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Wspolrzedna other = (Wspolrzedna) obj;
        if (this.x != other.x) {
            return false;
        }
        if (this.y != other.y) {
            return false;
        }
        return true;
    }
}

public class Main {

    public static void main(String[] args) {
        HashMap <Wspolrzedna, String> mapa = new HashMap<Wspolrzedna, String>();
        mapa.put(new Wspolrzedna(2,3), new String("czerwony"));
        mapa.put(new Wspolrzedna(-3,0), new String ("czarny"));
        mapa.put(new Wspolrzedna(-1,2), new String("czerwony"));
        mapa.put(new Wspolrzedna(2,-1), new String ("czarny"));
        Wspolrzedna w= new Wspolrzedna(-1,2);
        System.out.println("Punkt "+w.toString()+" ma kolor "+mapa.get(w));
    }

}
