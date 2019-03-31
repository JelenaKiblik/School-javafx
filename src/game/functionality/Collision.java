package game.functionality;


import game.elements.Lives;
import javafx.animation.Timeline;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Collision {

    private static final int POINTS_FOR_SHOOTING = 2;

    public void collide(ImageView chosenCharacter, Boolean shooting, Node enemy, Node bulletFire, Image fireImage,
                        Lives lives) {
        Bounds objCharacter = chosenCharacter.localToScene(chosenCharacter.getBoundsInLocal());
        Bounds objVillain = enemy.localToScene(enemy.getBoundsInLocal());
        if (shooting) {
            Bounds objFire = bulletFire.localToScene(bulletFire.getBoundsInLocal());
            if (objFire.intersects(objVillain) && enemy.isVisible()) {
                enemy.setVisible(false);
                bulletFire.setVisible(false);
            }
        }
        if (objCharacter.intersects(objVillain) && enemy.isVisible()) {
            enemy.setVisible(false);
            lives.loseALife();
            lives.removeHeart();
        }
    }
}
