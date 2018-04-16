import java.io.Serializable;

public class Tram extends Vehicle implements Serializable{

    int yearOfProduction;
    int maxNumberOfPassengers;
    String brand;

    public String toString(){
        return "Rok produkcji: " + yearOfProduction + "\nIlość pasażerów: " + maxNumberOfPassengers
                + "\nMarka: " + brand;

    }
}
