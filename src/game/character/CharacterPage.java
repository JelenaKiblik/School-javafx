package game.character;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class CharacterPage {
    private Label heading = new Label();
    private Image imageSpiderman = new Image("game/spiderman_character.png");
    private Image imageBatman = new Image("game/batman_character.png");
    private Image imageSuperman = new Image("game/superman_character.png");

    public Label showHeading() {
        heading.setText("Vali karakter");
        heading.setTranslateX(15);
        heading.setTranslateY(-200);
        heading.setFont(new Font("Arial", 50));
        heading.setTextFill(Color.WHITE);
        return heading;
    }

    public ImageView spidermanCharacter() {
        ImageView spidermanCharacter = new ImageView(imageSpiderman);
        spidermanCharacter.setTranslateX(-200);
        spidermanCharacter.setTranslateY(0);
        spidermanCharacter.setFitHeight(200);
        spidermanCharacter.setFitWidth(200);
        return spidermanCharacter;
    }

    public ImageView batmanCharacter() {
        ImageView batmanCharacter = new ImageView(imageBatman);
        batmanCharacter.setTranslateX(0);
        batmanCharacter.setTranslateY(0);
        batmanCharacter.setFitHeight(200);
        batmanCharacter.setFitWidth(200);
        return batmanCharacter;
    }

    public ImageView supermanCharacter() {
        ImageView supermanCharacter = new ImageView(imageSuperman);
        supermanCharacter.setTranslateX(200);
        supermanCharacter.setTranslateY(0);
        supermanCharacter.setFitHeight(200);
        supermanCharacter.setFitWidth(200);
        return supermanCharacter;
    }


}
