import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class FrameSearch extends JFrame implements ActionListener {

    Formula1ChampionshipManager f1 = new Formula1ChampionshipManager();

    JButton button;
    JLabel topicLabel;
    JTextField textField;
    JButton btnSearch;
    String driver;
    JTextArea textArea;
    JLabel label1;
//    JScrollPane scrollPane;

    public FrameSearch() {

        textArea = new JTextArea(10, 10);
        textArea.setBounds(20, 120, 300, 600);
        textArea.setVisible(true);

//        JScrollPane scrollPane = new JScrollPane(textArea);
//        scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        btnSearch = new JButton();                                                  //Adding a Text Filed and a button to Search a driver by name and to display his Race Statistics.
        btnSearch.setBounds(330, 80, 95, 29);
        btnSearch.setText("Search");
        btnSearch.setFocusable(false);
        btnSearch.addActionListener(this);
        textField = new JTextField();
        textField.setBounds(75, 80, 250, 30);

        topicLabel = new JLabel();                               //Topic of the page.
        topicLabel.setText("Check Driver's Race Statistics");
        topicLabel.setBounds(120, 20, 550, 30);
        topicLabel.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 20));
        topicLabel.setForeground(new Color(255, 120, 10));

        ImageIcon image = new ImageIcon("driver_pic.jpg");                     //Adding the Image.

        label1 = new JLabel();
        label1.setBounds(170,110,320,620);
        label1.setIcon(image);
        label1.setHorizontalTextPosition(JLabel.CENTER);
        label1.setVerticalTextPosition(JLabel.TOP);

        button = new JButton();
        button.setText("Back");
        button.setBounds(20, 20, 75, 30);
        button.setFocusable(false);
        button.addActionListener(this);

        this.setSize(500, 830);
        this.setVisible(true);
        this.setLayout(null);
        this.setResizable(false);
        this.add(button);
        this.add(topicLabel);
        this.add(btnSearch);
        this.add(textField);
        this.add(textArea);
        this.add(label1);
        this.setLocation(650, 50);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            this.dispose();
            MainFrame mainFrame = new MainFrame();
        }
        if (e.getSource() == btnSearch) {
            driver = textField.getText();
            displayStats(driver);
        }
    }

    public void displayStats(String d) {

        f1.deserializingObjects2();
        textArea.setText(d+"\n");
        for (Race race : f1.raceList) {
            for (int i = 0; i < race.getRaceInfo().size(); i++) {
                if (race.getRaceInfo().get(i).getDriverName().equalsIgnoreCase(d)) {
                    textArea.setText(textArea.getText() + "Race Date " + race.getDate().toString() + "\n Position " +
                            String.valueOf(race.getRaceInfo().get(i).getPosition()) + "\n \n");
                }
            }
        }
    }
}
