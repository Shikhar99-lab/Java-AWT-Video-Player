package sample;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class VideoPlayer extends BorderPane {

    Media media;
    MediaPlayer mediaPlayer;
    MediaView mediaView;
    Pane pane;

    //VideoBar

    VideoBar vb;

    public VideoPlayer(String filepath) {
        media = new Media(filepath);
        mediaPlayer = new MediaPlayer(media);
        mediaView = new MediaView(mediaPlayer);
        pane = new Pane();

        pane.getChildren().add(mediaView);
        setCenter(pane);

        //add Video Bar here

        vb=new VideoBar(mediaPlayer);
        setBottom(vb);

        mediaPlayer.play();
    }
}
