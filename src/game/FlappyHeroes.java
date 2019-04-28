package game;

import game.elements.Fire;
import game.elements.Lives;
import game.elements.Pipes;
import game.elements.Villains;
import game.functionality.Collision;
import game.functionality.CountDown;
import game.instructions.Instructions;
import game.functionality.NameError;
import game.functionality.PageChange;
import game.character.Character;
import game.music.Music;
import game.scoreboard.Scoreboard;
import javafx.animation.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.io.IOException;

public class FlappyHeroes extends Application {
    /**
     * Group for the elements.
     */
    private Group root = new Group();
    /**
     * Game scene.
     */
    private Scene scene = new Scene(root, 800, 600);
    /**
     * Vbox for buttons.
     */
    private VBox vbButtons;
    /**
     * ImageView for header.
     */
    private ImageView imageView;
    /**
     * Instructions class for instructions.
     */
    private Instructions instructions = new Instructions();
    /**
     * Button for going back to first page.
     */
    private Button backButton;
    /**
     * Label for inserting name.
     */
    private Label insertName = new Label("Sisesta nimi:");
    /**
     * Player name.
     */
    private String playerName;
    /**
     * TextField for player name.
     */
    private TextField getPlayerName = new TextField();
    /**
     * Character class for characters.
     */
    private Character character = new Character();
    /**
     * For checking if new game has started.
     */
    private boolean newGame;
    /**
     * CountDown class for the countdown before the game starts.
     */
    private CountDown countDown = new CountDown();
    /**
     * Collision class for checking collision between elements.
     */
    private Collision collision = new Collision();
    /**
     * Pipes class for pipes.
     */
    private Pipes pipes = new Pipes();
    /**
     * Music class for music.
     */
    private Music music = new Music();
    /**
     * Chosen character Y coordinates.
     */
    private double characterY;
    /**
     * Character moving up speed.
     */
    private static final int CHARACTER_MOVING_UP_SPEED = 2;
    /**
     * Character height.
     */
    private static final int BRING_CHARACTER_DOWN_HEIGHT = 40;
    /**
     * Play again button.
     */
    private Button playAgain = new Button("Again?");
    /**
     * Scoreboard class for scoreboard.
     */
    private Scoreboard scoreboard = new Scoreboard();
    /**
     * Image for the menu background.
     */
    private Image sceneBackground = new Image("resources/super_hero.jpg");
    /**
     * Imageview for menu background.
     */
    private ImageView background = new ImageView(sceneBackground);
    /**
     * Image for the game background.
     */
    private Image gameImage = new Image("resources/game_background.jpg");
    /**
     * Imageview for the background.
     */
    private ImageView gameplayImage = new ImageView(gameImage);
    /**
     * Fire class for shooting fires.
     */
    private Fire fires = new Fire();
    /**
     * Villains class for enemies.
     */
    private Villains villains = new Villains();
    /**
     * Lives class for checking lives.
     */
    private Lives lives = new Lives();
    /**
     * Lives x coordinate.
     */
    private static final int LIVES_X_COORDINATE = 550;
    /**
     * Lives y coordinate.
     */
    private static final int LIVES_Y_COORDINATE = 10;
    /**
     * Score label x coordinate.
     */
    private static final int SCORE_LABEL_X_COORDINATE = 170;
    /**
     * Score label y coordinate.
     */
    private static final int SCORE_LABEL_Y_COORDINATE = 60;

