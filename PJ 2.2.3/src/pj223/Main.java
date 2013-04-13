package pj223;

import javax.swing.JOptionPane;

/**
 *
 * @author Thunder
 */
interface Wielomian{
    public void wypiszMiejscaZerowe();
}

class FunkcjaLiniowa implements Wielomian{
    double b;
    double c;
    public FunkcjaLiniowa(double b, double c){
        this.b=b;
        this.c=c;
    }
    public void wypiszMiejscaZerowe(){
        JOptionPane.showMessageDialog(null, -(c/b));
    }
}

class FunkcjaKwadratowa implements Wielomian{
    double a;
    double b;
    double c;
    public FunkcjaKwadratowa(double a, double b, double c){
        this.a=a;
        this.b=b;
        this.c=c;
    }
    public void wypiszMiejscaZerowe(){
        double d=b*b-4*a*c;
        if (d<0) JOptionPane.showMessageDialog(null, "brak");
        else if (d==0)JOptionPane.showMessageDialog(null, (-b)/2*a);
        else{
            d=Math.sqrt(d);
            JOptionPane.showMessageDialog(null, (-d-b)/(2*a) +" "+ (d-b)/(2*a));
        }
    }
}

public class Main {

    public static void main(String[] args) {
        Wielomian w[] = new Wielomian[3];
        w[0]=new FunkcjaLiniowa(2,1);
        w[1]=new FunkcjaKwadratowa(1,-2,2);
        w[2]=new FunkcjaKwadratowa(1,0,-1);
        for(int i=0; i<3; i++){
            w[i].wypiszMiejscaZerowe();
        }
    }

}
