import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Mr Hung on 3/9/2016.
 */
public abstract class GameObject {
    protected int positionX;
    protected int positionY;
    protected int speed;
    protected BufferedImage sprite;

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public int getSpeed() {
        return speed;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getWidth(){
        return this.sprite.getWidth();
    }

    public int getHeight(){
        return this.sprite.getHeight();
    }

    public abstract void update();
    public abstract void move();
    public abstract void draw(Graphics g);
}
