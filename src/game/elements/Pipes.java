package game.elements;

import game.scoreboard.Scoreboard;
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
    /**
     * Random number generator for pipes height.
     */
    private Random random = new Random();
    /**
     * Image for the pipes.
     */
    private Image pipeImage = new Image("resources/pipe.png");
    /**
     * Imageview for the first pipe.
     */
    private ImageView pipeOne = new ImageView(pipeImage);
    /**
     * Imageview for the second pipe.
     */
    private ImageView pipeTwo = new ImageView(pipeImage);
    /**
     * Imageview for the third pipe.
     */
    private ImageView pipeThree = new ImageView(pipeImage);
    /**
     * Imageview for the fourth pipe.
     */
    private ImageView pipeFour = new ImageView(pipeImage);
    /**
     * Checks if game is over, in the beginning it is false.
     */
    private boolean gameOver = false;
    /**
     * Timeline for the pipes to start moving.
     */
    private Timeline pipeStart = new Timeline();
    /**
     * Timeline for the second row of pipes to start moving.
     */
    private Timeline secondPipeStart = new Timeline();
    /**
     * Rotation for the pipes.
     */
    private static final int ROTATION = 180;
    /**
     * Default x coordinates for pipes.
     */
    private static final int PIPE_X_COORDINATES = 800;
    /**
     * First pipe y coordinates.
     */
    private static final int FIRST_PIPE_Y_COORDINATES = 350;
    /**
     * First pipe height.
     */
    private static final int FIRST_PIPE_HEIGHT = 250;
    /**
     * Second pipe y coordinates.
     */
    private static final int SECOND_PIPE_Y_COORDINATES = 0;
    /**
     * Default pipe width.
     */
    private static final int PIPE_WIDTH = 100;
    /**
     * Second pipe height.
     */
    private static final int SECOND_PIPE_HEIGHT = 140;
    /**
     * Third pipe y coordinates.
     */
    private static final int THIRD_PIPE_Y_COORDINATES = 0;
    /**
     * Third pipe height.
     */
    private static final int THIRD_PIPE_HEIGHT = 250;
    /**
     * Fourth pipe y coordinates.
     */
    private static final int FOURTH_PIPE_Y_COORDINATES = 400;
    /**
     * Fourth pipe height.
     */
    private static final int FOURTH_PIPE_HEIGHT = 200;
    /**
     *  The first pipes duration.
     */
    private static final int FIRST_PIPES_MOVING_DURATION = 3;
    /**
     *  The second pipes duration.
     */
    private static final int SECOND_PIPES_MOVING_DURATION = 3;
    /**
     * The first pipes moving delay duration.
     */
    private static final int PIPES_MOVING_DELAY_DURATION = 3;
    /**
     * The second pipes moving delay duration.
     */
    private static final double SECOND_PIPES_MOVING_DELAY_DURATION = 4.5;
    /**
     * Highest pipe that is allowed.
     */
    private static final int HIGHEST_PIPE_ALLOWED = 250;
    /**
     * Lowest pipe that is allowed.
     */
    private static final int LOWEST_PIPE_ALLOWED = 100;
    /**
     * Timeline duration that checks for collision between hero and pipe.
     */
    private static final int GAME_OVER_TOUCHED_PIPE_DURATION = 500;

    /**
     * Making the first pipe.
     *
     * @return second pipe.
     */
    public ImageView makeFirstPipe() {
        pipeTwo.setRotate(ROTATION);
        pipeTwo.setX(PIPE_X_COORDINATES);
        pipeTwo.setY(SECOND_PIPE_Y_COORDINATES);
        pipeTwo.setFitWidth(PIPE_WIDTH);
        pipeTwo.setFitHeight(SECOND_PIPE_HEIGHT);
        return pipeTwo;
    }

    /**
     * Making the second pipe.
     *
     * @return first pipe.
     */
    public ImageView makeSecondPipe() {
        pipeOne.setX(PIPE_X_COORDINATES);
        pipeOne.setY(FIRST_PIPE_Y_COORDINATES);
        pipeOne.setFitHeight(FIRST_PIPE_HEIGHT);
        pipeOne.setFitWidth(PIPE_WIDTH);
        return pipeOne;
    }


    /**
     * Making the third pipe.
     *
     * @return third pipe.
     */
    public ImageView makeThirdPipe() {
        pipeThree.setRotate(ROTATION);
        pipeThree.setX(PIPE_X_COORDINATES);
        pipeThree.setY(THIRD_PIPE_Y_COORDINATES);
        pipeThree.setFitWidth(PIPE_WIDTH);
        pipeThree.setFitHeight(THIRD_PIPE_HEIGHT);
        return pipeThree;
    }

    /**
     * Making fourth pipe.
     *
     * @return fourth pipe.
     */
    public ImageView makeFourthPipe() {
        pipeFour.setX(PIPE_X_COORDINATES);
        pipeFour.setY(FOURTH_PIPE_Y_COORDINATES);
        pipeFour.setFitWidth(PIPE_WIDTH);
        pipeFour.setFitHeight(FOURTH_PIPE_HEIGHT);
        return pipeFour;
    }

    /**
     * Pipes start to move.
     *
     * @param root  root for the firstScene.
     * @param scoreboard game score.
     */
    public void startPipes(Group root, Scoreboard scoreboard) {
        Bounds bounds = root.getBoundsInLocal();
        KeyValue secondPipe = new KeyValue(pipeTwo.xProperty(), bounds.getMinX());
        KeyValue firstPipe = new KeyValue(pipeOne.xProperty(), bounds.getMinX());
        KeyValue thirdPipe = new KeyValue(pipeThree.xProperty(), bounds.getMinX());
        KeyValue fourthPipe = new KeyValue(pipeFour.xProperty(), bounds.getMinX());
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(FIRST_PIPES_MOVING_DURATION), event1 -> {
            scoreboard.addScore(1);
            scoreboard.showScore();
            pipeTwo.setFitHeight(random.nextInt((HIGHEST_PIPE_ALLOWED - LOWEST_PIPE_ALLOWED) + 1) +
                    LOWEST_PIPE_ALLOWED);
        }, firstPipe, secondPipe);
        KeyFrame keyFrame2 = new KeyFrame(Duration.seconds(SECOND_PIPES_MOVING_DURATION), event2 -> {
            scoreboard.addScore(1);
            scoreboard.showScore();
            pipeThree.setFitHeight(random.nextInt((HIGHEST_PIPE_ALLOWED - LOWEST_PIPE_ALLOWED) + 1) +
                    LOWEST_PIPE_ALLOWED);
        }, thirdPipe, fourthPipe);
        pipeStart.getKeyFrames().addAll(keyFrame);
        pipeStart.setCycleCount(Timeline.INDEFINITE);
        pipeStart.setDelay(Duration.seconds(PIPES_MOVING_DELAY_DURATION));
        pipeStart.play();
        secondPipeStart.getKeyFrames().addAll(keyFrame2);
        secondPipeStart.setCycleCount(Timeline.INDEFINITE);
        secondPipeStart.setDelay(Duration.seconds(SECOND_PIPES_MOVING_DELAY_DURATION));
        secondPipeStart.play();
    }

    /**
     * Game is over because character touched pipe.
     *
     * @param chosenCharacter character used for playing.
     * @param readyForNewGame checks if countdown is finished.
     * @param playerName      name of the player.
     * @param scoreboard      game score.
     */
    public void gameOverTouchedPipe(ImageView chosenCharacter, AnimationTimer readyForNewGame, Scoreboard scoreboard,
                                    String playerName) {
        Timeline gameOverTouchedPipe = new Timeline();
        KeyFrame keyFrame = new KeyFrame(Duration.millis(GAME_OVER_TOUCHED_PIPE_DURATION), event -> {
            Bounds character = chosenCharacter.localToScene(chosenCharacter.getBoundsInLocal());
            Bounds firstPipe = pipeOne.localToScene(pipeOne.getBoundsInLocal());
            Bounds secondPipe = pipeTwo.localToScene(pipeTwo.getBoundsInLocal());
            Bounds thirdPipe = pipeThree.localToScene(pipeThree.getBoundsInLocal());
            Bounds fourthPipe = pipeFour.localToScene(pipeFour.getBoundsInLocal());
            if (character.intersects(firstPipe) || character.intersects(secondPipe) ||
                    character.intersects(thirdPipe) || character.intersects(fourthPipe) || gameOver) {
                gameOver = true;
                readyForNewGame.stop();
                pipeStart.stop();
                secondPipeStart.stop();
                scoreboard.writeScoresToFile(playerName);
                gameOverTouchedPipe.stop();
                pipeStart.getKeyFrames().clear();
                secondPipeStart.getKeyFrames().clear();
            }
        });
        gameOverTouchedPipe.getKeyFrames().addAll(keyFrame);
        gameOverTouchedPipe.setCycleCount(Timeline.INDEFINITE);
        gameOverTouchedPipe.play();
    }

    /**
     * Game over because hero moved out of screen.
     *
     * @param readyForNewGame checks if countdown is finished.
     * @param playerName      name of the player.
     * @param scoreboard      game score.
     */
    public void gameOverOutOfScreen(AnimationTimer readyForNewGame, String playerName, Scoreboard scoreboard)
            throws IOException {
        readyForNewGame.stop();
        pipeStart.stop();
        secondPipeStart.stop();
        pipeStart.getKeyFrames().clear();
        scoreboard.writeScoresToFile(playerName);
        secondPipeStart.getKeyFrames().clear();
    }

    /**
     * Checks if game is over.
     *
     * @return boolan.
     */
    public boolean isGameOver() {
        return gameOver;
    }

    /**
     * Set game to be over
     *
     * @param gameOver boolean.
     */
    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    /**
     * Getter for pipe one.
     *
     * @return first pipe.
     */
    public ImageView getPipeOne() {
        return pipeOne;
    }

    /**
     * Getter for pipe two.
     *
     * @return second pipe.
     */
    public ImageView getPipeTwo() {
        return pipeTwo;
    }

    /**
     * Getter for pipe three.
     *
     * @return third pipe.
     */
    public ImageView getPipeThree() {
        return pipeThree;
    }

    /**
     * Getter for pipe four.
     *
     * @return fourth pipe.
     */
    public ImageView getPipeFour() {
        return pipeFour;
    }

}

