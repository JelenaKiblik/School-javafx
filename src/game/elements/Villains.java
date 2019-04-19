package game.elements;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Villains {

    /**
     * Regulator for the speed.
     */
    private static final int VILLAINS_SPEED_REGULATOR = 600;
    /**
     * Image for the villains.
     */
    private Image villainImage = new Image(getClass().getResourceAsStream("/resources/villains.png"));
    /**
     * Arraylist that contains villain node.
     */
    private List<Node> villains = new ArrayList<>();
    /**
     * Speed for the villain moving.
     */
    private static final int VILLAINS_SPEED = -5;
    /**
     * Regulator for the villain speed.
     */
    private int villainsSpeedRegulator = VILLAINS_SPEED_REGULATOR;
    /**
     * Villains count.
     */
    private int villainsCount = villainsSpeedRegulator - 1;
    /**
     * Enemy node.
     */
    private Node enemy = null;
    /**
     * Random generator for villains location.
     */
    private Random random = new Random();
    /**
     * Maximum y coordinate for the villain.
     */
    private static final int VILLIAN_MAX_Y_COORDINATE = 350;
    /**
     * Minimum y coordinate for the villain.
     */
    private static final int VILLIAN_MIN_Y_COORDINATE = 200;

    /**
     * New villain located.
     */
    public void newEnemy() {
        for (int i = 0; i < villains.size(); i++) {
            if (villains.get(i).getLayoutX() > -villains.get(i).getBoundsInLocal().getWidth()) {
                villains.get(i).relocate(villains.get(i).getLayoutX() + VILLAINS_SPEED, villains.get(i).getLayoutY());
            } else {
                villains.remove(i);
            }
        }
    }

    /**
     * New villain appears on the screen.
     *
     * @param root root for the firstScene.
     */
    public void newVillainAppears(Group root) {
        villainsCount++;
        if (villainsCount % villainsSpeedRegulator == 0) {
            Node villainNode = new ImageView(villainImage);
            villainNode.relocate(600, random.nextInt((VILLIAN_MAX_Y_COORDINATE - VILLIAN_MIN_Y_COORDINATE) +
                    1) + VILLIAN_MIN_Y_COORDINATE);
            villains.add(villainNode);
            for (Node villain : villains) {
                enemy = villain;
                enemy.setVisible(true);
            }
            root.getChildren().add(villainNode);
        }
    }

    /**
     * Get enemy.
     *
     * @return enemy.
     */
    public Node getEnemy() {
        return enemy;
    }
}
