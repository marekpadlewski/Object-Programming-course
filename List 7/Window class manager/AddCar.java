import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class AddCar extends JPanel {

    private JFrame frame;
    private Car car;
    private JButton button1, button2;
    private JLabel year_et, mileage_et, brand_et, max_vel_et, weight_et, height_et;
    private JTextField year_text, mileage_text, brand_text, max_vel_text, weight_text, height_text;
    public static Vector<Car> cars = new Vector<>();

    public AddCar(JFrame f) {
        frame = f;

        if (cars.isEmpty())
            cars.add(new Car());

        car = cars.get(cars.size()-1);

        max_vel_et = new JLabel("           Max velocity");
        max_vel_et.setFont(new Font("helvetica", Font.BOLD, 30));
        max_vel_et.setForeground(Color.WHITE);

        max_vel_text = new JTextField(Integer.toString(car.maxVelocity), 4);
        max_vel_text.setFont(new Font("helvetica", Font.BOLD, 30));

        weight_et = new JLabel("            Weight");
        weight_et.setFont(new Font("helvetica", Font.BOLD, 30));
        weight_et.setForeground(Color.WHITE);

        weight_text = new JTextField(Integer.toString(car.weight), 4);
        weight_text.setFont(new Font("helvetica", Font.BOLD, 30));

        height_et = new JLabel("            Height");
        height_et.setFont(new Font("helvetica", Font.BOLD, 30));
        height_et.setForeground(Color.WHITE);

        height_text = new JTextField(Integer.toString(car.height), 4);
        height_text.setFont(new Font("helvetica", Font.BOLD, 30));

        year_et = new JLabel("      Year of production");
        year_et.setFont(new Font("helvetica", Font.BOLD, 30));
        year_et.setForeground(Color.WHITE);

        year_text = new JTextField(Integer.toString(car.yearOfProduction), 4);
        year_text.setFont(new Font("helvetica", Font.BOLD, 30));

        mileage_et = new JLabel("            Mileage");
        mileage_et.setFont(new Font("helvetica", Font.BOLD, 30));
        mileage_et.setForeground(Color.WHITE);

        mileage_text = new JTextField(Integer.toString(car.mileage), 4);
        mileage_text.setFont(new Font("helvetica", Font.BOLD, 30));

        brand_et = new JLabel("            Brand");
        brand_et.setFont(new Font("helvetica", Font.BOLD, 30));
        brand_et.setForeground(Color.WHITE);

        brand_text = new JTextField(car.brand, 4);
        brand_text.setFont(new Font("helvetica", Font.BOLD, 30));

        button1 = new JButton();
        button1.setText("SAVE");
        button1.setFont(new Font("helvetica", Font.BOLD, 28));
        button1.setBackground(new Color(70,130,180));
        button1.addActionListener(e -> saveData());

        button2 = new JButton();
        button2.setText("BACK");
        button2.setFont(new Font("helvetica", Font.BOLD, 28));
        button2.setBackground(new Color(70,130,180));
        button2.addActionListener(e -> {
            frame.setContentPane(new DrawCar(frame));
            frame.repaint();
            frame.revalidate();

        });


        setLayout(new GridLayout(0, 2,0,10));
        add(max_vel_et);
        add(max_vel_text);
        add(weight_et);
        add(weight_text);
        add(height_et);
        add(height_text);
        add(year_et);
        add(year_text);
        add(mileage_et);
        add(mileage_text);
        add(brand_et);
        add(brand_text);
        add(button1);
        add(button2);
        repaint();
    }

    public void paintComponent (Graphics g){

        super.paintComponent(g);

        setBackground(new Color(25,25,112));

    }

    private void saveData(){
        car.maxVelocity = Integer.parseInt(max_vel_text.getText());
        car.weight = Integer.parseInt((weight_text.getText()));
        car.height = Integer.parseInt((height_text.getText()));
        car.yearOfProduction = Integer.parseInt(year_text.getText());
        car.mileage = Integer.parseInt((mileage_text.getText()));
        car.brand = brand_text.getText();

        cars.add(car);
    }
}