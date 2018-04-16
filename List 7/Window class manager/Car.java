import java.io.Serializable;

public class Car extends Vehicle implements Serializable{

    int yearOfProduction;
    int mileage;
    String brand;

    public String toString(){
        return "Rok produkcji: " + yearOfProduction + "\nPrzebieg: " + mileage + "\nMarka: " + brand;
    }
}
