package edu.sdccd.cisc191;

import java.util.Random;

public class ModelGameBoard
{
    public static int DIMENSION = 5;
    public static int GUESSES = 10;
    public static int NumberOfSecretNumbers = 1;

    private boolean[][] gameBoard;
    private int guessesRemaining;
    private int secretNumber;

    public ModelGameBoard()
    {
        gameBoard = new boolean[DIMENSION][DIMENSION];
        guessesRemaining = GUESSES;
        Random randomNumberGenerator = new Random();
        for (int NumberCounter = 0; NumberCounter < NumberOfSecretNumbers; NumberCounter++)
        {
            int x, y;
            do
            {
                x = randomNumberGenerator.nextInt(DIMENSION);
                y = randomNumberGenerator.nextInt(DIMENSION);
            } while (gameBoard[x][y]);
            gameBoard[x][y] = true;
        }
    }

    /**
     * @param row
     * @param col
     * @return
     */
    public boolean NumberLocation(int row, int col)
    {
        return gameBoard[row][col];
    }

    /**
     * @param row
     * @param col
     * @return
     */
    public boolean makeGuess(int row, int col)
    {
        boolean NumberFound = NumberLocation(row, col);
        guessesRemaining--;
        if (NumberFound)
        {
            int secretNumber = 0;
        }

        return NumberFound;
    }

    public int getGuessesRemaining()
    {
        return guessesRemaining;
    }
}