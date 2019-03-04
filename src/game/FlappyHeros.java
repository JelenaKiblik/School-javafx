package game;

import game.Instructions.Instructions;
import game.functionality.PageChange;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.io.IOException;

public class FlappyHeros extends Application {

    private StackPane root = new StackPane();
    private Scene scene = new Scene(root, 800, 600);
    private boolean newGame;
    private VBox vbButtons;
    private ImageView imageView;
    private Instructions instructions = new Instructions();
    private Button backButtonForInstructions;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

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

        backButtonForInstructions = new Button("Tagasi");
        backButtonForInstructions.setTranslateX(170);
        backButtonForInstructions.setTranslateY(200);
        backButtonForInstructions.getStyleClass().add("buttonDefault");

        vbButtons = new VBox();
        vbButtons.setSpacing(30);
        vbButtons.setPadding(new Insets(200, 0, 0, 350));
        vbButtons.getChildren().addAll(startButton, instructions, settings, scoreBoard ,exit);

        BackgroundImage myBI = new BackgroundImage(new Image("game/super_hero.jpg",800,600,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        root.setBackground(new Background(myBI));

        Image image = new Image("game/flappy_logo.png");
        imageView = new ImageView(image);
        imageView.setTranslateX(0);
        imageView.setTranslateY(-200);


        startButton.setOnMouseClicked(event -> {
            try {
                newGame = false;
                changePage(PageChange.HEROES);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        instructions.setOnMouseClicked(event -> {
            try {
                changePage(PageChange.INFO);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        backButtonForInstructions.setOnMouseClicked(event -> {
            try {
                changePage(PageChange.HOMEPAGE);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        exit.setOnAction(event -> primaryStage.close());

        root.getChildren().addAll(vbButtons, imageView);
        primaryStage.setTitle("FlappyHeros");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void changePage(PageChange page) throws IOException {
        String name = page.name().toLowerCase();

        if (name.equals("info")) {
            root.getChildren().removeAll(root.getChildren());
            root.getChildren().addAll(instructions.showInfo(), instructions.heading(), backButtonForInstructions);
        }
        if (name.equals("homepage")) {
            root.getChildren().removeAll(root.getChildren());
            root.getChildren().addAll(vbButtons, imageView);
        }
        if (name.equals("game")) {
            root.getChildren().removeAll(root.getChildren());
            Label game = new Label();
            root.getChildren().addAll(game);
            BackgroundImage image = new BackgroundImage(new Image("game/game_background.jpg",800,600,false,true),
                    BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                    BackgroundSize.DEFAULT);
            root.setBackground(new Background(image));
            game.getStyleClass().add("game");
            newGame();

        }
    }

    private void newGame() {
    }

}
