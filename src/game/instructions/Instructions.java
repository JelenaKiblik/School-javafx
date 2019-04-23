package game.instructions;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class Instructions {

    /**
     * Label for the instructions.
     */
    private Label info = new Label();
    /**
     * Label for the heading of instructions.
     */
    private Label heading = new Label();
    /**
     * Heading x coordinates.
     */
    private static final int HEADING_X_COORDINATES = 300;
    /**
     * Heading y coordinates.
     */
    private static final int HEADING_Y_COORDINATES = 150;

    /**
     * Show the instructions.
     *
     * @return label with the instructions.
     */
    public Label showInfo() {
        info.setText("- Mängu alustades on vaja sisestada nimi ja valida oma hero\n" +
                "- Hero liigutamiseks on vaja vajutada ekraanile\n" +
                "- Mäng läbi kui hero puudutab takistus\n" +
                "- Mäng läbi kui hero kukkub\n");
        info.setTranslateX(80);
        info.setTranslateY(250);
        info.getStyleClass().add("instructionsBorder");
        return info;
    }

    /**
     * Show heading of the instructions.
     *
     * @return label with the heading.
     */
    public Label heading() {
        heading.setText("Juhend");
        heading.setTranslateX(HEADING_X_COORDINATES);
        heading.setTranslateY(HEADING_Y_COORDINATES);
        heading.getStyleClass().add("headingBorder");
        heading.setTextFill(Color.WHITE);
        return heading;
    }
}
