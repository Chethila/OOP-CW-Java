import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Formula1ChampionshipManager implements ChampionshipManager {

    public LinkedList<Formula1Driver> driverList = new LinkedList<>();
    public ArrayList<Race> raceList = new ArrayList<>();
    public static Formula1ChampionshipManager f1 = new Formula1ChampionshipManager();

    public static void main(String[] args) throws ParseException {

        f1.deserializingObjects();                    //Reading the past Information from the file.
        f1.deserializingObjects2();
        Scanner input1 = new Scanner(System.in);
        int userInput;

        while (true) {
            System.out.println("Enter 1 to add a Driver: ");
            System.out.println("Enter 2 to delete a Driver: ");
            System.out.println("Enter 3 to change the constructor team of a Driver: ");
            System.out.println("Enter 4 to display statistics of an existing Driver: ");
            System.out.println("Enter 5 to display the Formula 1 Driver Table: ");
            System.out.println("Enter 6 to add a new race completed information: ");
            System.out.println("Enter 7 to save all the information in a file: ");
            System.out.println("Enter 8 to display the GUI of the Application: ");
            System.out.println("Enter 9 to Exit the Application: ");

            userInput = input1.nextInt();

            if (userInput == 1) {                            //Adding a driver to the system.
                f1.addDriver();
            }

            else if (userInput == 2) {                       //Deleting a driver from the system.
                f1.deleteDriver();
            }

            else if (userInput == 3) {                       //Changing the driver constructor team.
                f1.changeConstructor();
            }

            else if (userInput == 4) {                       //Displaying the statistics of an existing driver.
                f1.displayStatsOfDriver();
            }

            else if (userInput == 5) {                       //F1 driver table.Points Descending order.
                f1.displayDriverTable();
            }

            else if (userInput == 6) {                       //to add a completed race statistics.
                f1.addRace();
            }

            else if (userInput == 7) {                       //saving all the information up to now in a file.
                f1.serializingObjects();
                f1.serializingObjects2();
                System.out.println("Information saved to the file.");
            }

            else if (userInput == 8) {                       //Displaying the GUI of the project.
                MainFrame mainFrame = new MainFrame();
            }

            else if (userInput == 9){
                break;
                }

            else {
                System.out.println("Please Enter A Correct Input");
            }
        }
    }

    public void addDriver() {
        //taking all the information of a driver to add him.
        Scanner input2 = new Scanner(System.in);
        System.out.print("Enter the name of the driver: ");
        String driverName = input2.next();

        Scanner input3 = new Scanner(System.in);
        System.out.print("Enter the location of the driver : ");
        String driverLocation = input3.next();

        Scanner input4 = new Scanner(System.in);
        System.out.print("Enter the constructor team of the driver : ");
        String driverTeam = input4.next();

        boolean x = true;
        int firstPositions = 0;
        while (x){
            Scanner input5 = new Scanner(System.in);
            System.out.print("Enter the number of 1st positions gained : ");
            if(input5.hasNextInt()) {
                firstPositions = input5.nextInt();
                x = false;
            }
            else
            {
                System.out.println("Please enter a valid Integer!");
                x = true;
            }
        }

        boolean y = true;
        int secondPositions = 0;
        while (y) {
            Scanner input6 = new Scanner(System.in);
            System.out.print("Enter the number of 2nd positions gained : ");
            if(input6.hasNextInt()) {
                secondPositions = input6.nextInt();
                y = false;
            }
            else
            {
                System.out.println("Please enter a valid Integer!");
                y = true;
            }
        }

        boolean z = true;
        int thirdPositions = 0;
        while (z) {
            Scanner input7 = new Scanner(System.in);
            System.out.print("Enter the number of 3rd positions gained : ");
            if(input7.hasNextInt()) {
                thirdPositions = input7.nextInt();
                z = false;
            }
            else
            {
                System.out.println("Please enter a valid Integer!");
                z = true;
            }
        }

        boolean a = true;
        int noParticipation = 0;
        while (a) {
            Scanner input8 = new Scanner(System.in);
            System.out.print("Enter the number of races participated : ");
            if(input8.hasNextInt()) {
                noParticipation = input8.nextInt();
                a = false;
            }
            else
            {
                System.out.println("Please enter a valid Integer!");
                a = true;
            }
        }

        boolean b = true;
        int points = 0;
        while (b) {
            Scanner input9 = new Scanner(System.in);
            System.out.print("Enter the number of points gained : ");

            if(input9.hasNextInt()) {
                points = input9.nextInt();
                b = false;
            }
            else
            {
                System.out.println("Please enter a valid Integer!");
                b = true;
            }
        }

        System.out.println("Driver added to the Championship");
        System.out.println("-------------------------");

        driverList.add(new Formula1Driver(driverName, driverLocation, driverTeam, firstPositions, secondPositions, thirdPositions, points, noParticipation));
    }

    public void deleteDriver() {
        Scanner input10 = new Scanner(System.in);
        System.out.println("Enter the name of the driver you want to delete: ");
        String deleteDriver = input10.next();
        boolean check = true;

        for (int x = 0; x < driverList.size(); x++) {
            if (driverList.get(x).getDriverName().equalsIgnoreCase(deleteDriver)) {
                System.out.println(deleteDriver + " has been deleted from the championship.");
                driverList.remove(x);
                check = false;
                System.out.println("-------------------------");
                break;
            }
        }
        if (check) {
            System.out.println("Couldn't find a driver called " + deleteDriver + ". Please enter the name again!");
            System.out.println("-------------------------");
        }
    }

    public void changeConstructor() {
        Scanner input11 = new Scanner(System.in);
        System.out.println("Enter the name of the driver you want to change the constructor team: ");
        String name = input11.next();
        boolean check2 = true;
        boolean check3 = true;

        for (int y = 0; y < driverList.size(); y++) {
            if (driverList.get(y).getDriverName().equalsIgnoreCase(name)) {
                Scanner input12 = new Scanner(System.in);
                System.out.println("Enter the new constructor team of the driver: ");
                String newTeam = input12.next();
                check2 = false;

                for (Formula1Driver formula1Driver : driverList) {
                    if (formula1Driver.getDriverTeam().equalsIgnoreCase(newTeam)) {
                        driverList.get(y).setDriverTeam(newTeam);
                        System.out.println(name + " has been added to the " + newTeam + " new constructor team.");
                        check3 = false;
                        System.out.println("-------------------------");
                        break;
                    }
                }
                if (check3) {
                    System.out.println("There is no existing constructor team called " + newTeam + ". Please try with another constructor team.");
                    System.out.println("-------------------------");
                }
            }
        }
        if (check2) {
            System.out.println("Couldn't find a driver called " + name + ". Please re-enter the name of the driver. ");
            System.out.println("-------------------------");
        }
    }

    public void displayStatsOfDriver() {
        Scanner input13 = new Scanner(System.in);
        System.out.println("Enter the name of the driver you want to check statistics: ");
        String checkName = input13.next();
        boolean check4 = true;
        for (int i = 0; i < driverList.size(); i++) {
            if (driverList.get(i).getDriverName().equalsIgnoreCase(checkName)) {
                check4 = false;
                System.out.println("Name :- " + driverList.get(i).getDriverName() +
                        "\n Location :- " + driverList.get(i).getDriverLocation() +
                        "\n Constructor team :- " + driverList.get(i).getDriverTeam() +
                        "\n Number of 1st Positions :- " + driverList.get(i).getFirstPositions() +
                        "\n Number of 2nd Positions :- " + driverList.get(i).getSecondPositions() +
                        "\n Number of 3rd Positions :- " + driverList.get(i).getThirdPositions() +
                        "\n Number of Races Participated :- " + driverList.get(i).getNoParticipation() +
                        "\n Number of Points Gained :- " + driverList.get(i).getPoints());
                System.out.println("-------------------------");
            }
        }
        if (check4) {
            System.out.println("Couldn't find a driver called " + checkName + ". Please re-enter the name of the driver. ");
            System.out.println("-------------------------");
        }
    }

    public void displayDriverTable() {
        Collections.sort(driverList);

        for (int x = 0; x < driverList.size(); x++) {
            System.out.println("Name :- " + driverList.get(x).getDriverName() +
                    "\n Location :- " + driverList.get(x).getDriverLocation() +
                    "\n Constructor team :- " + driverList.get(x).getDriverTeam() +
                    "\n Number of 1st Positions :- " + driverList.get(x).getFirstPositions() +
                    "\n Number of 2nd Positions :- " + driverList.get(x).getSecondPositions() +
                    "\n Number of 3rd Positions :- " + driverList.get(x).getThirdPositions() +
                    "\n Number of Races Participated :- " + driverList.get(x).getNoParticipation() +
                    "\n Number of Points Gained :- " + driverList.get(x).getPoints());
            System.out.println("....................");
        }
    }
    public void addRace() throws ParseException {
        ArrayList<Formula1Driver> raceDrivers = new ArrayList<>();                          //creating a raceDrivers arrayList with only Driver name and the positions.
        Scanner input17 = new Scanner(System.in);                                  //taking the race date from the user and making it a date variable.
        System.out.println("Enter the race date (YYYY-MM-DD) : ");
        String raceDate = input17.next();
        Date date;
        date = new SimpleDateFormat("yyyy-MM-dd").parse(raceDate);

        for (int y = 0; y < driverList.size(); y++) {
            Scanner input15 = new Scanner(System.in);
            System.out.println("Did this driver participate the race? " + driverList.get(y).getDriverName() + " type yes/no ?");
            String answer = input15.next();
            if (answer.equalsIgnoreCase("yes")) {
                boolean c = true;
                int position = 0;
                while (c) {
                    Scanner input16 = new Scanner(System.in);
                    System.out.println("Please enter the Position of the driver: ");
                    if(input16.hasNextInt()) {
                        position = input16.nextInt();
                        c = false;
                    }
                    else
                    {
                        System.out.println("Please enter a valid Integer!");
                        c = true;
                    }
                }

                int racePoints;

                switch (position) {                            //switch case for the points system.
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
                int pointFinal = driverList.get(y).getPoints() + racePoints;                  //updating the points and the number of participated races in driver object.
                int partiF = driverList.get(y).getNoParticipation() + 1;
                driverList.get(y).setPoints(pointFinal);
                driverList.get(y).setNoParticipation(partiF);

                String dName = driverList.get(y).getDriverName();
                raceDrivers.add(new Formula1Driver(dName,position));          //updating the raceDrivers ArrayList and assigning it to the Race object.

                if (position == 1) {                                                          //updating the main 3 positions in the driver object..
                    int firstF = driverList.get(y).getFirstPositions() + 1;
                    driverList.get(y).setFirstPositions(firstF);
                } else if (position == 2) {
                    int secondF = driverList.get(y).getSecondPositions() + 1;
                    driverList.get(y).setSecondPositions(secondF);
                } else if (position == 3) {
                    int thirdF = driverList.get(y).getSecondPositions() + 1;
                    driverList.get(y).setSecondPositions(thirdF);
                }
            }
        }
        Race race = new Race(date,raceDrivers);
        race.setRaceInfo(raceDrivers);
        race.setDate(date);
        raceList.add(race);
        f1.serializingObjects2();
    }

    public void serializingObjects() {
        String file = "SavedFile.ser";
        try {
            FileOutputStream fileOut = new FileOutputStream(file);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(driverList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void serializingObjects2() {
        String file = "SavedFile2.ser";
        try {
            FileOutputStream fileOut = new FileOutputStream(file);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(raceList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public void deserializingObjects() {
        String file = "SavedFile.ser";
        try {
            FileInputStream fileIn = new FileInputStream(file);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            driverList = (LinkedList) objectIn.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public void deserializingObjects2() {
        String file2 = "SavedFile2.ser";
        try {
            FileInputStream fileIn = new FileInputStream(file2);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            raceList = (ArrayList) objectIn.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public LinkedList<Formula1Driver> getDriverList() {
        return driverList;
    }

    public void setDriverList(LinkedList<Formula1Driver> driverList) {
        this.driverList = driverList;
    }

    public ArrayList<Race> getRaceList() {
        return raceList;
    }

    public void setRaceList(ArrayList<Race> raceList) {
        this.raceList = raceList;
    }

    public void driverTableAscending() {                                 //F1 driver table by the ascending order of points.

        driverList.sort(Collections.reverseOrder());

        for (Formula1Driver formula1Driver : driverList) {
            System.out.println("Name :- " + formula1Driver.getDriverName() +
                    "\n Location :- " + formula1Driver.getDriverLocation() +
                    "\n Constructor team :- " + formula1Driver.getDriverTeam() +
                    "\n Number of 1st Positions :- " + formula1Driver.getFirstPositions() +
                    "\n Number of 2nd Positions :- " + formula1Driver.getSecondPositions() +
                    "\n Number of 3rd Positions :- " + formula1Driver.getThirdPositions() +
                    "\n Number of Races Participated :- " + formula1Driver.getNoParticipation() +
                    "\n Number of Points Gained :- " + formula1Driver.getPoints());
            System.out.println("....................");
        }
    }

    public void driverTable1stPositions() {                             //F1 driver table by the descending order of 1st positions.
        driverList.sort((right, left) -> left.getFirstPositions() - right.getFirstPositions());
    }

    public  void displayRaceDetails() {
//        f1.deserializingObjects();
        System.out.println("Total number of Races :- "+raceList.size());
        System.out.println(" ");
//        raceList.sort((right,left) -> left.getDate() - right.getDate());

        for (Race race: raceList) {
            System.out.println("Race Date :- "+race.getDate());
            System.out.println("Number of Drivers Participated :- "+race.getRaceInfo().size());
            for (int i=0; i<race.getRaceInfo().size(); i++) {
                if (race.getRaceInfo().get(i).getPosition()==1) {
                    System.out.println("Winner :- "+race.getRaceInfo().get(i).getDriverName());
                }
            }
            System.out.println(" ");
        }
        System.out.println(" ");
    }
}
