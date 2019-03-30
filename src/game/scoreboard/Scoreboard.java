package game.scoreboard;

import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Scoreboard {
    private int score = 0;
    private Map<Integer, String> addScores = new HashMap<>();

    public void writeScoresToFile(String name) {
        addScores.put(score, name);
        File file = new File("scores.txt");
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
            for (Integer p : addScores.keySet()) {
                bw.write(score + " : " + name);
                bw.newLine();
            }
            bw.flush();
            bw.close();
        } catch (Exception e) {
            System.out.println("Can't write to file!");
        }
    }

    public void readScores(Group scores) throws IOException {
        File file = new File("C:\\Users\\Annika\\IdeaProjects\\iti0202-2019-gui\\scores.txt");
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String l;
            int sum = 0;
            while ((l = br.readLine()) != null) {
                    Label playerName = new Label();
                    playerName.setTranslateX(500);
                    playerName.setTranslateY(sum);
                    sum += 10;
                    playerName.setText(l);
                    playerName.getStyleClass().add("instructionsBorder");
                    scores.getChildren().addAll(playerName);
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Can't read from file!");
        }
    }




}
