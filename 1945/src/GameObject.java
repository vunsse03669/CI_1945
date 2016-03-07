import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Mr Hung on 3/1/2016.
 */
public abstract class GameObject {
    protected double X;
    protected double Y;
    protected int speed;

    protected BufferedImage sprite;

    public double getX() {
        return X;
    }

    public double getY() {
        return Y;
    }

    public int getSpeed() {
        return speed;
    }

    public BufferedImage getSprite() {
        return sprite;
    }

    public void setX(double x) {
        X = x;
    }

    public void setSprite(BufferedImage sprite) {
        this.sprite = sprite;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setY(double y) {
        Y = y;
    }


    public void update(){};
    public void draw(Graphics g){};
}
