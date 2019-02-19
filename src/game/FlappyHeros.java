package game;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class FlappyHeros extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        StackPane root = new StackPane();
        Scene scene = new Scene(root, 800, 600);

        Button startButton = new Button("Alusta");
        Button instructions = new Button("Juhised");
        Button settings = new Button("Seaded");
        Button exit = new Button("Välju");
        Button scoreBoard = new Button("Edetabel");

        VBox vbButtons = new VBox();
        vbButtons.setSpacing(50);
        vbButtons.setPadding(new Insets(200, 0, 0, 350));
        vbButtons.getChildren().addAll(startButton, instructions, settings, scoreBoard ,exit);

        BackgroundImage myBI= new BackgroundImage(new Image("game/super_hero.jpg",800,600,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        root.setBackground(new Background(myBI));

        root.getChildren().addAll(vbButtons);
        primaryStage.setTitle("FlappyHeros");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
