import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args){
        JFrame window = new JFrame();
        window.setSize(800,600);
        window.setLocationRelativeTo(null);
        window.setTitle("Manager of vehicle class");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        Menu menu = new Menu(window);
        window.add(menu);

        window.setVisible(true);
    }
}
