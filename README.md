# Guessing Game

## Introduction

The Guessing Game is a fun interactive game where the computer tries to guess the number you're thinking of between 1 and 100. Your role is to guide the computer by providing hints - "Higher", "Lower", or "Correct".

## Components

**GuessingGame.java:** This is the main UI class for the Guessing Game. It initializes the JavaFX window and manages user interactions. The class is responsible for:

* Setting up the main game layout.
* Displaying the computer's current guess.
* Handling button interactions when a user responds with "Higher", "Lower", or "Correct".

**GameLogic.java:** This class handles the logic behind the computer's guessing strategy. Its functions include:

* Keeping track of the possible range of numbers based on the user's feedback.
* Adjusting the guessed number based on the hints received from the user.
* Counting the number of attempts taken by the computer to guess the correct number.

## Gameplay

1. Think of a number between 1 and 100.
2. The computer will make its first guess.
3. Click on one of the three buttons to guide the computer:

   * **Higher:** If your number is higher than the computer's guess.
   * **Lower:** If your number is lower than the computer's guess.
   * **Correct:** If the computer has guessed your number correctly.

4. Continue this processs until the computer guesses your number!

## Getting Started

1. **Prerequisities:**

   * Java Development Kit (JDK) with JavaFX
   * A suitable IDE for Java, like VS Code, Eclipse, or IntelliJ IDEA

2. **Setup:**

   * Clone the repo and open in your IDE

3. **Running the App:**

   * Run `App.java` to start the application.

## Possible Enhancements

* **Adjustable Range:** Allow the player to set a custom range for guessing.
* **Multiplayer Mode:** Implement a mode where two players can compete to guess the computer's number.
