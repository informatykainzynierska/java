package pj211;

import java.util.*;
import javax.swing.JOptionPane;

/*
 * @author Thunder
 */

public class Main {

    public static void main(String[] args) {
        System.out.println("Test");
        Scanner sc = new Scanner(System.in);
        //String bufor = sc.nextLine();
        String bufor;
        bufor = JOptionPane.showInputDialog("Wpisz ciąg znaków:");

        bufor = bufor.toUpperCase();
        
        JOptionPane.showMessageDialog(null, bufor);
        
        int a = Integer.parseInt(bufor);
        double b = Double.parseDouble(bufor);
        bufor = String.valueOf(b);
    }

}
