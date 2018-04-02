import java.io.*;

public class Main {

    public static void main(String[] args){

        Lista<Integer> lista = new Lista<>();

        lista.addBack(5);
        lista.addFront(1);
        lista.addBack(9);
        lista.addBack(42);
        lista.addFront(17);
        System.out.println("Lista po dodaniu pięciu wartości: ");
        lista.writeNodes();

        System.out.println("Lista po usunięciu elementu z końca: ");
        lista.delBack();
        lista.writeNodes();

        System.out.println("Lista po usunięciu elementu z początku: ");
        lista.delFront();
        lista.writeNodes();

        System.out.println("Dodam jeszcze dwie wartości na koniec: ");
        lista.addBack(555);
        lista.addBack(1234);
        lista.writeNodes();

        String filename = "listfile.bin";
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(filename));
            os.writeObject(lista);
            os.close();
            System.out.println("Zapisywanie zakończone.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(filename));
            Lista<Integer> l = (Lista<Integer>) is.readObject();
            System.out.println("Wczytywanie zakończone.");
            is.close();
            System.out.println("Lista po wczytaniu z pliku: ");
            l.writeNodes();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
