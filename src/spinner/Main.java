package spinner;

import javafx.application.Application;
import javafx.scene.*;
import javafx.stage.*;
import spinner.Scenes.Game;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Group gr = new Group();
        primaryStage.setTitle("Spinner simulator v0.3");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Game(gr));
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }

}
