package spinner.Scenes;

/**
 * Created by YungSamurai on 08.07.2017.
 */

import javafx.animation.AnimationTimer;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.canvas.*;
import javafx.scene.image.*;
import javafx.scene.text.*;

import java.io.IOException;

public class Store extends Scene {
    public Store(Group root) throws IOException {
        super(root, 400, 450);

        Parent styles = FXMLLoader.load(getClass().getResource("Layouts/Game.fxml"));
        Canvas canvas = new Canvas(400,450);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Font font = Font.font("Times New Roman", FontWeight.BOLD, 22);

        new AnimationTimer()
        {
            public void handle(long currentNanoTime)
            {
                gc.setFont(font);
                gc.clearRect(0,0,400,450);
            }
        }.start();
    }
}
