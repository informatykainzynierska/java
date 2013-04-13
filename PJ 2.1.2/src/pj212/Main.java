package pj212;

import java.math.BigInteger;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Thunder
 */
public class Main {

    public static void main(String[] args) {
        //System.out.println("Test");
        //Scanner sc = new Scanner(System.in);
        String bufor;
        bufor = JOptionPane.showInputDialog("Wpisz liczbę:");
        BigInteger b = BigInteger.valueOf(Integer.parseInt(bufor));
        for (int i=b.intValue()-1; i>1; i--){
            b = b.multiply(BigInteger.valueOf(i));
            //System.out.print(i+". ");
            //System.out.println(b);
        }
        JOptionPane.showMessageDialog(null, b);
    }

}
