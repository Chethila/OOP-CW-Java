import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame1 extends JFrame implements ActionListener {

    Formula1ChampionshipManager f1 = new Formula1ChampionshipManager();
    JButton button;
    JLabel topicLabel;
    JLabel columnLabel;

    public Frame1() {

        f1.deserializingObjects();
        f1.displayDriverTable();

        String[] column = {"Name","Constructor","Location","Points","1st P.","2nd P.","3rd P.","No.Participated"};                        //Creating the table.
        DefaultTableModel driverTable = new DefaultTableModel(column,0);
        JTable dTable = new JTable(driverTable);
        dTable.setBounds(20,100,650,650);

        for (int i=0; i<f1.getDriverList().size(); i++) {
            String name = f1.getDriverList().get(i).getDriverName();
            String team = f1.getDriverList().get(i).getDriverTeam();
            String location = f1.getDriverList().get(i).getDriverLocation();
            int points = f1.getDriverList().get(i).getPoints();
            int first = f1.getDriverList().get(i).getFirstPositions();
            int second = f1.getDriverList().get(i).getSecondPositions();
            int third = f1.getDriverList().get(i).getThirdPositions();
            int participate = f1.getDriverList().get(i).getNoParticipation();

            Object [] row = {name,team,location,points,first,second,third,participate};
            driverTable.addRow(row);
        }

        columnLabel = new JLabel();                              //Table columns.
        columnLabel.setText("Name                | Constructor  | Location        | Points              | 1st P.              | 2nd P.             | 3rd P.              | Participation ");
        columnLabel.setBounds(20,80,650,20);
        columnLabel.setForeground(new Color(10,120,250));

        topicLabel = new JLabel();                               //Topic of the page.
        topicLabel.setText("F1 Driver Table - Descending order of Points");
        topicLabel.setBounds(120,20,550,30);
        topicLabel.setFont(new Font(Font.DIALOG_INPUT,Font.BOLD,20));
        topicLabel.setForeground(new Color(255,120,10));

        button = new JButton();                                  //Back Button.
        button.setText("Back");
        button.setBounds(20,20,75,30);
        button.setFocusable(false);
        button.addActionListener(this);

        this.setSize(700,830);                       //Setting the elements.
        this.setVisible(true);
        this.setLayout(null);
        this.setResizable(false);
        this.setLocation(650,50);
        this.add(button);
        this.add(topicLabel);
        this.add(columnLabel);
        this.add(dTable);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==button) {
            this.dispose();
            MainFrame mainFrame = new MainFrame();
        }
    }
}
