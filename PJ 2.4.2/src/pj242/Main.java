package pj242;

import java.io.*;
import java.util.zip.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Thunder
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        FileOutputStream fo=new FileOutputStream("plik");
        GZIPOutputStream go=new GZIPOutputStream(fo);
        Writer coder = new OutputStreamWriter(go);
        BufferedWriter bw = new BufferedWriter(coder);

        bw.write("rfgkujhnkgjdfgkhjhjjn");
        bw.flush();
        bw.close();

        FileInputStream fi=new FileInputStream("plik");
        GZIPInputStream gi=new GZIPInputStream(fi);
        Reader decoder = new InputStreamReader(gi);
        BufferedReader br = new BufferedReader(decoder);
        
        JOptionPane.showMessageDialog(null, br.readLine());
        br.close();
    }

}
