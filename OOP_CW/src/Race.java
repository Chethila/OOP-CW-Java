import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Race implements Serializable {
    private Date date;
    private ArrayList<Formula1Driver> raceInfo;

    public Race(Date date, ArrayList<Formula1Driver> raceInfo) {
        this.date = date;
        this.raceInfo = raceInfo;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ArrayList<Formula1Driver> getRaceInfo() {
        return raceInfo;
    }

    public void setRaceInfo(ArrayList<Formula1Driver> raceInfo) {
        this.raceInfo = raceInfo;
    }

    @Override
    public String toString() {
        return "Race{" +
                "date=" + date +
                ", raceInfo=" + raceInfo +
                '}';
    }
}
