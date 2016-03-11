import javax.imageio.ImageIO;
import javax.imageio.stream.FileCacheImageInputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

/**
 * Created by Mr Hung on 3/9/2016.
 */
public abstract class PlaneObject extends GameObject implements Subject{

    protected int hp = 100;
    protected int type;
    protected Vector<BulletObject> vectorBullet = new Vector<>();
    Vector<Observer> vectorObserver = new Vector<>();

    public PlaneObject(int positionX, int positionY, int speed, int type){
        this.positionX = positionX;
        this.positionY = positionY;
        this.speed = speed;
        switch (type){
            case 1:
                try {
                    this.sprite = ImageIO.read(new File("Resources/PLANE1.png"));
                } catch (IOException e) {}
                break;
            case 2:
                try {
                    this.sprite = ImageIO.read(new File("Resources/PLANE2.png"));
                } catch (IOException e) {}
                break;
            case 3:
                try {
                    this.sprite = ImageIO.read(new File("Resources/PLANE3.png"));
                } catch (IOException e) {}
                break;
            case 4:
                try {
                    this.sprite = ImageIO.read(new File("Resources/PLANE4.png"));
                } catch (IOException e) {}
                break;
            default:
                try {
                    this.sprite = ImageIO.read(new File("Resources/PLANE1.png"));
                } catch (IOException e) {}
                break;

        }
    }

    public int getHp() {
        return hp;
    }

    public int getType() {
        return type;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public void update(){
        this.move();
        for(BulletObject bullet : vectorBullet){
            bullet.update();
            if(bullet.collisionEnemy() != -1){
                EnemyManager.getInstance().getVectorEnemy().remove(bullet.collisionEnemy());
                vectorBullet.remove(bullet);

                return;
            }
        }
        for(Gift gift : GiftManager.getInstance().getVectorGift()){
            if(gift.collisionPlane()){
                GiftManager.getInstance().getVectorGift().remove(gift);
                EnemyManager.getInstance().getVectorEnemy().clear();
                this.notifiObserver();
                return;
            }
        }
    }

    @Override
    public abstract void move() ;

    @Override
    public void draw(Graphics g){
       if(this.hp >= 0){
           g.drawImage(this.sprite,this.positionX,this.positionY,null);
       }
        for(BulletObject bullet : vectorBullet){
            bullet.draw(g);
        }
        //draw hp
        g.setColor(Color.green);
        g.fillRect(this.positionX-15,this.positionY-20,this.hp,8);
        g.drawRect(this.positionX-15,this.positionY-20,this.hp,8);
    }

    public void shot(){
        vectorBullet.add(new SingleBullet(this.positionX + this.getWidth()/2 - 6,
                this.positionY,Helper.BULLET_PLANE_SPEED));
    }

    @Override
    public void addObserver(Observer ob) {
        vectorObserver.add(ob);
    }

    @Override
    public void removeObserver(Observer ob) {
        vectorObserver.remove(ob);
    }

    @Override
    public void notifiObserver() {
        for(Observer ob : vectorObserver){
            ob.update("1");
        }
    }

}
