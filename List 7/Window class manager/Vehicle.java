import java.io.Serializable;

public class Vehicle implements Serializable{

    int maxVelocity;
    int weight;
    int height;


    public String toString(){
        return "Maksymalna prędkość: " + maxVelocity + "\nWaga: " + weight + "\nWysokość: " + height;

    }
}
