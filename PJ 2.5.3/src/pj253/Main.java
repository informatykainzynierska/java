package pj253;

import java.util.*;

/**
 *
 * @author Thunder
 */
class Graf{
    private int n;
    private LinkedList[] tab;

    public Graf(String lan){
        StringTokenizer st= new StringTokenizer(lan, "() ,");
        n= Integer.parseInt(st.nextToken());
        tab = new LinkedList[n];
        for (int i=0; i<n; i++)
            tab[i]=new LinkedList();
        while (st.hasMoreTokens()){
            tab[Integer.parseInt(st.nextToken())].add(new Integer(st.nextToken()));
        }
    }

    @Override
    public String toString(){
        StringBuffer sb= new StringBuffer();
        for (int i=0; i<n; i++){
            sb.append(i+": ");
            for (int j=0; j<tab[i].size(); j++){
                sb.append(tab[i].get(j)+" ");
            }
            sb.append("\n");
        }
        return(sb.toString());
    }
}

public class Main {

    public static void main(String[] args) {
        Graf g=new Graf("4, (0,1), (1,2), (3,0), (1,3)");
        System.out.println(g.toString());
    }

}
