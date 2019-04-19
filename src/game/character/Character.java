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
     * Image for the spider-man.
     */
    private Image imageSpiderman = new Image(getClass().getResourceAsStream("/resources/spiderman_character.png"));
    /**
     * Image for the batman.
     */
    private Image imageBatman = new Image(getClass().getResourceAsStream("/resources/batman_character.png"));
    /**
     * Image for the superman.
     */
    private Image imageSuperman = new Image(getClass().getResourceAsStream("/resources/superman_character.png"));
    /**
     * Image when the spider-man is chosen.
     */
    private Image imageSpidermanChosen = new Image(getClass().getResourceAsStream("/resources/spiderman_chosen.png"));
    /**
     * Image when the batman is chosen.
     */
    private Image imageBatmanChosen = new Image(getClass().getResourceAsStream("/resources/batman_chosen.png"));
    /**
     * Image when the superman is chosen.
     */
    private Image imageSupermanChosen = new Image(getClass().getResourceAsStream("/resources/superman_chosen.png"));
    /**
     * Image view for the spider-man.
     */
    private ImageView imageSpidermanPicked = new ImageView(imageSpiderman);
    /**
     * Image view  for the batman.
     */
    private ImageView imageBatmanPicked = new ImageView(imageBatman);
    /**
     * Image view for the superman.
     */
    private ImageView imageSupermanPicked = new ImageView(imageSuperman);
    /**
     * Image for the shosen character.
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
