package pj221;

import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Thunder
 */

class Rational{
    int l;
    int m;
    public Rational(int l, int m) {
        this.l=l;
        this.m=m;
    }

    public Rational add(Rational t){
        Rational r = new Rational(t.l, t.m);
        r.l=r.l*this.m+r.m*this.l;
        r.m=r.m*this.m;
        return(r);
    }

    public Rational mul(Rational t){
        Rational r = new Rational(t.l, t.m);
        r.l=r.l*this.l;
        r.m=r.m*this.m;
        return(r);
    }

    public Rational sub(Rational t){
        Rational r = new Rational(t.l, t.m);
        r.l=r.m*this.l-r.l*this.m;
        r.m=r.m*this.m;
        return(r);
    }

    public Rational div(Rational t){
        Rational r = new Rational(t.l, t.m);
        r.l=r.l*this.m;
        r.m=r.m*this.l;
        return(r);
    }

    public boolean equals(Rational t){
        Rational r = new Rational(t.l, t.m);
        if (Double.valueOf(r.l)/Double.valueOf(r.m)==Double.valueOf(this.l)/Double.valueOf(this.m))return(true);
        else return(false);
    }

    public int compareTo(Rational t){
        Rational r = new Rational(t.l, t.m);
        if (Double.valueOf(r.l)/Double.valueOf(r.m)==Double.valueOf(this.l)/Double.valueOf(this.m))return(0);
        else if (Double.valueOf(r.l)/Double.valueOf(r.m)>Double.valueOf(this.l)/Double.valueOf(this.m))return(-1);
        else return(1);
    }

    @Override
    public String toString(){
        String s = Integer.toString(this.l);
        s += "/";
        s += Integer.toString(this.m);
        return(s);
    }
}



public class Main {

    public static void main(String[] args) {
        String bufor = JOptionPane.showInputDialog("Wpisz licznik 1:");
        int l1 = Integer.valueOf(bufor);
        bufor = JOptionPane.showInputDialog("Wpisz mianownik 1:");
        int m1 = Integer.valueOf(bufor);
        Rational r1 = new Rational(l1, m1);
        JOptionPane.showMessageDialog(null, "Pierwsza liczba: "+r1.toString());

        bufor = JOptionPane.showInputDialog("Wpisz licznik 2:");
        int l2 = Integer.valueOf(bufor);
        bufor = JOptionPane.showInputDialog("Wpisz mianownik 2:");
        int m2 = Integer.valueOf(bufor);
        Rational r2 = new Rational(l2, m2);
        JOptionPane.showMessageDialog(null, "Druga liczba: "+r2.toString());

        JOptionPane.showMessageDialog(null, "Dodawanie: "+r1.add(r2).toString());
        JOptionPane.showMessageDialog(null, "Mnożenie: "+r1.mul(r2).toString());
        JOptionPane.showMessageDialog(null, "Odejmowanie: "+r1.sub(r2).toString());
        JOptionPane.showMessageDialog(null, "Dzielenie: "+r1.div(r2).toString());
        JOptionPane.showMessageDialog(null, "Równe: "+r1.equals(r2));
        JOptionPane.showMessageDialog(null, "Porównanie: "+r1.compareTo(r2));
    }

}
