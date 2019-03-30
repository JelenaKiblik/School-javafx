package game.elements;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.io.IOException;
import java.util.Random;

public class Pipes {
    private Random random = new Random();
    private Image pipeImage = new Image("resources/pipe.png");
    private ImageView pipeOne = new ImageView(pipeImage);
    private ImageView pipeTwo = new ImageView(pipeImage);
    private ImageView pipeThree = new ImageView(pipeImage);
    private ImageView pipeFour = new ImageView(pipeImage);
    private boolean gameOver = false;
    private Timeline pipeStart = new Timeline();
    private Timeline secondPipeStart = new Timeline();
    private static final int ROTATION = 180;
    private static final int PIPE_X_COORDINATES = 800;
    private static final int SECOND_PIPE_Y_COORDINATES = 0;
    private static final int PIPE_WIDTH = 100;
    private static final int SECOND_PIPE_HEIGHT = 140;
    private static final int FIRST_PIPE_Y_COORDINATES = 350;
    private static final int FIRST_PIPE_HEIGHT = 250;
    private static final int THIRD_PIPE_Y_COORDINATES = 0;
    private static final int THIRD_PIPE_HEIGHT = 250;
    private static final int FOURTH_PIPE_Y_COORDINATES = 400;
    private static final int FOURTH_PIPE_HEIGHT = 200;
    private static final int FIRST_PIPES_MOVING_DURATION = 3;
    private static final int SECOND_PIPES_MOVING_DURATION = 3;
    private static final int PIPES_MOVING_DELAY_DURATION = 3;
    private static final double SECOND_PIPES_MOVING_DELAY_DURATION = 4.5;
    private static final int HIGHEST_PIPE_ALLOWED = 250;
    private static final int LOWEST_PIPE_ALLOWED = 100;
    private static final int GAME_OVER_TOUCHED_PIPE_DURATION = 500;

    public ImageView makeFirstPipe() {
        pipeTwo.setRotate(ROTATION);
        pipeTwo.setX(PIPE_X_COORDINATES);
        pipeTwo.setY(SECOND_PIPE_Y_COORDINATES);
        pipeTwo.setFitWidth(PIPE_WIDTH);
        pipeTwo.setFitHeight(SECOND_PIPE_HEIGHT);
        return pipeTwo;
    }

    public ImageView makeSecondPipe() {
        pipeOne.setX(PIPE_X_COORDINATES);
        pipeOne.setY(FIRST_PIPE_Y_COORDINATES);
        pipeOne.setFitHeight(FIRST_PIPE_HEIGHT);
        pipeOne.setFitWidth(PIPE_WIDTH);
        return pipeOne;
    }

    public ImageView makeThirdPipe() {
        pipeThree.setRotate(ROTATION);
        pipeThree.setX(PIPE_X_COORDINATES);
        pipeThree.setY(THIRD_PIPE_Y_COORDINATES);
        pipeThree.setFitWidth(PIPE_WIDTH);
        pipeThree.setFitHeight(THIRD_PIPE_HEIGHT);
        return pipeThree;
    }

    public ImageView makeFourthPipe() {
        pipeFour.setX(PIPE_X_COORDINATES);
        pipeFour.setY(FOURTH_PIPE_Y_COORDINATES);
        pipeFour.setFitWidth(PIPE_WIDTH);
        pipeFour.setFitHeight(FOURTH_PIPE_HEIGHT);
        return pipeFour;
    }

    public void startPipes(Group root) {
        Bounds bounds = root.getBoundsInLocal();
        KeyValue secondFork = new KeyValue(pipeTwo.xProperty(), bounds.getMinX());
        KeyValue firstFork = new KeyValue(pipeOne.xProperty(), bounds.getMinX());
        KeyValue thirdFork = new KeyValue(pipeThree.xProperty(), bounds.getMinX());
        KeyValue fourthFork = new KeyValue(pipeFour.xProperty(), bounds.getMinX());
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(FIRST_PIPES_MOVING_DURATION), event1 -> {
            pipeTwo.setFitHeight(random.nextInt((HIGHEST_PIPE_ALLOWED - LOWEST_PIPE_ALLOWED) + 1) +
                    LOWEST_PIPE_ALLOWED);
        }, firstFork, secondFork);
        KeyFrame keyFrame2 = new KeyFrame(Duration.seconds(SECOND_PIPES_MOVING_DURATION), event2 -> {
            pipeThree.setFitHeight(random.nextInt((HIGHEST_PIPE_ALLOWED - LOWEST_PIPE_ALLOWED) + 1) +
                    LOWEST_PIPE_ALLOWED);
        }, thirdFork, fourthFork);
        pipeStart.getKeyFrames().addAll(keyFrame);
        pipeStart.setCycleCount(Timeline.INDEFINITE);
        pipeStart.setDelay(Duration.seconds(PIPES_MOVING_DELAY_DURATION));
        pipeStart.play();
        secondPipeStart.getKeyFrames().addAll(keyFrame2);
        secondPipeStart.setCycleCount(Timeline.INDEFINITE);
        secondPipeStart.setDelay(Duration.seconds(SECOND_PIPES_MOVING_DELAY_DURATION));
        secondPipeStart.play();
    }

    public void gameOverTouchedPipe(ImageView chosenCharacter, AnimationTimer readyForNewGame) {
        Timeline gameOverTouchedFork = new Timeline();
        KeyFrame keyFrame = new KeyFrame(Duration.millis(GAME_OVER_TOUCHED_PIPE_DURATION), event -> {
            Bounds character = chosenCharacter.localToScene(chosenCharacter.getBoundsInLocal());
            Bounds firstFork = pipeOne.localToScene(pipeOne.getBoundsInLocal());
            Bounds secondFork = pipeTwo.localToScene(pipeTwo.getBoundsInLocal());
            Bounds thirdFork = pipeThree.localToScene(pipeThree.getBoundsInLocal());
            Bounds fourthFork = pipeFour.localToScene(pipeFour.getBoundsInLocal());
            if (character.intersects(firstFork) || character.intersects(secondFork) ||
                    character.intersects(thirdFork) || character.intersects(fourthFork) || gameOver) {
                gameOver = true;
                readyForNewGame.stop();
                pipeStart.stop();
                secondPipeStart.stop();
                gameOverTouchedFork.stop();
                pipeStart.getKeyFrames().clear();
                secondPipeStart.getKeyFrames().clear();
            }
        });
        gameOverTouchedFork.getKeyFrames().addAll(keyFrame);
        gameOverTouchedFork.setCycleCount(Timeline.INDEFINITE);
        gameOverTouchedFork.play();
    }

    public void gameOverOutOfScreen(AnimationTimer readyForNewGame) throws IOException {
        readyForNewGame.stop();
        pipeStart.stop();
        secondPipeStart.stop();
        pipeStart.getKeyFrames().clear();
        secondPipeStart.getKeyFrames().clear();
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public ImageView getPipeOne() {
        return pipeOne;
    }

    public ImageView getPipeTwo() {
        return pipeTwo;
    }

    public ImageView getPipeThree() {
        return pipeThree;
    }

    public ImageView getPipeFour() {
        return pipeFour;
    }

}

