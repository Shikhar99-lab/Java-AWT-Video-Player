package sample;

import javafx.animation.Animation;
import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;

public class VideoBar extends HBox {

    Slider timeSlider = new Slider();
    Slider volSlider = new Slider();

    Button p = new Button("||");
    Label volume = new Label("Volume");

    MediaPlayer player;

    public VideoBar(MediaPlayer play) {
        player = play;

     //css styling thing

     setAlignment(Pos.CENTER);
     setPadding(new Insets(5,10,5,10));

     volSlider.setPrefWidth(70.0);
     volSlider.setMinWidth(30.0);
     volSlider.setValue(100);

        HBox.setHgrow(timeSlider,Priority.ALWAYS);
        p.prefWidth(40.0);

        getChildren().add(p);
        getChildren().add(timeSlider);
        getChildren().add(volume);
        getChildren().add(volSlider);

        //Make play,pause button work

        p.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                MediaPlayer.Status status = player.getStatus();
                if(status== MediaPlayer.Status.PLAYING){
                    if(player.getCurrentTime().greaterThanOrEqualTo(player.getTotalDuration())){
                        player.seek(player.getStartTime());
                        player.play();
                    }
                    else{
                        player.pause();
                        p.setText(">");
                    }
                }
                if(status == Status.PAUSED || status == Status.STOPPED){
                    player.play();
                    p.setText("||");

                }
            }
        });
        volSlider.valueProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                if(volSlider.isPressed()){
                    player.setVolume(volSlider.getValue()/100);
                }
            }
        });

        player.currentTimeProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                moveSlider();
            }

        });
    }
    private void moveSlider(){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                timeSlider.setValue(player.getCurrentTime().toMillis()/player.getTotalDuration().toMillis()*100);
            }
        });
    }
}
