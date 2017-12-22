package spinner.Objects;

import javafx.scene.image.Image;

/**
 * Created by YungSamurai on 07.08.2017.
 */
public class Bearing {
    private Image img;
    private int price;
    private double speed;
    public Bearing(Image image,double speed, int price)
    {
        setImg(image);
        setSpeed(speed);
        setPrice(price);
    }

    public Image getImg() {
        return img;
    }

    public double getSpeed() {
        return speed;
    }

    public int getPrice() {
        return price;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
