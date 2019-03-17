package game.character;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Character {

    private Label heading = new Label();

    private Image imageSpiderman = new Image(getClass().getResourceAsStream("/resources/spiderman_character.png"));
    private Image imageBatman = new Image(getClass().getResourceAsStream("/resources/batman_character.png"));
    private Image imageSuperman = new Image(getClass().getResourceAsStream("/resources/superman_character.png"));

    private Image imageSpidermanChosen = new Image(getClass().getResourceAsStream("/resources/spiderman_chosen.png"));
    private Image imageBatmanChosen = new Image(getClass().getResourceAsStream("/resources/batman_chosen.png"));
    private Image imageSupermanChosen = new Image(getClass().getResourceAsStream("/resources/superman_chosen.png"));

    private ImageView imageSpidermanPicked = new ImageView(imageSpiderman);
    private ImageView imageBatmanPicked = new ImageView(imageBatman);
    private ImageView imageSupermanPicked = new ImageView(imageSuperman);


    private ImageView chosenCharacter = new ImageView();

    private HBox characterOptions = new HBox(imageSpidermanPicked, imageSupermanPicked, imageBatmanPicked);


    public Label showHeading() {
        heading.setText("Vali karakter");
        heading.setTranslateX(15);
        heading.setTranslateY(-200);
        heading.setFont(new Font("Arial", 50));
        heading.getStyleClass().add("headingBorder");
        return heading;
    }

    public Image getSpidermanCharacterChosen() { return imageSpidermanChosen; }

    public Image getBatmanCharacterChosen() {
        return imageBatmanChosen;
    }

    public Image getSupermanCharacterChosen() {
        return imageSupermanChosen;
    }

    public ImageView getChosenCharacter() {
        return chosenCharacter;
    }

    public Image getSpiderman() {
        return imageSpiderman;
    }

    public Image getSuperman() {
        return imageSuperman;
    }

    public Image getBatman() {
        return imageBatman;
    }

    public ImageView getSpidermanCharacterPicked() {
        return imageSpidermanPicked;
    }

    public ImageView getBatmanCharacterPicked() { return imageBatmanPicked; }

    public ImageView getSupermanCharacterPicked() {
        return imageSupermanPicked;
    }

    public HBox getCharacterOptions() {
        return characterOptions;
    }

}
