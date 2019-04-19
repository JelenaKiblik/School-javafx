package game.elements;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.ArrayList;
import java.util.List;
import game.character.Character;

public class Fire {

    /**
     * Image for the fire.
     */
    private Image fireImage = new Image(getClass().getResourceAsStream("/resources/fire.png"));
    /**
     * List of fire nodes.
     */
    private List<Node> fires = new ArrayList<>();
    /**
     * Speed for the fire
     */
    private static final int FIRE_SPEED = 12;
    /**
     * Characters class.
     */
    private Character character = new Character();
    /**
     * Node bulletFire.
     */
    private Node bulletFire = null;
    /**
     * Checks if shooting is happening.
     */
    private boolean shooting;
    /**
     * Default fire x coordinate.
     */
    private static final int FIRE_X_COORDINATE = 100;

    /**
     * Getter for the fire image.
     *
     * @return fireImage.
     */
    public Image getFireImage() {
        return fireImage;
    }

    /**
     * Shoot a new fire.
     *
     * @param y coordinate.
     */
    public void shoot(double y) {
        for (int i = 0; i < fires.size(); i++) {
            if (fires.get(i).getLayoutX() < 600) {
                fires.get(i).relocate(fires.get(i).getLayoutX() + fireImage.getWidth() + FIRE_SPEED, y);
            } else {
                shooting = false;
                fires.remove(i);
            }
        }
    }

    /**
     * To shoot a new fire.
     *
     * @param root Group.
     */
    public void newShooting(Group root) {
        Node fire = new ImageView(fireImage);
        fire.relocate(FIRE_X_COORDINATE, character.getChosenCharacter().getLayoutY());
        fires.add(fire);
        for (Node s : fires) {
            bulletFire = s;
            bulletFire.setVisible(true);
        }
        root.getChildren().add(fire);
    }

    /**
     * Get node bulletFire for collision.
     *
     * @return bulletFire.
     */
    public Node getBulletFire() {
        return bulletFire;
    }

    /**
     * Checks if shooting is happening.
     *
     * @return boolean.
     */
    public boolean isShooting() {
        return shooting;
    }


    /**
     * Set shooting true or false.
     *
     * @param shooting boolean.
     */
    public void setShooting(boolean shooting) {
        this.shooting = shooting;
    }
}
