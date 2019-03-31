package game.elements;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Villains {

    private static final int VILLAINS_SPEED_REGULATOR = 600;
    private Image villainImage = new Image(getClass().getResourceAsStream("/resources/villains.png"));
    private List<Node> villains = new ArrayList<>();
    private static final int VILLAINS_SPEED = -5;
    private int villainsSpeedRegulator = VILLAINS_SPEED_REGULATOR;
    private int villainsCount = villainsSpeedRegulator - 1;
    private Node enemy = null;
    private Random random = new Random();
    private static final int VILLIAN_MAX_Y_COORDINATE = 340;
    private static final int VILLIAN_MIN_Y_COORDINATE = 200;

    public void newEnemy() {
        for (int i = 0; i < villains.size(); i++) {
            if (villains.get(i).getLayoutX() > -villains.get(i).getBoundsInLocal().getWidth()) {
                villains.get(i).relocate(villains.get(i).getLayoutX() + VILLAINS_SPEED, villains.get(i).getLayoutY());
            } else {
                villains.remove(i);
            }
        }
    }

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

    public Node getEnemy() {
        return enemy;
    }
}

