import java.io.Serializable;

abstract public class Driver implements Serializable {
    private String driverName;
    private String driverLocation;
    private String driverTeam;

    public Driver(String driverName) {
        this.driverName = driverName;
    }

    public Driver(String driverName, String driverLocation, String driverTeam) {
        this.driverName = driverName;
        this.driverLocation = driverLocation;
        this.driverTeam = driverTeam;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverLocation() {
        return driverLocation;
    }

    public void setDriverLocation(String driverLocation) {
        this.driverLocation = driverLocation;
    }

    public String getDriverTeam() {
        return driverTeam;
    }

    public void setDriverTeam(String driverTeam) {
        this.driverTeam = driverTeam;
    }
}
