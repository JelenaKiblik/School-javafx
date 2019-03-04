package game.Instructions;

import javafx.scene.control.Label;
import java.io.IOException;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;


public class Instructions {
    
    private Label info = new Label();
    private Label heading = new Label();

    private static final int HEADING_X_COORDINATES = 15;
    private static final int HEADING_Y_COORDINATES = 60;

    public Label showInfo() throws IOException {
        info.setText("- Mängu alustades on vaja sisestada nimi ja valida oma hero\n" +
                "- Hero liigutamiseks on vaja vajutada ekraanile\n" +
                "- Mäng läbi kui hero puudutab takistus\n" +
                "- Mäng läbi kui hero kukkub\n");
        info.setTranslateX(15);
        info.setTranslateY(160);
        info.setFont(new Font("Arial", 25));
        info.setTextFill(Color.WHITE);
        return info;
    }

    public Label heading() {
        heading.setText("Juhend");
        heading.setTranslateX(HEADING_X_COORDINATES);
        heading.setTranslateY(HEADING_Y_COORDINATES);
        heading.getStyleClass().add("instructionsHeading");
        heading.setTextFill(Color.WHITE);
        return heading;
    }
}
