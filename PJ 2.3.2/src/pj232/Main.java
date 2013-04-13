package pj232;

/**
 *
 * @author Thunder
 */
abstract class Wierzcholek {

    Wierzcholek lewy, prawy;

    public abstract int wartosc() throws Exzero;
}

class Stala extends Wierzcholek {

    private int wart;

    public Stala(int x) {
        wart = x;
    }

    public int wartosc(){
        return wart;
    }
}

class Dzialanie extends Wierzcholek {

    private char op;

    public Dzialanie(char znak) {
        op = znak;
    }

    public void dodajLewyArg(Wierzcholek arg) {
        lewy = arg;
    }

    public void dodajPrawyArg(Wierzcholek arg) {
        prawy = arg;
    }

    public int wartosc() throws Exzero{
        switch (op) {
            case '+':
                return lewy.wartosc() + prawy.wartosc();
            case '-':
                return lewy.wartosc() - prawy.wartosc();
            case '/':
                if (prawy.wartosc()==0) throw new Exzero();
                else return lewy.wartosc() / prawy.wartosc();
            case '*':
                return lewy.wartosc() * prawy.wartosc();
        }
        
        return 0;
    }
}

class Exzero extends Exception{
    public Exzero(){

    }

    public Exzero(String message){
        super(message);
    }
}

class Niepoprwyr extends Exception{
    public Niepoprwyr(){

    }

    public Niepoprwyr(String message){
        super(message);
    }
}

class Wyrazenie {

    private Wierzcholek korzen;

    private Wierzcholek utworzDrzewo(String w, int p, int q) throws Niepoprwyr {
        if (p == q) {
            return new Stala(Character.digit(w.charAt(p), 10));
        } else {
            int i = p + 1, nawiasy = 0;
            while ((nawiasy != 0) || (w.charAt(i) == '(') || (w.charAt(i) == ')')
                    || (Character.isDigit(w.charAt(i)))) {
                if (w.charAt(i) == '(') {
                    ++nawiasy;
                }
                if (w.charAt(i) == ')') {
                    --nawiasy;
                    if (nawiasy<0) throw new Niepoprwyr();
                }
                ++i;
            }
            Dzialanie nowy = new Dzialanie(w.charAt(i));
            nowy.dodajLewyArg(utworzDrzewo(w, p + 1, i - 1));
            nowy.dodajPrawyArg(utworzDrzewo(w, i + 1, q - 1));
            return nowy;
        }
    }

    public Wyrazenie(String w) throws Niepoprwyr {
        korzen = utworzDrzewo(w, 0, w.length() - 1);
    }

    public int oblicz() throws Exzero{
        return korzen.wartosc();
    }
}

public class Main{

    public static void main(String[] args){
        try{
        Wyrazenie wyr = new Wyrazenie("(3*((1+2)-1))");
        System.out.println("" +wyr.oblicz());
        }

        catch(Exzero e){
            System.out.println("Nie dziel przez zero! (catch)");
        }
        catch(Niepoprwyr e){
            System.out.println("Niepoprawne wyrażenie! (catch)");
        }
    }
}
