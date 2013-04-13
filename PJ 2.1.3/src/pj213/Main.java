package pj213;

import java.util.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Thunder
 */
public class Main {

    public static void main(String[] args) {
        String bufor = JOptionPane.showInputDialog("Wpisz liczbę:");
        int a = Integer.valueOf(bufor);
        if (a>0){
            if (a%2==0) a--;
            for (int i=a; i>0; i--){
                a+=i;
                System.out.print(i+". ");
                System.out.println(a);
                i--;
            }
            JOptionPane.showMessageDialog(null, a);
        }

    }

}
