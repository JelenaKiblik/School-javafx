package game.functionality;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class CountDown {

    private Label countDown = new Label();
    private int countNr = 2;
    private boolean finished;
    private static final int COUNTDOWN_Y_COORDINATES = 300;
    private static final int COUNTDOWN_X_COORDINATES = 300;
    private static final int COUNTDOWN_TWO_DURATION = 1000;
    private static final int COUNTDOWN_ONE_DURATION = 2000;
    private static final int COUNTDOWN_ZERO_DURATION = 3000;
    private static final int COUNTDOWN_DECREASE = 2;

    public void countdown(StackPane root) {
        finished = false;
        Timeline countDownThreeTwo = new Timeline();
        Timeline countDownOne = new Timeline();
        countDown.setTranslateY(COUNTDOWN_Y_COORDINATES);
        countDown.setTranslateX(COUNTDOWN_X_COORDINATES);
        countDown.setText(String.valueOf(countNr));
        countDown.getStyleClass().add("labelCountDown");
        root.getChildren().addAll(countDown);
        KeyFrame two = new KeyFrame(Duration.millis(COUNTDOWN_TWO_DURATION), event -> {
            countDown.setText(String.valueOf(countNr - 1));
            countDown.getStyleClass().add("labelCountDown");
        });
        KeyFrame one = new KeyFrame(Duration.millis(COUNTDOWN_ONE_DURATION), event -> {
            countDown.setText(String.valueOf(countNr - COUNTDOWN_DECREASE));
            countDown.getStyleClass().add("labelCountDown");
        });
        KeyFrame zero = new KeyFrame(Duration.millis(COUNTDOWN_ZERO_DURATION), event ->
                countDown.setText(""));
        countDownOne.getKeyFrames().addAll(two);
        countDownOne.setCycleCount(1);
        countDownOne.play();
        countDownThreeTwo.getKeyFrames().addAll(one, zero);
        countDownThreeTwo.setCycleCount(1);
        countDownThreeTwo.play();
        countDownThreeTwo.setOnFinished(event -> setFinished());
    }

    private void setFinished() {
        this.finished = true;
    }

    public boolean isFinished() {
        return finished;
    }

}
