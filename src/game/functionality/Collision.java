package game.functionality;

import game.elements.Lives;
import game.scoreboard.Scoreboard;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Collision {

    /**
     * Points for shooting.
     */
    private static final int POINTS_FOR_SHOOTING = 2;

    /**
     * Checks collision when shooting or when character touches pipes or villains.
     *
     * @param chosenCharacter       character chosen for the game.
     * @param shooting              checks if shooting is happening.
     * @param enemy                 villain.
     * @param bulletFire            fire used for shooting.
     * @param fireImage             image for the fire.
     * @param lives                 character lives.
     */
    public void collide(ImageView chosenCharacter, Boolean shooting, Node enemy, Scoreboard scoreboard, Node bulletFire,
                        Image fireImage, Lives lives) {
        Bounds objCharacter = chosenCharacter.localToScene(chosenCharacter.getBoundsInLocal());
        Bounds objVillain = enemy.localToScene(enemy.getBoundsInLocal());

        if (shooting) {
            Bounds objFire = bulletFire.localToScene(bulletFire.getBoundsInLocal());
            if (objFire.intersects(objVillain) && enemy.isVisible()) {
                enemy.setVisible(false);
                bulletFire.setVisible(false);
                scoreboard.addScore(POINTS_FOR_SHOOTING);
            }
        }
        if (objCharacter.intersects(objVillain) && enemy.isVisible()) {
            enemy.setVisible(false);
            lives.loseLife();
            lives.removeLive();
        }
    }
}
