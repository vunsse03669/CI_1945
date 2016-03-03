import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

/**
 * Created by Mr Hung on 3/2/2016.
 */
public class PlaneEnemy extends PlaneObject {

    private Vector<Bullet> vecBul = new Vector<>();
    private int count = 0;
    private int angle = 0;

    private PlaneEnemy(){}
    public PlaneEnemy(double x, double y, int speed, int type){
        this.X = x;
        this.Y = y;
        this.type = type;
        this.speed = speed;
        try {
            this.sprite = ImageIO.read(new File("Resources/PLANE1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void move(){
        this.X += this.speed;
        if(this.X <= 0 || this.X >= 400){
            this.speed = -this.speed;
        }
    }

    public void moveCircle(){
        angle ++;
        this.X += (double)(5*Math.sin(angle*0.09));
        this.Y += (double)(5*Math.cos(angle*0.09));
    }

    public void update(){
        count++;
        if(count >= 120){
            if(this.type == 1){
                this.fire();
            }else if(this.type == 2){
                this.multiFire();
            }
            count = 0;
        }
        for(Bullet bullet : vecBul){
            bullet.update();
        }
        if(this.type == 1){
             this.move();
        }else if(this.type == 2){
            this.moveCircle();
        }


    }

    public void fire(){
        Bullet bullet = new Bullet(this.X+25,this.Y+30,-3,1);
        Bullet bullet2 = new Bullet(this.X+25,this.Y+50,-3,1);
        vecBul.add(bullet);
        vecBul.add(bullet2);

    }

    public void multiFire(){
        Bullet bullet1 = new Bullet(this.X+10,this.Y+30,3,2);
        Bullet bullet2 = new Bullet(this.X+25,this.Y+30,-3,1);
        Bullet bullet3 = new Bullet(this.X+35,this.Y+30,-3,2);
        vecBul.add(bullet1);
        vecBul.add(bullet2);
        vecBul.add(bullet3);
    }

    public void draw(Graphics g){
        g.drawImage(this.sprite,(int)this.X,(int)this.Y,null);
        for(Bullet bullet : vecBul){
            bullet.draw(g);
        }
    }
}
