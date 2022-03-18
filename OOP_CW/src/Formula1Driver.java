public class Formula1Driver extends Driver implements Comparable<Formula1Driver> {

    private int firstPositions;
    private int secondPositions;
    private int thirdPositions;
    private int points;
    private int noParticipation;
    private int position;

    public Formula1Driver(String driverName, String driverLocation, String driverTeam, int firstPositions, int secondPositions, int thirdPositions, int points, int noParticipation) {
        super(driverName, driverLocation, driverTeam);
        this.firstPositions = firstPositions;
        this.secondPositions = secondPositions;
        this.thirdPositions = thirdPositions;
        this.points = points;
        this.noParticipation = noParticipation;
    }

    public Formula1Driver(String driverName, int position) {
        super(driverName);
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getFirstPositions() {
        return firstPositions;
    }

    public void setFirstPositions(int firstPositions) {
        this.firstPositions = firstPositions;
    }

    public int getSecondPositions() {
        return secondPositions;
    }

    public void setSecondPositions(int secondPositions) {
        this.secondPositions = secondPositions;
    }

    public int getThirdPositions() {
        return thirdPositions;
    }

    public void setThirdPositions(int thirdPositions) {
        this.thirdPositions = thirdPositions;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getNoParticipation() {
        return noParticipation;
    }

    public void setNoParticipation(int noParticipation) {
        this.noParticipation = noParticipation;
    }

    @Override
    public String toString() {
        return "Formula1Driver{" +
                "firstPositions=" + firstPositions +
                ", secondPositions=" + secondPositions +
                ", thirdPositions=" + thirdPositions +
                ", points=" + points +
                ", noParticipation=" + noParticipation +
                '}';
    }

    @Override
    public int compareTo(Formula1Driver o) {
        int sortResult =  o.getPoints() - this.getPoints();
        if (sortResult == 0) {
            return  o.getFirstPositions() - this.getFirstPositions();
        }
        return sortResult;
    }
}

