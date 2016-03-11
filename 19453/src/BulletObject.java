import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;

/**
 * Created by Mr Hung on 3/10/2016.
 */
public abstract class BulletObject extends GameObject {

    public BulletObject(int positionX, int positionY, int speed){
        this.positionX = positionX;
        this.positionY = positionY;
        this.speed = speed;
        try{
            this.sprite = ImageIO.read(new File("Resources/DAN.png"));
        }catch(Exception e){}
    }

    public boolean collisionPlayer(){
        boolean isCollision = false;
        Rectangle rectBullet = new Rectangle(this.positionX,this.positionY,this.getWidth(),this.getHeight());
        Rectangle rectPlane = new Rectangle(PlaneManager.getInstance().getPlane().getPositionX(),
                                            PlaneManager.getInstance().getPlane().getPositionY(),
                                            PlaneManager.getInstance().getPlane().getWidth(),
                                            PlaneManager.getInstance().getPlane().getHeight());
        if(this.speed < 0){
            if(rectBullet.intersects(rectPlane)){
                isCollision = true;
            }
        }

        return isCollision;
    }

    public int collisionEnemy(){
        int index = -1;
        int count = 0;
        Rectangle rectBullet = new Rectangle(this.positionX,this.positionY,this.getWidth(),this.getHeight());
        for(EnemyObject enemy : EnemyManager.getInstance().getVectorEnemy()){
            Rectangle rectEnemy = new Rectangle(enemy.positionX,enemy.positionY,enemy.getWidth(),enemy.getHeight());
            if(this.speed >= 0){
                if(rectBullet.intersects(rectEnemy)){
                    index = count;
                    break;
                }
            }
            count++;
        }

        return index;
    }

    @Override
    public void update(){
        this.move();
        if(collisionPlayer()){
            PlaneManager.getInstance().getPlane().hp -= 10;
           // PlaneManager.getInstance().getPlaneMouse().hp -= 10;
        }
    }

    @Override
    public abstract void move();

    @Override
    public void draw(Graphics g) {
        g.drawImage(this.sprite,this.positionX,this.positionY,null);
    }
}
