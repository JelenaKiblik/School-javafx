package game.elements;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.ArrayList;
import java.util.List;
import game.character.Character;

public class Fire {

    private Image regularFireImage = new Image(getClass().getResourceAsStream("/resources/fire.png"));
    private Image fireImage = new Image(getClass().getResourceAsStream("/resources/fire.png"));
    private List<Node> fires = new ArrayList<>();
    private static final int FIRE_SPEED = 10;
    private Character character = new Character();
    private Node bulletFire = null;
    private boolean shooting;
    private static final int FIRE_X_COORDINATE = 100;

    public Image getFireImage() {
        return fireImage;
    }

    public Image getRegularFireImage() {
        return regularFireImage;
    }

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

    public Node getBulletFire() {
        return bulletFire;
    }

    public boolean isShooting() {
        return shooting;
    }

    public void setShooting(boolean shooting) {
        this.shooting = shooting;
    }
}
