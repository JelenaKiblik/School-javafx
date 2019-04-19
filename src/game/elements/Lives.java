package game.elements;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class Lives {

    /**
     * Image for the life.
     */
    private Image lifeImage = new Image(getClass().getResourceAsStream("/resources/life.png"));
    /**
     * Imageview for the first live.
     */
    private ImageView firstLife = new ImageView(lifeImage);
    /**
     * Imageview for the second life.
     */
    private ImageView secondLife = new ImageView(lifeImage);
    /**
     * VBox for the lives.
     */
    private VBox lives = new VBox(firstLife, secondLife);
    /**
     * Lives count.
     */
    private int livesCount;
    /**
     * Checks if game is over.
     */
    private boolean gameOver = false;
    /**
     * Max lives for the one game.
     */
    private static final int MAX_LIVES = 2;

    /**
     * One live lost in the game.
     */
    private static final int ONE_LIFE_LOST = MAX_LIVES - 1;

    /**
     * Get VBox for the lives.
     *
     * @return VBox lives
     */
    public VBox getLives() {
        return lives;
    }

    /**
     * Set lives count.
     */
    public void setLivesCount() {
        this.livesCount = MAX_LIVES;
    }

    /**
     * Take away one life.
     */
    public void loseLife() {
        livesCount--;
    }

    /**
     * Get lives count.
     *
     * @return livesCount.
     */
    public int getLivesCount() {
        return livesCount;
    }

    /**
     * Set live not visible.
     */
    public void removeLive() {
        if (getLivesCount() == 1) {
            secondLife.setVisible(false);
        } else if (getLivesCount() == 0) {
            firstLife.setVisible(false);
            gameOver = true;
        }
    }

    /**
     * Checks if game is over.
     *
     * @return boolean.
     */
    public boolean isGameOver() {
        return gameOver;
    }

    /**
     * New lives for new game.
     */
    public void livesForNewGame() {
        setLivesCount();
        firstLife.setVisible(true);
        secondLife.setVisible(true);
    }

    /**
     * @param gameOver
     */
    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }
}
