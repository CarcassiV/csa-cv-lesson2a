package com.codedotorg;

public class GameLogic {

    /** The left boundary of the range to guess */
    private int left;

    /** The right boundary of the range to guess */
    private int right;

    /** The middle of the range to guess */
    private int guess;

    /** The number of guesses made */
    private int numGuesses;

    /**
     * This constructor initializes the game logic by setting the left and right boundaries
     * of the game to 1 and 100 respectively. It also sets the guess to the middle of the
     * left and right boundaries and initializes the number of guesses to 1.
     */
    public GameLogic() {
        left = 1;
        right = 100;
        guess = (left + right) / 2;
        numGuesses = 1;
    }

    /**
     * Returns the current guess.
     *
     * @return the current guess
     */
    public int getGuess() {
        return guess;
    }

    /**
     * Returns the number of guesses made by the player.
     *
     * @return the number of guesses made by the player
     */
    public int getNumGuesses() {
        return numGuesses;
    }

    /**
     * This method updates the left boundary of the range of possible numbers to guess,
     * sets the guess to the middle of the new range, updates the number of guesses made.
     * @return void
     */
    public void guessHigher() {
        left = guess + 1;
        guess = (left + right) / 2;
        numGuesses++;
    }

    /**
     * Decreases the guess range by setting the right boundary to the current guess
     * minus one, then updates the guess to the midpoint of the new range. Also
     * increments the number of guesses made.
     */
    public void guessLower() {
        right = guess - 1;
        guess = (left + right) / 2;
        numGuesses++;
    }
    
}
