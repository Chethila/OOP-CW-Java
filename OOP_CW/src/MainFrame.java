import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame implements ActionListener {
    Formula1ChampionshipManager f1 = new Formula1ChampionshipManager();

    private final JButton button1;
    private final JButton button2;
    private final JButton button3;
    private final JButton button4;
    private final JButton button5;
    private final JButton button6;
    private final JButton button7;

    public MainFrame() {

        ImageIcon image = new ImageIcon("f1_logo.png");                     //Adding the Image.

        JLabel label1 = new JLabel();
        label1.setBounds(50,50,400,250);
        label1.setIcon(image);
        label1.setHorizontalTextPosition(JLabel.CENTER);
        label1.setVerticalTextPosition(JLabel.TOP);

        JLabel label2 = new JLabel();                                                      //Adding the Topic.
        label2.setText("Formula 1 Racing Main Page");
        label2.setBounds(50,300,400,100);
        label2.setFont(new Font("SansSerif", Font.BOLD, 28));

        button1 = new JButton();                                                    //Adding the button for display F1 Driver List - Descending Order of Points.
        button1.setBounds(75,400,350,40);
        button1.setText("F1 Driver List - Descending Order of Points");
        button1.setFocusable(false);
        button1.addActionListener(this);

        button2 = new JButton();                                                    //Adding the button for display F1 Driver List - Ascending Order of Points.
        button2.setBounds(75,450,350,40);
        button2.setText("F1 Driver List - Ascending Order of Points");
        button2.setFocusable(false);
        button2.addActionListener(this);

        button3 = new JButton();                                                    //Adding the button for display F1 Driver List - Descending Order of 1st Positions.
        button3.setBounds(75,500,350,40);
        button3.setText("F1 Driver List - Descending Order of 1st Positions");
        button3.setFocusable(false);
        button3.addActionListener(this);

        button4 = new JButton();                                                    //Adding the button for Generate a random race.
        button4.setBounds(75,550,350,40);
        button4.setText("Generate a Random Race");
        button4.setFocusable(false);
        button4.addActionListener(this);

        button5 = new JButton();                                                    //Adding the button for Generate a random race Predicted by starting points of Racers.
        button5.setBounds(75,600,350,40);
        button5.setText("Generate a Random Race Predicted by Starting Position");
        button5.setFocusable(false);
        button5.addActionListener(this);

        button6 = new JButton();                                                    //Adding the button for display the F1 Championship Races Statistics
        button6.setBounds(75,650,350,40);
        button6.setText("F1 Championship Races Statistics");
        button6.setFocusable(false);
        button6.addActionListener(this);

        button7 = new JButton();                                                    //Adding the button for display the F1 Championship Races Statistics
        button7.setBounds(75,700,350,40);
        button7.setText("Search by Driver Name");
        button7.setFocusable(false);
        button7.addActionListener(this);

        this.setTitle("Formula 1 Championship");                                    //Adding the elements to the Main Frame.
        this.setSize(500,830);
        this.setVisible(true);
        this.setResizable(false);
        this.setLayout(null);
        this.add(label1);
        this.add(label2);
        this.add(button1);
        this.add(button2);
        this.add(button3);
        this.add(button4);
        this.add(button5);
        this.add(button6);
        this.add(button7);
        this.setLocation(650,50);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==button1) {
            this.dispose();
            Frame1 frame1 = new Frame1();
        }
        else if (e.getSource()==button2) {
            this.dispose();
            Frame2 frame2 = new Frame2();
        }
        else if (e.getSource()==button3) {
            this.dispose();
            Frame3 frame3 = new Frame3();
        }
        else if (e.getSource()==button4) {
            this.dispose();
            Frame4 frame4 = new Frame4();
        }
        else if (e.getSource()==button5) {
            this.dispose();
            Frame5 frame5 = new Frame5();
        }
        else if (e.getSource()==button6) {
            this.dispose();
            Frame6 frame6 = new Frame6();
        }
        else if (e.getSource()==button7) {
            this.dispose();
            FrameSearch frameSearch = new FrameSearch();
        }
    }
}
