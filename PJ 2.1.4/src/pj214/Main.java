package pj214;
import javax.swing.JOptionPane;
/**
 *
 * @author Thunder
 */
public class Main {

    public static String binarnie(int a){
        String b="";
        if (a>0){
            int tmp=0;
            int i=1;
            int a2=a;
            while (a!=0){
                tmp+=(a%2)*i;
                a/=2;
                i*=10;
            }
            b = String.valueOf(tmp);
        }
        return(b);
    }

    public static String osemkowo(int a){
        String o="";
        if (a>0){
            int tmp=0;
            int i=1;
            int a2=a;
            while (a!=0){
                tmp+=(a%8)*i;
                a/=8;
                i*=10;
            }
            o = String.valueOf(tmp);
        }
        return(o);
    }

    public static String szesnastkowo(int a){
        String h="";
        String tmph = "";
            int tmp=0;
            while (a!=0){
                tmp=(a%16);
                if (tmp<10){
                    tmph += String.valueOf(tmp);
                }else if(tmp==10){
                    tmph +="A";
                }else if(tmp==11){
                    tmph +="B";
                }else if(tmp==12){
                    tmph +="C";
                }else if(tmp==13){
                    tmph +="D";
                }else if(tmp==14){
                    tmph +="E";
                }else if(tmp==15){
                    tmph +="F";
                }
                a/=16;
            }
            for (int i=tmph.length(); i>0; i--){
                h += tmph.charAt(i-1);
            }
        return(h);
    }

    public static void main(String[] args) {
        String bufor = JOptionPane.showInputDialog("Wpisz liczbę:");
        int a = Integer.valueOf(bufor);

        JOptionPane.showMessageDialog(null, "Binarnie: "+binarnie(a));
        JOptionPane.showMessageDialog(null, "Ósemkowo: "+osemkowo(a));
        JOptionPane.showMessageDialog(null, "Szesnastkowo: "+szesnastkowo(a));
    }

}