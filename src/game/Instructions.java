package game;

import javafx.scene.control.Label;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Instructions {

    private Label info = new Label();
    private Label heading = new Label();
    private static final int HEADING_X_COORDINATES = 15;
    private static final int HEADING_Y_COORDINATES = 60;
    private static final int INFO_X_COORDINATES = 15;
    private static final int INFO_y_COORDINATES = 160;

    public Label showInfo() throws IOException {
        File file = new File("/game/instructions.txt");
        FileInputStream fis = new FileInputStream(file);
        byte[] data = new byte[(int) file.length()];
        fis.read(data);
        fis.close();
        String str = new String(data, "UTF-8");
        info.setText(str);
        info.setTranslateX(INFO_X_COORDINATES);
        info.setTranslateY(INFO_y_COORDINATES);
        info.getStyleClass().add("instructions");
        return info;
    }

    public Label heading() {
        heading.setText("Juhend");
        heading.setTranslateX(HEADING_X_COORDINATES);
        heading.setTranslateY(HEADING_Y_COORDINATES);
        heading.getStyleClass().add("instructionsHeading");
        return heading;
    }
}
