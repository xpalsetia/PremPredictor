import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SoccerTeamCSVReader {
  public static List<SoccerTeam> getSoccerTeams() {
    String csvFilePath = "src/EPLStats.csv"; // Replace with the path to your CSV file
    List<SoccerTeam> soccerTeams = new ArrayList<>();

    try (Scanner scanner = new Scanner(new File(csvFilePath))) {
      scanner.useDelimiter(",|\\n"); // Set the delimiter to "," or newline

      // Skip the header row
      if (scanner.hasNextLine()) {
        scanner.nextLine();
      }

      while (scanner.hasNextLine()) {
        String column1 = scanner.next();
        String column2 = scanner.next();
        String column3 = scanner.next();
        String column4 = scanner.next();
        String column5 = scanner.next();
        String column6 = scanner.next();
        String column7 = scanner.next();
        String column8 = scanner.next();

        String teamName = column1;
        double possession = Double.parseDouble(column2);
        int games = Integer.parseInt(column3);
        int goalsFor = Integer.parseInt(column4);
        int goalsAgainst = Integer.parseInt(column5);
        double expectedGoals = Double.parseDouble(column6);
        double passingAccuracy = Double.parseDouble(column7);
        double form = Double.parseDouble(column8);

        SoccerTeam team =
            new SoccerTeam(teamName, possession, games, goalsFor, goalsAgainst, expectedGoals,
                passingAccuracy, form);
        soccerTeams.add(team);
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    // Print the soccer team data
    /*for (SoccerTeam team : soccerTeams) {
      System.out.println(team);
    }*/
    return soccerTeams;
  }
}
