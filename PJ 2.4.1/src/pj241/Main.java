package pj241;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Thunder
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        int opcja = Integer.parseInt(JOptionPane.showInputDialog("Wybierz kodowanie:"));
        String kodowanie="UTF8";
        if (opcja==1) kodowanie="ISO8859_2";
        if (opcja==2) kodowanie="Pc1250";

        FileInputStream y=new FileInputStream("plik.txt");
        InputStreamReader sr = new InputStreamReader(y, kodowanie);
        BufferedReader br = new BufferedReader(sr);
        try {
            JOptionPane.showMessageDialog(null, br.readLine());
            y.close();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }


        String bufor = JOptionPane.showInputDialog("Podaj tekst:");
        FileOutputStream x=new FileOutputStream("plik.txt");
        OutputStreamWriter sw= new OutputStreamWriter(x, kodowanie);
        BufferedWriter bw = new BufferedWriter(sw);
        try {
            bw.write(bufor);
            bw.flush();
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
