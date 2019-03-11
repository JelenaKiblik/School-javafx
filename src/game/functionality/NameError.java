package game.functionality;

import javafx.scene.control.Alert;

public class NameError {
    public static void noNameInsertedError() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setContentText("Nimi on sisestamata");
        alert.showAndWait();
    }

    public static void nameTooLongError() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setContentText("Liiga piik nimi!");
        alert.showAndWait();
    }

}
