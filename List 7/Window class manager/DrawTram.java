import javax.swing.*;
import java.awt.*;
import java.io.*;

public class DrawTram extends JPanel {

    private JButton button1, button2, button3, button4;

    private JFrame frame;

    private String filename = "TramFile.bin";

    private File file = new File(filename);

    public DrawTram(JFrame f){
        frame = f;
    }

    public void paintComponent(Graphics g){
        //background
        g.setColor(new Color(25,25,112));
        g.fillRect(0,0,800,600);

        //add button
        button1 = new JButton();
        button1.setSize(400,50);
        button1.setLocation(200,100);
        button1.setText("NEW TRAM");
        button1.setFont(new Font("helvetica", Font.BOLD, 28));
        button1.setBackground(new Color(70,130,180));
        button1.addActionListener(e -> {

            frame.setContentPane(new AddTram(frame));
            frame.repaint();
            frame.revalidate();

        });
        add(button1);

        //load button
        button2 = new JButton();
        button2.setSize(400,50);
        button2.setLocation(200,200);
        button2.setText("LOAD TRAM");
        button2.setFont(new Font("helvetica", Font.BOLD, 28));
        button2.setBackground(new Color(70,130,180));
        button2.addActionListener(e -> {

            try {
                if (!file.exists()){
                    AddTram.trams.add(new Tram());
                }

                else {
                    ObjectInputStream is = new ObjectInputStream(new FileInputStream(filename));
                    Tram t = (Tram) is.readObject();
                    AddTram.trams.add(t);
                    System.out.println("Wczytywanie zakończone.");
                    is.close();
                }
            }
            catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        });
        add(button2);

        //save button
        button3 = new JButton();
        button3.setSize(400,50);
        button3.setLocation(200,300);
        button3.setText("SAVE TRAM");
        button3.setFont(new Font("helvetica", Font.BOLD, 28));
        button3.setBackground(new Color(70,130,180));
        button3.addActionListener(e -> {

            try {
                ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(filename));
                os.writeObject(AddTram.trams.get(AddTram.trams.size()-1));
                os.close();
                System.out.println("Zapisywanie zakończone.");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        add(button3);

        //back button
        button4 = new JButton();
        button4.setSize(400,50);
        button4.setLocation(200,400);
        button4.setText("BACK");
        button4.setFont(new Font("helvetica", Font.BOLD, 28));
        button4.setBackground(new Color(70,130,180));
        button4.addActionListener(e -> {

            frame.setContentPane(new Menu(frame));
            frame.repaint();
            frame.revalidate();
        });
        add(button4);

    }

}
