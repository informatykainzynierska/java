package pj231;

/**
 *
 * @author Thunder
 */
class Kolejka{
    static final int N = 5;
    private Object[] tab;
    private int pocz, zaost,lbel;

    public Kolejka(){
        pocz=0; zaost=0; lbel=0;
        tab = new Object[N];
    }

    void doKolejki(Object el) throws Przepelnienie{
        if (lbel==N) {
            throw new Przepelnienie();
        }else{
            tab[zaost] = el;
            zaost = (zaost+1) % N;
            ++lbel;
        }
    }

    Object zKolejki() throws Niedomiar{
        if (lbel==0) {
            throw new Niedomiar();
        }else{
            int ind = pocz;
            pocz = (pocz+1) % N;
            --lbel;
            return tab[ind];
        }
    }
}

class Przepelnienie extends Exception{
    public Przepelnienie(){

    }

    public Przepelnienie(String message){
        super(message);
    }
}

class Niedomiar extends Exception{
    public Niedomiar(){

    }

    public Niedomiar(String message){
        super(message);
    }
}

public class Main {

    public static void main(String[] args) {
        Kolejka k = new Kolejka();
        try{
            k.doKolejki(new Integer(7));
            k.doKolejki(new String("Ala ma kota"));
            k.doKolejki(new Double(3.14));
            for (int i=1; i<=3; ++i)
                System.out.println((k.zKolejki()).toString());
        }
        catch (Przepelnienie e){
            System.out.println("Przepełniona kolejka!");
        }
        catch (Niedomiar e){
            System.out.println("Pusta kolejka!");
        }
    }

}
