package game.character;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

public class Character {

    /**
     * Label for the heading.
     */
    private Label heading = new Label();
    /**
     * Image for the.
     */
    private Image imageSpiderman = new Image(getClass().getResourceAsStream("/resources/spiderman_character.png"));
    /**
     * Image for the.
     */
    private Image imageBatman = new Image(getClass().getResourceAsStream("/resources/batman_character.png"));
    /**
     * Image for the.
     */
    private Image imageSuperman = new Image(getClass().getResourceAsStream("/resources/superman_character.png"));
    /**
     * Image for the.
     */
    private Image imageSpidermanChosen = new Image(getClass().getResourceAsStream("/resources/spiderman_chosen.png"));
    /**
     * Image for the.
     */
    private Image imageBatmanChosen = new Image(getClass().getResourceAsStream("/resources/batman_chosen.png"));
    /**
     * Image for the.
     */
    private Image imageSupermanChosen = new Image(getClass().getResourceAsStream("/resources/superman_chosen.png"));
    /**
     * Image for the.
     */
    private ImageView imageSpidermanPicked = new ImageView(imageSpiderman);
    /**
     * Image for the.
     */
    private ImageView imageBatmanPicked = new ImageView(imageBatman);
    /**
     * Image for the.
     */
    private ImageView imageSupermanPicked = new ImageView(imageSuperman);
    /**
     * Image for the.
     */
    private ImageView chosenCharacter = new ImageView();
    /**
     * HBox for character selection.
     */
    private HBox characterOptions = new HBox(imageSpidermanPicked, imageSupermanPicked, imageBatmanPicked);

    /**
     * @return heading.
     */
    public Label showHeading() {
        heading.setText("Vali karakter");
        heading.setTranslateX(270);
        heading.setTranslateY(50);
        heading.setFont(new Font("Arial", 50));
        heading.getStyleClass().add("headingBorder");
        return heading;
    }

    /**
     * @return spider-man image.
     */
    public Image getSpidermanCharacterChosen() { return imageSpidermanChosen; }

    /**
     * @return batman image.
     */
    public Image getBatmanCharacterChosen() {
        return imageBatmanChosen;
    }

    /**
     * @return superman image.
     */
    public Image getSupermanCharacterChosen() {
        return imageSupermanChosen;
    }

    /**
     * @return chosen character.
     */
    public ImageView getChosenCharacter() {
        return chosenCharacter;
    }

    /**
     * @return  spider-man image.
     */
    public Image getSpiderman() {
        return imageSpiderman;
    }

    /**
     * @return superman image.
     */
    public Image getSuperman() {
        return imageSuperman;
    }

    /**
     * @return batman image.
     */
    public Image getBatman() {
        return imageBatman;
    }

    /**
     * @return spider-man image view.
     */
    public ImageView getSpidermanCharacterPicked() {
        return imageSpidermanPicked;
    }

    /**
     * @return batman image view.
     */
    public ImageView getBatmanCharacterPicked() { return imageBatmanPicked; }

    /**
     * @return superman image view.
     */
    public ImageView getSupermanCharacterPicked() {
        return imageSupermanPicked;
    }

    /**
     * @return characterOptions hbox.
     */
    public HBox getCharacterOptions() {
        return characterOptions;
    }

}
