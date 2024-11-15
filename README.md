# Premier League Match Prediction

## Overview
This project predicts the outcomes of English Premier League (EPL) football matches using team statistics and a combination of statistical and machine learning techniques. The program calculates the probability of a team winning based on weighted performance metrics such as goals scored, goals conceded, possession, passing accuracy, and form.

## Features
- Reads team statistics from a CSV file (`EPLStats.csv`).
- Calculates team strengths based on weighted performance metrics.
- Predicts match outcomes using a logistic function.
- Allows dynamic adjustment of metric weights for experimentation.
- Provides win probabilities for both teams in a match.

## Future Enhancements
- Integrating a **Random Forest Classifier** for more advanced predictions.
- Adding support for head-to-head analysis, home/away performance, and player injury data.
- Implementing a GUI for better user interaction and result visualization.

## Project Structure
```plaintext
src/
├── SoccerTeam.java             # Represents a team with statistical properties
├── SoccerTeamCSVReader.java    # Reads team data from the CSV file
├── SoccerMatchPrediction.java  # Main program to predict match outcomes
└── EPLStats.csv                # Input dataset with team statistics

