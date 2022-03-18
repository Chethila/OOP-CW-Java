import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Frame6 extends JFrame implements ActionListener {

    Formula1ChampionshipManager f1 = new Formula1ChampionshipManager();
    JButton button;
    JLabel columnLabel;
    JLabel topicLabel;
    JLabel label1;

    public Frame6() {
        f1.deserializingObjects2();
        f1.displayRaceDetails();

        String[] column = {"Race Date","No. Drivers","Winner"};                        //Creating the table.
        DefaultTableModel driverTable = new DefaultTableModel(column,0);
        JTable rTable = new JTable(driverTable);
        rTable.setBounds(20,100,510,400);

        for (Race race: f1.raceList) {
            Date rDate = race.getDate();
            int drivers = race.getRaceInfo().size();
            String winner = "";
            for (int i=0; i<race.getRaceInfo().size(); i++) {
                if (race.getRaceInfo().get(i).getPosition()==1) {
                    winner = race.getRaceInfo().get(i).getDriverName();
                }
            }

            Object [] row = {rDate,drivers,winner};
            driverTable.addRow(row);
        }

        columnLabel = new JLabel();                              //Table columns.
        columnLabel.setText("Race Date                                     |           No. Drivers                       |             Winner ");
        columnLabel.setBounds(20,80,450,20);
        columnLabel.setForeground(new Color(10,120,250));

        topicLabel = new JLabel();                               //Topic of the page.
        topicLabel.setText("Race Statistics Table");
        topicLabel.setBounds(120,20,550,30);
        topicLabel.setFont(new Font(Font.DIALOG_INPUT,Font.BOLD,20));
        topicLabel.setForeground(new Color(255,120,10));

        ImageIcon image = new ImageIcon("race_pic.png");                     //Adding the Image.

        label1 = new JLabel();
        label1.setBounds(90,530,360,230);
        label1.setIcon(image);
        label1.setHorizontalTextPosition(JLabel.CENTER);
        label1.setVerticalTextPosition(JLabel.TOP);

        button = new JButton();
        button.setText("Back");
        button.setBounds(20,20,75,30);
        button.setFocusable(false);
        button.addActionListener(this);

        this.setSize(550,830);
        this.setVisible(true);
        this.setLayout(null);
        this.setResizable(false);
        this.add(button);
        this.add(rTable);
        this.add(columnLabel);
        this.add(topicLabel);
        this.add(label1);
        this.setLocation(650,50);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==button) {
            this.dispose();
            MainFrame mainFrame = new MainFrame();
        }
    }
}
