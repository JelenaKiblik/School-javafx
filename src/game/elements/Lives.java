package game.elements;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class Lives {

    private Image lifeImage = new Image(getClass().getResourceAsStream("/resources/life.png"));
    private ImageView firstLife = new ImageView(lifeImage);
    private ImageView secondLife = new ImageView(lifeImage);
    private VBox lives = new VBox(firstLife, secondLife);
    private int livesCount;
    private boolean gameOver = false;
    private static final int MAX_LIVES = 2;
    private static final int ONE_LIFE_LOST = MAX_LIVES - 1;

    public VBox getLives() {
        return lives;
    }

    public void setLivesCount() {
        this.livesCount = MAX_LIVES;
    }

    public void loseALife() {
        livesCount--;
    }

    public int getLivesCount() {
        return livesCount;
    }

    public void removeHeart() {
        if (getLivesCount() == 1) {
            secondLife.setVisible(false);
        } else if (getLivesCount() == 0) {
            firstLife.setVisible(false);
            gameOver = true;
        }
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void livesForNewGame() {
        setLivesCount();
        firstLife.setVisible(true);
        secondLife.setVisible(true);
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }
}
