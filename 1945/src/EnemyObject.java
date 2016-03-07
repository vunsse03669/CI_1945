import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

/**
 * Created by Mr Hung on 3/7/2016.
 */
public abstract class EnemyObject extends PlaneObject {

    protected Vector<BulletObject> vecBul = new Vector<>();
    private int count = 0;


    private EnemyObject(){}
    public EnemyObject(double x, double y, int speed){
        this.X = x;
        this.Y = y;
        this.speed = speed;
        try {
            this.sprite = ImageIO.read(new File("Resources/PLANE1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update(){
        count++;
        System.out.println(count);
        if(count >= Helper.BULLET_DELAY){
            this.fire();
            count = 0;
        }
        for(BulletObject bullet : vecBul){
            bullet.update();
        }
        this.move();
    }

    public abstract void move();
    public abstract void fire();

    public void draw(Graphics g){
        g.drawImage(this.sprite,(int)this.X,(int)this.Y,null);
        for(BulletObject bullet : vecBul){
            bullet.draw(g);
        }
    }
}
