import javax.imageio.ImageIO;
import javax.xml.bind.ValidationException;
import java.awt.*;
import java.io.File;
import java.util.Vector;

/**
 * Created by Mr Hung on 3/10/2016.
 */
public abstract class EnemyObject extends GameObject implements Observer {

    private int count;
    protected Vector<BulletObject> vectorBullet = new Vector<>();

    public EnemyObject(int positionX, int positionY, int speed){
        this.positionX = positionX;
        this.positionY = positionY;
        this.speed = speed;
        count = 0;
        try{
            this.sprite = ImageIO.read(new File("Resources/PLANE1.png"));
        }catch(Exception e){}
    }

    @Override
    public void update() {
        count++;
        if(count >= 120){
            this.shot();
            count = 0;
        }
        for(BulletObject bullet : vectorBullet){
            bullet.update();
            if(bullet.collisionPlayer() || bullet.positionY >= Helper.HEIGHT){
               // PlaneManager.getInstance().getPlane().hp -= 10;
                vectorBullet.remove(bullet);
                return;
            }
        }

        this.move();
    }

    @Override
    public abstract void move();
    public abstract void shot();

    @Override
    public void draw(Graphics g) {
        g.drawImage(this.sprite,this.positionX,this.positionY,null);
        for(BulletObject bullet : vectorBullet){
            bullet.draw(g);
        }
    }

    @Override
    public void update(String msg){
        if(msg.equals("1")){
            EnemyManager.getInstance().getVectorEnemy().clear();
        }
    }
}
