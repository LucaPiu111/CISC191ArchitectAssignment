package edu.sdccd.cisc191;

public class ControllerGameBoard {
    protected ModelGameBoard modelGameBoard;
    private boolean gameOver;

    public ControllerGameBoard() {
        this.modelGameBoard = new ModelGameBoard();
    }

    public boolean ProgramWins() {
        boolean ProgramWins = modelGameBoard.getGuessesRemaining() == 0;
        if (ProgramWins) {
            gameOver = true;
        }
        return ProgramWins;
    }

    public boolean playerWins() {
        boolean playerWins = modelGameBoard.getGuessesRemaining() == 0;
        if (playerWins) {
            gameOver = true;
        }
        return playerWins;
    }

    public boolean makeGuess(int row, int col) {
        if (!gameOver) {
            return modelGameBoard.makeGuess(row, col);
        }
        return false;
    }

    public boolean isGameOver() {
        return gameOver;
    }
}