    /**
     * Starts the game.
     *
     * @param args Objects and stages.
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Start method for the game.
     *
     * @param primaryStage game stage.
     */
    @Override
    public void start(Stage primaryStage) {

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
        backButton.setTranslateX(570);
        backButton.setTranslateY(500);
        backButton.getStyleClass().add("buttonDefault");

        vbButtons = new VBox();
        vbButtons.setSpacing(30);
        vbButtons.setPadding(new Insets(200, 0, 0, 350));
        vbButtons.getChildren().addAll(startButton, instructions, settings, scoreBoard ,exit);


        Image image = new Image("resources/flappy_logo.png");
        imageView = new ImageView(image);
        imageView.setTranslateX(-15);
        imageView.setTranslateY(10);

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
                scoreboard.scoreToZero();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        exit.setOnAction(event -> primaryStage.close());

        playAgain.getStyleClass().add("playAgain");
        playAgain.setOnMouseClicked(event -> {
            try {
                pipes.setGameOver(false);
                changePage(PageChange.HEROES);
                scoreboard.scoreToZero();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        music.musicStartsOrStops();
        background.setFitWidth(800);
        background.setFitHeight(600);
        root.getChildren().addAll(background, vbButtons, imageView);
        primaryStage.setTitle("game.FlappyHeroes");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Page changer for the buttons.
     *
     * @param page enum PageChange
     * @throws IOException for score, instructions and newGame method.
     */
    private void changePage(PageChange page) throws IOException {
        String name = page.name().toLowerCase();
        if (name.equals("heroes")) {
            root.getChildren().removeAll(root.getChildren());
            lives.livesForNewGame();
            character.getCharacterOptions().setTranslateX(110);
            character.getCharacterOptions().setTranslateY(140);
            getPlayerName.setTranslateX(290);
            getPlayerName.setTranslateY(370);
            getPlayerName.getStyleClass().add("getPlayerName");
            insertName.setTranslateX(300);
            insertName.setTranslateY(330);
            insertName.getStyleClass().add("playerName");
            gameplayImage.setFitHeight(600);
            gameplayImage.setFitWidth(800);
            root.getChildren().addAll(gameplayImage, character.showHeading(), character.getCharacterOptions(), getPlayerName, insertName, backButton);
            chooseACharacter();
        }
        if (name.equals("game")) {
            scoreboard.writeScoresToFile(playerName);
            gameplayImage.setFitHeight(600);
            gameplayImage.setFitWidth(800);
            if (playerName.isEmpty()) {
                NameError.noNameInsertedError();
            } else if (getPlayerName.getLength() > 20) {
                NameError.nameTooLongError();
            } else {
                root.getChildren().removeAll(root.getChildren());
                lives.getLives().setTranslateX(LIVES_X_COORDINATE);
                lives.getLives().setTranslateY(LIVES_Y_COORDINATE);
                scoreboard.showScore().setTranslateX(200);
                scoreboard.showScore().setTranslateY(10);
                root.getChildren().addAll(gameplayImage, character.getChosenCharacter(), pipes.makeFirstPipe(), pipes.makeSecondPipe(),
                        pipes.makeThirdPipe(), pipes.makeFourthPipe(), lives.getLives(), scoreboard.showScore()
                );
                newGame();
            }
        }
        if (name.equals("info")) {
            root.getChildren().removeAll(root.getChildren());
            root.getChildren().addAll(background, instructions.showInfo(), instructions.heading(), backButton);
        }
        if (name.equals("settings")) {
            root.getChildren().removeAll(root.getChildren());
            root.getChildren().addAll(background, backButton, music.musicImage());
        }
        if (name.equals("score")) {
            root.getChildren().removeAll(root.getChildren());
            Label scoreLabel = new Label();
            scoreLabel.setTranslateX(SCORE_LABEL_X_COORDINATE);
            scoreLabel.setTranslateY(SCORE_LABEL_Y_COORDINATE);
            scoreLabel.setText("Tulemused");
            scoreLabel.getStyleClass().add("labelScore");
            root.getChildren().addAll(background, backButton, scoreLabel);
            scoreboard.readScores(root);
        }
        if (name.equals("homepage")) {
            root.getChildren().removeAll(root.getChildren());
            root.getChildren().addAll(background, vbButtons, imageView);
        }
        if (name.equals("gameover")) {
            newGame = false;
            actionTimer.stop();
            characterMovingUp.stop();
            root.getChildren().removeAll(character.getChosenCharacter(), villains.getEnemy());
            Label gameOverText = new Label("GAME OVER");
            gameOverText.setTranslateX(300);
            gameOverText.setTranslateY(200);
            gameOverText.getStyleClass().add("labelGameOver");
            if (!root.getChildren().contains(playAgain)) {
                root.getChildren().addAll(gameOverText, playAgain, backButton);
            }
        }
    }

    /**
     * Hero selection.
     */
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

    /**
     * Setting up new game and starting the countdown.
     */
    private void newGame() {
        character.getChosenCharacter().setTranslateX(150);
        character.getChosenCharacter().setTranslateY(250);
        character.getChosenCharacter().setFitWidth(100);
        character.getChosenCharacter().setFitHeight(100);
        countDown.countdown(root);
        pipes.setGameOver(false);
        pipes.startPipes(root, scoreboard);
        lives.setGameOver(false);
        startNewGame.start();
    }

    /**
     * Moving the hero down.
     */
    private void bringDown() {
        characterY = character.getChosenCharacter().getTranslateY() - BRING_CHARACTER_DOWN_HEIGHT;
        character.getChosenCharacter().setTranslateY(characterY);
    }

    /**
     * Animation timer for checking if a new game can start.
     */
    private AnimationTimer startNewGame = new AnimationTimer() {
        @Override
        public void handle(long now) {
            if (countDown.isFinished()) {
                heroMoving();
            }
        }
    };

    /**
     * Animation timer for hero moving up.
     * Game over if hero is out of screen.
     */
    private AnimationTimer characterMovingUp = new AnimationTimer() {
        @Override
        public void handle(long now) {
            characterY = character.getChosenCharacter().getTranslateY() + CHARACTER_MOVING_UP_SPEED;
            character.getChosenCharacter().setTranslateY(characterY);
            if (character.getChosenCharacter().getTranslateY() + 100 >= 800
                    || character.getChosenCharacter().getTranslateY() <= 100) {
                try {
                    pipes.gameOverOutOfScreen(characterMovingUp, playerName, scoreboard);
                    changePage(PageChange.GAMEOVER);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                root.getChildren().remove(character.getChosenCharacter());
                characterMovingUp.stop();
                newGame = false;
                actionTimer.stop();
                if (!root.getChildren().contains(playAgain)) {
                    root.getChildren().add(playAgain);
                }

            }

        }
    };

    /**
     * Hero and pipes start to move.
     * Checks for collision with pipes.
     */
    private void heroMoving() {
        newGame = true;
        startNewGame.stop();
        characterMovingUp.start();
        pipes.gameOverTouchedPipe(character.getChosenCharacter(), characterMovingUp, scoreboard, playerName);
        root.setOnMouseClicked(event -> {
            if (newGame) {
                bringDown();
                keyFunctionsShooting();
                actionTimer.start();
            }
        });
    }

    /**
     * Animationtimer for the villains that appear during the game.
     * Checks for collision and game over.
     */
    private AnimationTimer actionTimer = new AnimationTimer() {
        @Override
        public void handle(long now) {
            villains.newVillainAppears(root);
            fires.shoot(characterY);
            villains.newEnemy();
            if (pipes.isGameOver()) {
                try {
                    actionTimer.stop();
                    changePage(PageChange.GAMEOVER);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (lives.isGameOver()) {
                try {
                    changePage(PageChange.GAMEOVER);
                    pipes.setGameOver(true);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            collision.collide(character.getChosenCharacter(), fires.isShooting(), villains.getEnemy(), scoreboard,
                    fires.getBulletFire(), fires.getFireImage(), lives);
            scoreboard.showScore();
        }
    };

    /**
     * Key functions for shooting fires.
     */
    private void keyFunctionsShooting() {
        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.SPACE) {
                if (!fires.isShooting()) {
                    fires.newShooting(root);
                    fires.setShooting(true);
                }
            }
        });
    }
}
