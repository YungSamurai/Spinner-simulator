package spinner.Objects;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Created by YungSamurai on 05.08.2017.
 */
public class Spinner extends Group {
    private static Image spinner1;
    private static ImageView iv1;
    private static double speed;
    public Spinner(Image spinner)
    {
        iv1 = new ImageView();
        iv1.setImage(spinner);
        this.getChildren().add(iv1);
    }
    public static Image getImage()
    {
        return iv1.getImage();
    }
    public static void setImage(Image img)
    {
        iv1.setImage(img);
    }
    public static void setSpinnerImage(Image img)
    {
        spinner1 = img;
    }
    public static Image getSpinnerImage()
    {
        return spinner1;
    }
    public static double getSpinnerRotate()
    {
        return iv1.getRotate();
    }
    public static void setSpinnerRotate(double rotate)
    {
        iv1.setRotate(rotate);
    }
    public static void setSpeed(double speedd) {
        System.out.println(speedd);
        speed = speedd;
    }
    public static double getSpeed() {
        return speed;
    }
}
