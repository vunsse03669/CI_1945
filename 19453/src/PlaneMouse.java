import java.awt.*;

/**
 * Created by Mr Hung on 3/9/2016.
 */
public class PlaneMouse extends PlaneObject {

    public PlaneMouse(int positionX, int positionY, int speed, int type){
        super(positionX,positionY,speed,type);
    }


    @Override
    public void move() {

    }

    public void move(int x ,int y){
        this.positionX = x;
        this.positionY = y;
    }

}
