import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class AddTram extends JPanel {

    private JFrame frame;
    private   Tram tram;
    private JButton button1, button2;
    private JLabel year_et, passengers_et, brand_et, max_vel_et, weight_et, height_et;
    private JTextField year_text, passengers_text, brand_text, max_vel_text, weight_text, height_text;
    public static Vector<Tram> trams = new Vector<>();

    public AddTram(JFrame f) {
        frame = f;

        if (trams.isEmpty())
            trams.add(new Tram());

        tram = trams.get(trams.size()-1);

        max_vel_et = new JLabel("           Max velocity");
        max_vel_et.setFont(new Font("helvetica", Font.BOLD, 30));
        max_vel_et.setForeground(Color.WHITE);

        max_vel_text = new JTextField(Integer.toString(tram.maxVelocity), 4);
        max_vel_text.setFont(new Font("helvetica", Font.BOLD, 30));

        weight_et = new JLabel("            Weight");
        weight_et.setFont(new Font("helvetica", Font.BOLD, 30));
        weight_et.setForeground(Color.WHITE);

        weight_text = new JTextField(Integer.toString(tram.weight), 4);
        weight_text.setFont(new Font("helvetica", Font.BOLD, 30));

        height_et = new JLabel("            Height");
        height_et.setFont(new Font("helvetica", Font.BOLD, 30));
        height_et.setForeground(Color.WHITE);

        height_text = new JTextField(Integer.toString(tram.height), 4);
        height_text.setFont(new Font("helvetica", Font.BOLD, 30));

        year_et = new JLabel("      Year of production");
        year_et.setFont(new Font("helvetica", Font.BOLD, 30));
        year_et.setForeground(Color.WHITE);

        year_text = new JTextField(Integer.toString(tram.yearOfProduction), 4);
        year_text.setFont(new Font("helvetica", Font.BOLD, 30));

        passengers_et = new JLabel("    Max number of passengers");
        passengers_et.setFont(new Font("helvetica", Font.BOLD, 22));
        passengers_et.setForeground(Color.WHITE);

        passengers_text = new JTextField(Integer.toString(tram.maxNumberOfPassengers), 4);
        passengers_text.setFont(new Font("helvetica", Font.BOLD, 30));

        brand_et = new JLabel("            Brand");
        brand_et.setFont(new Font("helvetica", Font.BOLD, 30));
        brand_et.setForeground(Color.WHITE);

        brand_text = new JTextField(tram.brand, 4);
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
            frame.setContentPane(new DrawTram(frame));
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
        add(passengers_et);
        add(passengers_text);
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
        tram.maxVelocity = Integer.parseInt(max_vel_text.getText());
        tram.weight = Integer.parseInt((weight_text.getText()));
        tram.height = Integer.parseInt((height_text.getText()));
        tram.yearOfProduction = Integer.parseInt(year_text.getText());
        tram.maxNumberOfPassengers = Integer.parseInt((passengers_text.getText()));
        tram.brand = brand_text.getText();

        trams.add(tram);
    }
}