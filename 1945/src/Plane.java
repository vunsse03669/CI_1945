import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Mr Hung on 2/29/2016.
 */
public class Plane {
    private int X;
    private int Y;
    private int heath;
    private int speed;
    public BufferedImage sprite;
    private int type;
    private int dir;
    private boolean isFire = false;
    Bullet bullet = new Bullet();

//    public Plane(){
//        this.X = 0;
//        this.Y = 0;
//        this.type = 1;
//    }

    public int getX(){
        return this.X;
    }
    public void setX(int X){
        this.X = X;
    }
    public int getY(){
        return this.Y;
    }
    public void setY(int Y){
        this.Y = Y;
    }
    public int getSpeed(){
        return this.speed;
    }
    public void setSpeed(int speed){
        this.speed = speed;
    }
    public int getDir(){
        return this.dir;
    }
    public void setDir(int dir){
        this.dir = dir;
    }
    public void setType(int type){
        this.type = type;
    }
    public int getType(){
        return this.type;
    }
    public void setFire(boolean fire){
        this.isFire = fire;
    }
    public boolean getFire(){
        return this.isFire;
    }
    public void draw(Graphics g){
        g.drawImage(this.sprite,this.X,this.Y,null);
    }
    public void loadImage(){
        try {
            if(this.type == 1){
                this.sprite = ImageIO.read(new File("Resources/PLANE1.png"));
            }else if(this.type == 2){
                this.sprite = ImageIO.read(new File("Resources/PLANE2.png"));
            }else if(this.type == 3){
                this.sprite = ImageIO.read(new File("Resources/PLANE3.png"));
            }else if(this.type == 4){
                this.sprite = ImageIO.read(new File("Resources/PLANE4.png"));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void drawBullet(Graphics g){

            bullet.setX(bullet.getX());
            bullet.setY(bullet.getY()-4);


        System.out.println(bullet.getY());
        System.out.println(this.getFire()+""+bullet.getY() );

        bullet.draw(g);
    }
    private void move(){
        if(this.dir == 1){
            this.Y -= this.speed;
        }else if(this.dir == 2){
            this.Y += this.speed;
        }else if(this.dir == 3){
            this.X -= this.speed;
        }else if(this.dir == 4){
            this.X += this.speed;
        }
    }
    public void update(){
        this.move();
        //this.fire();
    }

    public void fire(){
        if(isFire){
            bullet.fire();
        }
    }

}
