package edu.sdccd.cisc191;

import javafx.geometry.Insets;
import javafx.scene.control.Label;

public class GameBoardLabel extends Label implements GameBoardLabelInterface {
    public static final Insets LABEL_PADDING = new Insets(20);

    public GameBoardLabel() {
        setLabelPadding(LABEL_PADDING);
    }

    @Override
    public void setLabelPadding(Insets insets) {
        setPadding(insets);
    }
}