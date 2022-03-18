import java.text.ParseException;

public interface ChampionshipManager {

    void serializingObjects();

    void deserializingObjects();

    void addDriver();

    void deleteDriver();

    void changeConstructor();

    void displayStatsOfDriver();

    void displayDriverTable();

    void addRace() throws ParseException;

}
