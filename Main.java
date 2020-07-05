package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        VideoPlayer videoPlayer = new VideoPlayer("file:///Users/shikhar99/Downloads/Lae%20Dooba%20-%20Full%20Video%20%20Aiyaary%20%20Sidharth%20Malhotra%20Rakul%20Preet%20%20Sunidhi%20Chauhan%20%20Rochak%20Kohli.mp4");
        Scene scene=new Scene(videoPlayer,1280,720,Color.WHITE);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
