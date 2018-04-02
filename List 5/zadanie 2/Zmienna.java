import java.util.Hashtable;

public class Zmienna implements Wyrazenie {

    String s;
    Hashtable<String, Integer> Tree;

    public Zmienna (String s, Hashtable<String, Integer> t){
        this.s = s;
        Tree = t;
    }

    @Override
    public int Oblicz() {
        return Tree.get(s);
    }

    public String toString(){
        return s;
    }
}
