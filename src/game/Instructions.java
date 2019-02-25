package game;

import javafx.scene.control.Label;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Instructions {

    private Label info = new Label();
    private Label heading = new Label();

    public Label showInfo() throws IOException {
        File file = new File("instructions.txt");
        FileInputStream fis = new FileInputStream(file);
        byte[] data = new byte[(int) file.length()];
        fis.read(data);
        fis.close();
        String str = new String(data, "UTF-8");
        info.setText(str);
        return info;
    }

    public Label heading() {
        heading.setText("Juhised");
        return heading;
    }

}
