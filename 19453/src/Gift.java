import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.util.Random;

/**
 * Created by Mr Hung on 3/11/2016.
 */
public class Gift extends GameObject {

    public Gift(){
        this.positionY = -10;
        this.positionX = rand(0,Helper.WIDTH);
        this.speed = 1;
        try{
            this.sprite = ImageIO.read(new File("Resources/gift.png"));
        }catch(Exception e){}
    }

    @Override
    public void update() {
        this.move();
    }

    @Override
    public void move() {
        this.positionY += this.speed;
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(this.sprite,this.positionX,this.positionY,null);
    }

    public boolean collisionPlane(){
        Rectangle rectGift = new Rectangle(this.positionX,this.positionY,this.getWidth(),this.getHeight());
        Rectangle rectPlane = new Rectangle(PlaneManager.getInstance().getPlane().getPositionX(),
                PlaneManager.getInstance().getPlane().getPositionY(),
                PlaneManager.getInstance().getPlane().getWidth(),
                PlaneManager.getInstance().getPlane().getHeight());

        return rectGift.intersects(rectPlane);
    }

    public int rand(int min, int max) {
        try {
            Random rn = new Random();
            int range = max - min + 1;
            int randomNum = min + rn.nextInt(range);
            return randomNum;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
