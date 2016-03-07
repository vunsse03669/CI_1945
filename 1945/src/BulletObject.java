import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Mr Hung on 3/7/2016.
 */
public abstract class BulletObject extends GameObject{

    private BulletObject(){
        this.X = 0;
        this.Y = 0;
    }

    public BulletObject(double x, double y, int speed) {
        X = x;
        Y = y;
        this.speed = speed;

        try {
            this.sprite = ImageIO.read(new File("Resources/bullet2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  void draw(Graphics g){
        g.drawImage(this.sprite,(int)this.X,(int)this.Y,null);
    }

    public void update(){
        this.fire();
    }
    public abstract void fire();

}
