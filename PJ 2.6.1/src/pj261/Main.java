package pj261;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Thunder
 */
class Zamieniacz extends Thread{
    JTextArea okno;
    volatile boolean zakonczyc;

    public Zamieniacz(JTextArea comp){
        okno=comp;
        zakonczyc=false;
    }

    @Override
    public void run(){
        while(!zakonczyc){
            try{
                String tekst=okno.getText();
                int indeks=tekst.indexOf("{");
                if (indeks >= 0){
                    okno.replaceRange("begin", indeks, indeks+1);
                    okno.setCaretPosition(tekst.length()+4);
                }
                else{
                    indeks = tekst.indexOf("}");
                        if (indeks >= 0){
                            okno.replaceRange("end", indeks, indeks+1);
                            okno.setCaretPosition(tekst.length()+2);
                        }
                }
                sleep(1000);
                System.out.println("Żyję!");
                indeks=tekst.indexOf("cholera");
                if (indeks >= 0){
                    JOptionPane.showMessageDialog(okno, "brzydal!");
                    okno.replaceRange("choroba", indeks, indeks+7);
                    okno.setCaretPosition(indeks+7);
                }
            }
            catch (Exception e){}
        }
    }
}

public class Main extends JFrame{

    private JScrollPane jScrollPane1;
    private JTextArea jTextArea1;
    private Zamieniacz watek;

    public Main(){
        initComponents();
        setSize(350, 250);
        watek=new Zamieniacz(jTextArea1);
        watek.start();
    }
    private void initComponents(){
        jScrollPane1 = new JScrollPane();
        jTextArea1=new JTextArea();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent evt){
                formWindowClosing(evt);
            }
        });
        jTextArea1.setPreferredSize(new Dimension(300,200));
        jScrollPane1.setViewportView(jTextArea1);
        getContentPane().add(jScrollPane1, BorderLayout.CENTER);
        pack();
    }

    private void formWindowClosing(WindowEvent evt){
        watek.zakonczyc=true;
        watek=null;
    }


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable(){
            public void run(){
                new Main().setVisible(true);
            }
        });
    }

}
