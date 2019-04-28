package game.scoreboard;

import javafx.scene.Group;
import javafx.scene.control.Label;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Scoreboard {
    /**
     * Label for displaying score.
     */
    private Label scoreLabel = new Label();
    /**
     * Score in the beginning of the game.
     */
    private int score = 0;
    /**
     * Hashmap for adding score.
     */
    private Map<Integer, String> addToScores = new HashMap<>();
    /**
     * Hashmap for displaying scores.
     */
    private Map<Integer, String> addToOutput = new HashMap<>();
    /**
     * First high score y coordinate.
     */
    private static final int HIGH_SCORES_Y_COODRINATE = 150;
    /**
     * High score y coordinate increase.
     */
    private static final int HIGH_SCORES_Y_COODRINATE_INCREASES = 50;
    /**
     * Player name x coordinates.
     */
    private static final int PLAYER_NAME_X_COORDINATES = 200;

    /**
     * Getter for the game score.
     *
     * @return game score.
     */
    private int getScore() {
        return score;
    }

    /**
     * Add score.
     *
     * @param amount amount of score that will be added.
     */
    public void addScore(int amount) {
        score += amount;
    }

    /**
     * Displaying score.
     *
     * @return scoreLabel.
     */
    public Label showScore() {
        scoreLabel.setText("Score: " + String.valueOf(getScore()));
        scoreLabel.getStyleClass().add("labelGameScore");
        return scoreLabel;
    }

    /**
     * Writing all the scores to file.
     *
     * @param name name of the player.
     */
    public void writeScoresToFile(String name) {
        addToScores.put(score, name);
        File file = new File("scores.txt");
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
            for (Integer p : addToScores.keySet()) {
                bw.write(score + " : " + name);
                bw.newLine();
            }
            bw.flush();
            bw.close();
        } catch (Exception e) {
            System.out.println("Can't write to file!");
        }
    }

    /**
     * Sorting scores, changing format.
     *
     * @throws IOException for FileInputStream.
     */
    private void sortScores() throws IOException {
        File input = new File("scores.txt");
        FileInputStream fis = new FileInputStream(input);
        BufferedReader in = new BufferedReader(new InputStreamReader(fis));
        String aLine;
        while ((aLine = in.readLine()) != null) {
            String[] scoreAndName = aLine.split(" : ");
            int scoreFromMap = Integer.parseInt(scoreAndName[0]);
            String nameFromMap = scoreAndName[1];
            addToOutput.put(scoreFromMap, nameFromMap);
        }
        File output = new File("outputscores.txt");
        FileOutputStream fos = new FileOutputStream(output);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));
        Map<Integer, String> treeMap = new TreeMap<>(
                (o1, o2) -> {
                    if (o1 <= o2) {
                        return 1;
                    } else {
                        return -1;
                    }
                });
        treeMap.putAll(addToOutput);
        try {
            out.write(treeMap.toString());
            out.flush();
            out.close();
        } catch (Exception e) {
            System.out.println("Can't write to file!");
        }
    }

    /**
     * Read scores from the file to highscore page.
     *
     * @param scores all the scores.
     * @throws IOException for sorting scores.
     */
    public void readScores(Group scores) throws IOException {
        int y = HIGH_SCORES_Y_COODRINATE;
        sortScores();
        File file = new File("C:\\Users\\Annika\\IdeaProjects\\iti0202-2019-gui\\outputscores.txt");
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String l;
            int argscounts = 0;
            while ((l = br.readLine()) != null) {
                String newLine = l.substring(1, l.length() - 1);
                String[] args = newLine.split(", ");
                for (String s : args) {
                    Label playerName = new Label();
                    playerName.setTranslateX(PLAYER_NAME_X_COORDINATES);
                    playerName.setTranslateY(y);
                    playerName.setText(args[argscounts].replaceAll("=", " : "));
                    argscounts++;
                    y += HIGH_SCORES_Y_COODRINATE_INCREASES;
                    playerName.getStyleClass().add("labelHighScore");
                    scores.getChildren().addAll(playerName);
                }
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Can't read from file!");
        }
    }

    /**
     * Making score back to zero before new game starts.
     */
    public void scoreToZero() {
        addScore(-score);
    }
}
