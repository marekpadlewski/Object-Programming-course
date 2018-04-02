public class Stala implements Wyrazenie{

    int value;

    public Stala(int v){
        value = v;
    }

    @Override
    public int Oblicz() {
        return value;
    }

    public String toString(){
        return "" + value;
    }

}
