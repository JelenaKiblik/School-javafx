package game;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class FlappyHeros extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        StackPane root = new StackPane();
        Scene scene = new Scene(root, 800, 600);
        root.getStylesheets().add("game/stylesheet.css");

        Button startButton = new Button("Alusta");
        startButton.getStyleClass().add("buttonDefault");
        Button instructions = new Button("Juhised");
        instructions.getStyleClass().add("buttonDefault");
        Button settings = new Button("Seaded");
        settings.getStyleClass().add("buttonDefault");
        Button scoreBoard = new Button("Edetabel");
        scoreBoard.getStyleClass().add("buttonDefault");
        Button exit = new Button("Välju");
        exit.getStyleClass().add("buttonDefault");

        VBox vbButtons = new VBox();
        vbButtons.setSpacing(30);
        vbButtons.setPadding(new Insets(200, 0, 0, 350));
        vbButtons.getChildren().addAll(startButton, instructions, settings, scoreBoard ,exit);

        BackgroundImage myBI= new BackgroundImage(new Image("game/super_hero.jpg",800,600,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        root.setBackground(new Background(myBI));

        Image image = new Image("game/flappy_logo.png");
        ImageView imageView = new ImageView(image);
        imageView.setTranslateX(0);
        imageView.setTranslateY(-200);

        root.getChildren().addAll(vbButtons, imageView);
        primaryStage.setTitle("FlappyHeros");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
