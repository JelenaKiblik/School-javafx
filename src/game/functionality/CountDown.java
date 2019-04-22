package game.functionality;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class CountDown {

    /**
     * Label for the count down numbers.
     */
    private Label countDown = new Label();
    /**
     * Count down starting point.
     */
    private int countNr = 2;
    /**
     * Checks if count down is finished.
     */
    private boolean finished;
    /**
     * Countdown label y coordinates.
     */
    private static final int COUNTDOWN_Y_COORDINATES = 300;
    /**
     * Countdown label x coordinates.
     */
    private static final int COUNTDOWN_X_COORDINATES = 300;
    /**
     * Duration dor countdown zero.
     */
    private static final int COUNTDOWN_ZERO_DURATION = 3000;
    /**
     * Duration for countdown one.
     */
    private static final int COUNTDOWN_ONE_DURATION = 2000;
    /**
     * Duration for countdown two.
     */
    private static final int COUNTDOWN_TWO_DURATION = 1000;
    /**
     * Countdown decrease.
     */
    private static final int COUNTDOWN_DECREASE = 2;

    /**
     * Count down for the game to start.
     *
     * @param root root for the firstScene.
     */
    public void countdown(Group root) {
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

    /**
     * Set count down finished.
     */
    private void setFinished() {
        this.finished = true;
    }

    /**
     * Checks if count down is finished.
     *
     * @return boolean.
     */
    public boolean isFinished() {
        return finished;
    }

}
