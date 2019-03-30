package game.music;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.nio.file.Paths;

public class Music {

    private MediaPlayer mediaPlayer;
    private boolean musicOn = true;
    private ImageView musicOnOrOff = new ImageView("resources/musicOn.png");
    private Image musicOnImage = new Image("resources/musicOn.png");
    private Image musicOffImage = new Image("resources/musicOff.png");


    public ImageView musicImage() {
        musicOnOrOff.setX(370);
        musicOnOrOff.setY(300);
        musicOnOrOff.setFitHeight(50);
        musicOnOrOff.setFitWidth(50);
        return musicOnOrOff;
    }

    public void musicStartsOrStops() {
        String path = "src/resources/music.mp3";
        Media media = new Media( Paths.get(path).toUri().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
        musicOnOrOff.setOnMouseClicked(event -> {
            if (musicOn) {
                mediaPlayer.stop();
                musicOn = false;
                musicOnOrOff.setImage(null);
                musicOnOrOff.setImage(musicOffImage);
            } else {
                mediaPlayer.play();
                musicOn = true;
                musicOnOrOff.setImage(null);
                musicOnOrOff.setImage(musicOnImage);
            }
        });
    }
}
