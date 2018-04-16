import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class AddVehicle extends JPanel {

    private JFrame frame;
    private Vehicle vehicle;
    private JButton button1, button2;
    private JLabel max_vel_et, weight_et, height_et;
    private JTextField max_vel_text, weight_text, height_text;

    public static Vector<Vehicle> vehicles = new Vector<>();


    public AddVehicle(JFrame f) {
        frame = f;

        if (vehicles.isEmpty())
            vehicles.add(new Vehicle());

        vehicle = vehicles.get(vehicles.size()-1);

        max_vel_et = new JLabel("           Max velocity");
        max_vel_et.setFont(new Font("helvetica", Font.BOLD, 30));
        max_vel_et.setForeground(Color.WHITE);

        max_vel_text = new JTextField(Integer.toString(vehicle.maxVelocity), 4);
        max_vel_text.setFont(new Font("helvetica", Font.BOLD, 30));

        weight_et = new JLabel("            Weight");
        weight_et.setFont(new Font("helvetica", Font.BOLD, 30));
        weight_et.setForeground(Color.WHITE);

        weight_text = new JTextField(Integer.toString(vehicle.weight), 4);
        weight_text.setFont(new Font("helvetica", Font.BOLD, 30));

        height_et = new JLabel("            Height");
        height_et.setFont(new Font("helvetica", Font.BOLD, 30));
        height_et.setForeground(Color.WHITE);

        height_text = new JTextField(Integer.toString(vehicle.height), 4);
        height_text.setFont(new Font("helvetica", Font.BOLD, 30));

        button1 = new JButton();
        button1.setText("SAVE");
        button1.setFont(new Font("helvetica", Font.BOLD, 28));
        button1.setBackground(new Color(70,130,180));
        button1.addActionListener(e -> {
            saveData();

        });

        button2 = new JButton();
        button2.setText("BACK");
        button2.setFont(new Font("helvetica", Font.BOLD, 28));
        button2.setBackground(new Color(70,130,180));
        button2.addActionListener(e -> {
            frame.setContentPane(new DrawVehicle(frame));
            frame.repaint();
            frame.revalidate();

        });


        setLayout(new GridLayout(0, 2,0,100));
        add(max_vel_et);
        add(max_vel_text);
        add(weight_et);
        add(weight_text);
        add(height_et);
        add(height_text);
        add(button1);
        add(button2);
        repaint();
    }

    public void paintComponent (Graphics g){

        super.paintComponent(g);

        setBackground(new Color(25,25,112));

    }

    private void saveData(){
        vehicle.maxVelocity = Integer.parseInt(max_vel_text.getText());
        vehicle.weight = Integer.parseInt((weight_text.getText()));
        vehicle.height = Integer.parseInt((height_text.getText()));
        vehicles.add(vehicle);
    }
}