import java.util.List;
import java.util.Scanner;

public class SoccerMatchPrediction {
  public static void main(String[] args) {

    //weights
    double weightGoalsScored = 0.4;
    double weightGoalsConceded = 0.3;
    double weightPossession = 0.2;
    double weightxG = 0.2;
    double weightPassingAccuracy = 0.1;
    double weightForm = 0.8;

    Scanner scanner = new Scanner(System.in);

    List<SoccerTeam> teams = SoccerTeamCSVReader.getSoccerTeams();

    //get team a
    System.out.print("Type name of team a: ");
    String teamA = scanner.nextLine();
    SoccerTeam a = null;

    for (SoccerTeam team : teams) {
      if (team.getTeamName().toLowerCase().contains(teamA.toLowerCase())) {
        a = team;
        break;
      }
    }

    //get team b
    System.out.print("Type name of team b: ");
    String teamB = scanner.nextLine();
    SoccerTeam b = null;

    for (SoccerTeam team : teams) {
      if (team.getTeamName().toLowerCase().contains(teamB.toLowerCase())) {
        b = team;
        break;
      }
    }

    //Collect Data
    double goalsScoredA = a.getGoalsFor()/a.getGames();
    double goalsConcededA = a.getGoalsAgainst()/a.getGames();
    double possessionA = a.getPossession();
    double xGA = a.getExpectedGoals();
    double passingAccuracyA = a.getPassingAccuracy();
    double formA = a.getForm()/5.0;

    double goalsScoredB = b.getGoalsFor()/b.getGames();
    double goalsConcededB = b.getGoalsAgainst()/b.getGames();
    double possessionB = b.getPossession();
    double xGB = b.getExpectedGoals();
    double passingAccuracyB = b.getPassingAccuracy();
    double formB = b.getForm()/5.0;


    double strengthA = calculateStrength(
        goalsScoredA, goalsConcededA, possessionA, xGA, passingAccuracyA, formA,
        weightGoalsScored, weightGoalsConceded, weightPossession, weightxG, weightPassingAccuracy, weightForm
    );
    double strengthB = calculateStrength(
        goalsScoredB, goalsConcededB, possessionB, xGB, passingAccuracyB, formB,
        weightGoalsScored, weightGoalsConceded, weightPossession, weightxG, weightPassingAccuracy, weightForm
    );

    // Calculate the strength difference
    double strengthDifference = strengthA - strengthB;

    // Calculate win probabilities
    double winProbabilityA = 1 / (1 + Math.exp(-strengthDifference));
    double winProbabilityB = 1 - winProbabilityA;

    double roundedA = ((int)(winProbabilityA*100000))/1000.00;
    double roundedB = ((int)(winProbabilityB*100000))/1000.00;

    // Display the results
    System.out.println(a.getTeamName() + "'s Probability of Winning: " + roundedA + "%");
    System.out.println(b.getTeamName() + "'s Probability of Winning: " + roundedB + "%");

    // Close the scanner
    scanner.close();

  }

  private static double calculateStrength(double goalsScored, double goalsConceded, double possession, double xG, double passingAccuracy, double form, double w1, double w2, double w3, double w4, double w5, double w6) {
    return (w1 * goalsScored) + (w2 * goalsConceded) + (w3 * possession) + (w4 * xG) + (w5 * passingAccuracy) + (w6 * form);
  }
}
