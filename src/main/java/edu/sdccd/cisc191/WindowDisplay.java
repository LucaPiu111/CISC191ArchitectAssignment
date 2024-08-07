package edu.sdccd.cisc191;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class WindowDisplay extends Application
{
    private ControllerGameBoard controller;
    private GameBoardLabel SecretNumber;
    private GameBoardLabel RemainingGuesses;
    private GameBoardLabel message;

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        launch(args);
    }

    public void updateHeader() {
        RemainingGuesses.setText("Guesses left: " + controller.modelGameBoard.getGuessesRemaining());
        if(controller.ProgramWins()) {
            message.setText("You lose!");
        } else if(controller.playerWins()) {
            message.setText("You win!");
        } else {
            message.setText("Guess the correct number!");
        }
    }
    @Override
    public void start(Stage stage) throws Exception {
        controller = new ControllerGameBoard();
        SecretNumber = new GameBoardLabel();
        RemainingGuesses = new GameBoardLabel();
        message = new GameBoardLabel();

        BorderPane root = new BorderPane();

        updateHeader();

        HBox header = new HBox(SecretNumber, RemainingGuesses, message);
        root.setTop(header);

        VBox vbox = new VBox(ModelGameBoard.DIMENSION);
        for (int row=0; row < ModelGameBoard.DIMENSION; row++) {
            HBox hbox = new HBox(ModelGameBoard.DIMENSION);
            for (int col=0; col < ModelGameBoard.DIMENSION; col++) {
                boolean hasSecretNumber = controller.modelGameBoard.NumberLocation(row, col);
                GameBoardButton button = new GameBoardButton(row, col, hasSecretNumber, "buttonText");
                int finalRow = row;
                int finalCol = col;
                button.setOnAction(e -> {
                    controller.makeGuess(finalRow, finalCol);
                    if(!controller.isGameOver()) {
                        button.handleClick();
                        updateHeader();
                    }
                });
                hbox.getChildren().add(col, button);
            }
            vbox.getChildren().add(row, hbox);
        }

        root.setCenter(vbox);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Number Guesser");
        stage.setResizable(true);
        stage.show();
    }
}