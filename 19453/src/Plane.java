import java.awt.*;
import java.util.Vector;

/**
 * Created by Mr Hung on 3/9/2016.
 */
public class Plane extends PlaneObject{

    private int direction;

    public Plane(int positionX, int positionY, int speed, int type){
        super(positionX, positionY, speed, type);
        this.hp = 100;
        this.direction = 0;

    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    @Override
    public void move() {
        switch(this.direction){
            case 0:
                break;
            case 1:
                this.positionY -= this.speed;
                break;
            case 2:
                this.positionY += this.speed;
                break;
            case 3:
                this.positionX -= this.speed;
                break;
            case 4:
                this.positionX += this.speed;
                break;
        }
    }



}
