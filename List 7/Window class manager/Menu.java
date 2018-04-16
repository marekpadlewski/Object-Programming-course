import javax.swing.*;
import java.awt.*;

public class Menu extends JPanel {

    private JButton button1, button2, button3;
    private JFrame frame;


    public Menu(JFrame f){
        frame = f;
    }

    public void paintComponent(Graphics g){
        //background
        g.setColor(new Color(25,25,112));
        g.fillRect(0,0,800,600);

        //vehicle button
        button1 = new JButton();
        button1.setSize(400,50);
        button1.setLocation(200,100);
        button1.setText("VEHICLE");
        button1.setFont(new Font("helvetica", Font.BOLD, 28));
        button1.setBackground(new Color(70,130,180));
        button1.addActionListener(e -> {

            frame.setContentPane(new DrawVehicle(frame));
            frame.repaint();
            frame.revalidate();

        });
        add(button1);

        //tram button
        button2 = new JButton();
        button2.setSize(400,50);
        button2.setLocation(200,200);
        button2.setText("CAR");
        button2.setFont(new Font("helvetica", Font.BOLD, 28));
        button2.setBackground(new Color(70,130,180));
        button2.addActionListener(e -> {

            frame.setContentPane(new DrawCar(frame));
            frame.repaint();
            frame.revalidate();

        });
        add(button2);

        //tram button
        button3 = new JButton();
        button3.setSize(400,50);
        button3.setLocation(200,300);
        button3.setText("TRAM");
        button3.setFont(new Font("helvetica", Font.BOLD, 28));
        button3.setBackground(new Color(70,130,180));
        button3.addActionListener(e -> {

            frame.setContentPane(new DrawTram(frame));
            frame.repaint();
            frame.revalidate();

        });
        add(button3);

    }
}
