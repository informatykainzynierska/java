/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pj222;

import javax.swing.JOptionPane;
/**
 *
 * @author Thunder
 */
class Rownanie{
    private double a;
    private double b;
    private double c;
    public Rownanie(double a, double b, double c){
        this.a=a;
        this.b=b;
        this.c=c;
    }

    public void set(double a, double b, double c){
        this.a=a;
        this.b=b;
        this.c=c;
    }

    public double getY(double x){
        double y;
        y=a*x*x+b*x+c;
        return(y);
    }

    public int pierwiastki(){
        int i=-1;
        double d=b*b-4*a*c;
        if (d<0) i=0;
        else if (d==0) i=1;
        else i=2;
        return(i);
    }
}

public class Main {

    public static void main(String[] args) {
        String bufor = JOptionPane.showInputDialog("Podaj parametr a:");
        double a = Double.valueOf(bufor);
        bufor = JOptionPane.showInputDialog("Podaj parametr b:");
        double b = Double.valueOf(bufor);
        bufor = JOptionPane.showInputDialog("Podaj parametr c:");
        double c = Double.valueOf(bufor);

        Rownanie r = new Rownanie(a,b,c);
        JOptionPane.showMessageDialog(null, "Liczba pierwiastków: "+r.pierwiastki());

        bufor = JOptionPane.showInputDialog("Podaj argument x:");
        double x = Double.valueOf(bufor);
        JOptionPane.showMessageDialog(null, "Wartość funkcji: "+r.getY(x));
    }

}
