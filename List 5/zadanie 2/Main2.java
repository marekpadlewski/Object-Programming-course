import java.util.Hashtable;

public class Main2 {

    public static void main(String[] args){

        Hashtable<String,Integer> Tree = new Hashtable<String, Integer>();
        Tree.put("a", 17);
        Tree.put("b", 42);

        Wyrazenie expr = new Dodaj(new Stala(11), new Zmienna("a", Tree));
        expr = new Podziel(new Zmienna("b", Tree), expr);
        expr = new Odejmij(expr, new Dodaj(new Stala(4), new Stala(1)));
        expr = new Pomnoz(expr, new Stala(3));

        System.out.println(expr.toString() + " = " + expr.Oblicz());
    }
}
