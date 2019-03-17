package game;

import game.elements.Pipes;
import game.functionality.Collision;
import game.functionality.CountDown;
import game.instructions.Instructions;
import game.functionality.NameError;
import game.functionality.PageChange;
import game.character.Character;
import game.music.Music;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.io.IOException;

public class FlappyHeroes extends Application {

    private StackPane root = new StackPane();
    private Scene scene = new Scene(root, 800, 600);
    private VBox vbButtons;
    private ImageView imageView;
    private Instructions instructions = new Instructions();
    private Button backButton;
    private BackgroundImage myBI;
    private Label insertName = new Label("Sisesta nimi:");
    private String playerName;
    private TextField getPlayerName = new TextField();
    private Character character = new Character();
    private boolean newGame;
    private CountDown countDown = new CountDown();
    private Collision collision = new Collision();
    private Pipes pipes = new Pipes();
    private Music music = new Music();


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        root.getStylesheets().add("resources/stylesheet.css");

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

        backButton = new Button("Tagasi");
        backButton.setTranslateX(170);
        backButton.setTranslateY(200);
        backButton.getStyleClass().add("buttonDefault");

        vbButtons = new VBox();
        vbButtons.setSpacing(30);
        vbButtons.setPadding(new Insets(200, 0, 0, 350));
        vbButtons.getChildren().addAll(startButton, instructions, settings, scoreBoard ,exit);

        myBI = new BackgroundImage(new Image("resources/super_hero.jpg",800,600,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        root.setBackground(new Background(myBI));

        Image image = new Image("resources/flappy_logo.png");
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

        settings.setOnMouseClicked(event -> {
            try {
                changePage(PageChange.SETTINGS);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        scoreBoard.setOnMouseClicked(event -> {
            try {
                changePage(PageChange.SCORE);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        backButton.setOnMouseClicked(event -> {
            try {
                changePage(PageChange.HOMEPAGE);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        exit.setOnAction(event -> primaryStage.close());

        music.musicStartsOrStops();
        root.getChildren().addAll(vbButtons, imageView);
        primaryStage.setTitle("game.FlappyHeroes");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void changePage(PageChange page) throws IOException {
        String name = page.name().toLowerCase();
        if (name.equals("heroes")) {
            root.getChildren().removeAll(root.getChildren());
            BackgroundImage image = new BackgroundImage(new Image("resources/game_background.jpg",800,600, false,true), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
            root.setBackground(new Background(image));
            character.getCharacterOptions().setTranslateX(110);
            character.getCharacterOptions().setTranslateY(140);
            getPlayerName.setTranslateX(0);
            getPlayerName.setTranslateY(90);
            getPlayerName.getStyleClass().add("getPlayerName");
            insertName.setTranslateX(0);
            insertName.setTranslateY(50);
            insertName.getStyleClass().add("playerName");
            root.getChildren().addAll(character.showHeading(), character.getCharacterOptions(), getPlayerName, insertName, backButton);
            chooseACharacter();
        }
        if (name.equals("game")) {
            if (playerName.isEmpty()) {
                NameError.noNameInsertedError();
            } else if (getPlayerName.getLength() > 20) {
                NameError.nameTooLongError();
            } else {
                root.getChildren().removeAll(root.getChildren());
                root.getChildren().addAll(character.getChosenCharacter()
                );
                newGame();
            }
        }
        if (name.equals("info")) {
            root.getChildren().removeAll(root.getChildren());
            root.getChildren().addAll(instructions.showInfo(), instructions.heading(), backButton);
        }
        if (name.equals("settings")) {
            root.getChildren().removeAll(root.getChildren());
            root.getChildren().addAll(backButton, music.musicImage());
        }
        if (name.equals("score")) {
            root.getChildren().removeAll(root.getChildren());
            root.getChildren().addAll(backButton);
        }
        if (name.equals("homepage")) {
            root.getChildren().removeAll(root.getChildren());
            root.setBackground(new Background(myBI));
            root.getChildren().addAll(vbButtons, imageView);
        }
    }

    private void chooseACharacter() {
        character.getBatmanCharacterPicked().setOnMouseEntered(event ->
                character.getBatmanCharacterPicked().setImage(character.getBatman()));
        character.getBatmanCharacterPicked().setOnMouseExited(event ->
                character.getBatmanCharacterPicked().setImage(character.getBatman()));

        character.getSupermanCharacterPicked().setOnMouseEntered(event ->
                character.getSupermanCharacterPicked().setImage(character.getSuperman()));
        character.getSupermanCharacterPicked().setOnMouseExited(event ->
                character.getSupermanCharacterPicked().setImage(character.getSuperman()));

        character.getSpidermanCharacterPicked().setOnMouseEntered(event ->
                character.getSpidermanCharacterPicked().setImage(character.getSpiderman()));
        character.getSpidermanCharacterPicked().setOnMouseExited(event ->
                character.getSpidermanCharacterPicked().setImage(character.getSpiderman()));

        character.getSupermanCharacterPicked().setOnMouseClicked(event -> {
            character.getChosenCharacter().setImage(character.getSupermanCharacterChosen());
            playerName = getPlayerName.getText();
            try {
                changePage(PageChange.GAME);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        character.getBatmanCharacterPicked().setOnMouseClicked(event -> {
            character.getChosenCharacter().setImage(character.getBatmanCharacterChosen());
            playerName = getPlayerName.getText();
            try {
                changePage(PageChange.GAME);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        character.getSpidermanCharacterPicked().setOnMouseClicked(event -> {
            character.getChosenCharacter().setImage(character.getSpidermanCharacterChosen());
            playerName = getPlayerName.getText();
            try {
                changePage(PageChange.GAME);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void newGame() {
        character.getChosenCharacter().setTranslateX(10);
        character.getChosenCharacter().setTranslateY(20);
        startNewGame.start();
    }

    private AnimationTimer startNewGame = new AnimationTimer() {
        @Override
        public void handle(long now) {
            if (countDown.isFinished()) {
                heroMoving();
            }
        }
    };

    private void heroMoving() {
        newGame = true;
        startNewGame.stop();
    }

    private AnimationTimer actionTimer = new AnimationTimer() {
        @Override
        public void handle(long now) {
            if (pipes.isGameOver()) {
                try {
                    actionTimer.stop();
                    changePage(PageChange.GAMEOVER);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            collision.collide();
        }
    };


}
