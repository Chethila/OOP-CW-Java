import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;


public class Frame5 extends JFrame implements ActionListener {

    ArrayList<Integer> gridPosition = new ArrayList<>();
    ArrayList<Integer> positions = new ArrayList<>();

    Formula1ChampionshipManager f1 = new Formula1ChampionshipManager();

    JButton button;
    JLabel topicLabel;
    JLabel columnLabel;
    JLabel date;
    JTextField raceDate;
    JButton submit;

    public Frame5() {

        f1.deserializingObjects();
        f1.deserializingObjects2();

        int max=f1.driverList.size();
        while (gridPosition.size() < max) {                                 //Creating random positions for drivers.
            int randomGridPosition = (int) (Math.random()*max+1);
            if (!gridPosition.contains(randomGridPosition)) {
                gridPosition.add(randomGridPosition);
            }
        }

        int randomNum = (int) (Math.random()*101+1);

        int randomPosition = 0;

        System.out.println(gridPosition);
        System.out.println(positions);
        for (Integer startPosition : gridPosition) {

            while (positions.size() < max) {                                 //Creating random positions for drivers.
                randomPosition = (int) (Math.random()*max+1);
                if (!positions.contains(randomPosition)) {
                    positions.add(randomPosition);
                }
            }

            System.out.println(randomNum);

            if (startPosition == 1) {
                if (positions.contains(1)) {
                    positions.add(randomPosition);
                }
                else {
                    if (randomNum > 0 && randomNum <= 40) {
                        positions.add(1);
                    }
                    else {
                        if (!positions.contains(randomPosition)) {
                            positions.add(randomPosition);
                        }
                    }
                }
            }
            else if (startPosition == 2) {
                if (positions.contains(1)) {
                    positions.add(randomPosition);
                }
                else {
                    if (randomNum > 0 && randomNum <= 30) {
                        positions.add(1);
                    }
                    else {
                        if (!positions.contains(randomPosition)) {
                            positions.add(randomPosition);
                        }
                    }
                }
            }
            else if (startPosition == 3 || startPosition == 4) {
                if (positions.contains(1)) {
                    positions.add(randomPosition);
                }
                else {
                    if (randomNum > 0 && randomNum <= 10) {
                        positions.add(1);
                    }
                    else {
                        if (!positions.contains(randomPosition)) {
                            positions.add(randomPosition);
                        }
                    }
                }
            }
            else if (startPosition >= 5 && startPosition <= 9) {
                if (positions.contains(1)) {
                    positions.add(randomPosition);
                }
                else {
                    if (randomNum > 0 && randomNum <= 2) {
                        positions.add(1);
                    }
                    else {
                        if (!positions.contains(randomPosition)) {
                            positions.add(randomPosition);
                        }
                    }
                }
            }
            else if (startPosition > 9) {
                if (!positions.contains(randomPosition)) {
                    positions.add(randomPosition);
                }
            }
        }
        System.out.println(gridPosition);
        System.out.println(positions);
        for (int y=0; y<max; y++) {
            int racePoints;

            switch (positions.get(y)) {                            //switch case for the points system.
                case 1:
                    racePoints = 25;
                    break;
                case 2:
                    racePoints = 18;
                    break;
                case 3:
                    racePoints = 15;
                    break;
                case 4:
                    racePoints = 12;
                    break;
                case 5:
                    racePoints = 10;
                    break;
                case 6:
                    racePoints = 8;
                    break;
                case 7:
                    racePoints = 6;
                    break;
                case 8:
                    racePoints = 4;
                    break;
                case 9:
                    racePoints = 2;
                    break;
                case 10:
                    racePoints = 1;
                    break;
                default:
                    racePoints = 0;
                    break;
            }
            int pointFinal = f1.getDriverList().get(y).getPoints() + racePoints;                  //updating the points and the number of participated races in driver object.
            int partiF = f1.getDriverList().get(y).getNoParticipation() + 1;
            f1.getDriverList().get(y).setPoints(pointFinal);
            f1.getDriverList().get(y).setNoParticipation(partiF);

            if (positions.get(y) == 1) {                                                          //updating the main 3 positions in the driver object..
                int firstF = f1.getDriverList().get(y).getFirstPositions() + 1;
                f1.getDriverList().get(y).setFirstPositions(firstF);
            } else if (positions.get(y) == 2) {
                int secondF = f1.getDriverList().get(y).getSecondPositions() + 1;
                f1.getDriverList().get(y).setSecondPositions(secondF);
            } else if (positions.get(y) == 3) {
                int thirdF = f1.getDriverList().get(y).getSecondPositions() + 1;
                f1.getDriverList().get(y).setSecondPositions(thirdF);
            }
            f1.serializingObjects();
        }

        String[] column = {"Driver Name", "Position", "Starting Position"};                   //Creating the table.
        DefaultTableModel driverTable = new DefaultTableModel(column, 0);
        JTable dTable = new JTable(driverTable);
        dTable.setBounds(20, 200, 400, 500);

        for (int i = 0; i < f1.getDriverList().size(); i++) {
            String name = f1.getDriverList().get(i).getDriverName();
            int position = positions.get(i);
            int grid = gridPosition.get(i);

            Object[] row = {name, position, grid};
            driverTable.addRow(row);
        }

        date = new JLabel();
        date.setText("Enter the Race Date : \n (Format yyyy-MM-dd)");
        date.setBounds(20, 60, 250, 60);
        raceDate = new JTextField();
        raceDate.setBounds(270, 75, 200, 30);
        submit = new JButton();
        submit.setText("Submit");
        submit.setFocusable(false);
        submit.setBounds(394, 110, 75, 25);
        submit.addActionListener(this);

        button = new JButton();
        button.setText("Back");
        button.setBounds(20, 20, 75, 30);
        button.setFocusable(false);
        button.addActionListener(this);


        columnLabel = new JLabel();                                                    //table columns.
        columnLabel.setText("Driver Name                     | Position                          | Starting Position   ");
        columnLabel.setBounds(20, 178, 400, 30);
        columnLabel.setForeground(new Color(10, 120, 250));

        topicLabel = new JLabel();                                                     //topic of the page.
        topicLabel.setText("Generating a Race with Probability");
        topicLabel.setBounds(110, 20, 380, 30);
        topicLabel.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 18));
        topicLabel.setForeground(new Color(255, 120, 10));

        this.setSize(500, 830);
        this.setVisible(true);
        this.setLayout(null);
        this.setResizable(false);
        this.setLocation(650, 50);
        this.add(button);
        this.add(date);
        this.add(raceDate);
        this.add(submit);
        this.add(topicLabel);
        this.add(columnLabel);
        this.add(dTable);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        f1.deserializingObjects2();
        if (e.getSource() == button) {
            this.dispose();
            MainFrame mainFrame = new MainFrame();
        }
        if (e.getSource() == submit) {
            int answer = JOptionPane.showConfirmDialog(null, "Please make sure the entered date " +
                    "\nis in the format of YYYY-MM-DD ", "Confirmation", JOptionPane.YES_NO_OPTION);
            if (answer == 0) {
                ArrayList<Formula1Driver> raceDrivers = new ArrayList<>();
                for (int y=0; y<f1.driverList.size(); y++) {
                    String dName = f1.getDriverList().get(y).getDriverName();
                    raceDrivers.add(new Formula1Driver(dName,positions.get(y)));                          //updating the raceDrivers ArrayList and assigning it to the Race object.
                }
                String rd = raceDate.getText();
                Date thisRaceDate = new Date();
                try {
                    thisRaceDate = new SimpleDateFormat("yyyy-MM-dd").parse(rd);
                } catch (ParseException parseException) {
                    parseException.printStackTrace();
                }
                Race race = new Race(thisRaceDate,raceDrivers);
                race.setRaceInfo(raceDrivers);
                race.setDate(thisRaceDate);
                f1.getRaceList().add(race);

                f1.serializingObjects2();
            }
        }
    }
}

