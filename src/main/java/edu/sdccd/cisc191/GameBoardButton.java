package edu.sdccd.cisc191;

import javafx.scene.control.Button;

public class GameBoardButton<T> extends Button {
    private int row;
    private int col;
    private T hasSecretNumber;
    private boolean isGuessed;
    private ButtonBehavior<T> behavior;

    public GameBoardButton(int row, int col, T hasSecretNumber, String buttonText) {
        this.row = row;
        this.col = col;
        this.hasSecretNumber = hasSecretNumber;
        this.behavior = behavior;

        setMinWidth(50);
        setPrefWidth(50);
        int gridSize = 5;
        int buttonNumber = row * gridSize + col + 1;
        setText(String.valueOf(buttonNumber));
        setDisable(false);

        setOnAction(e -> handleClick());
    }

    public void handleClick() {
        if (behavior != null) {
            String result = behavior.getButtonText(hasSecretNumber);
            setText(result);
        }
        isGuessed = true;
        setDisable(true);
    }

    public interface ButtonBehavior<T> {
        String getButtonText(T hasSecretNumber);
    }
}