import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SoccerTeam {
  private String teamName;
  private double possession;
  private int games;
  private int goalsFor;
  private int goalsAgainst;
  private double expectedGoals;
  private double passingAccuracy;
  private double form;

  public SoccerTeam(String teamName, double possession, int games, int goalsFor, int goalsAgainst, double expectedGoals, double passingAccuracy, double form) {
    this.teamName = teamName;
    this.possession = possession;
    this.games = games;
    this.goalsFor = goalsFor;
    this.goalsAgainst = goalsAgainst;
    this.expectedGoals = expectedGoals;
    this.passingAccuracy = passingAccuracy;
    this.form = form;
  }

  @Override
  public String toString() {
    return teamName +
        "{possession=" + possession +
        ", games=" + games +
        ", goalsFor=" + goalsFor +
        ", goalsAgainst=" + goalsAgainst +
        ", expectedGoals=" + expectedGoals +
        ", passingAccuracy=" + passingAccuracy +
        ", form=" + form +
        '}';
  }

  public String getTeamName() {
    return teamName;
  }

  public double getPossession() {
    return possession;
  }

  public int getGames() {
    return games;
  }

  public int getGoalsFor() {
    return goalsFor;
  }

  public int getGoalsAgainst() {
    return goalsAgainst;
  }

  public double getExpectedGoals() {
    return expectedGoals;
  }

  public double getPassingAccuracy() {
    return passingAccuracy;
  }

  public double getForm(){
    return form;
  }
}

