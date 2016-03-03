import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Mr Hung on 2/29/2016.
 */
public class Bullet extends GameObject {

    private Bullet(){
        this.X = 0;
        this.Y = 0;
    }

    public Bullet(double x, double y, int speed,int type) {
        X = x;
        Y = y;
        this.speed = speed;
        this.type = type;
        try {
            this.sprite = ImageIO.read(new File("Resources/bullet2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void update(){
        if(this.type == 1){
            this.fire();
        }else if(this.type == 2){
            this.multiFire();
        }
    }

    public  void draw(Graphics g){
        g.drawImage(this.sprite,(int)this.X,(int)this.Y,null);
    }
    public void fire(){
        this.Y -= this.speed;
    }
    public void multiFire(){
        if(this.speed < 0){
            this.Y -= this.speed;
            this.X -= this.speed/3;
        }
        else{
            this.Y += this.speed;
            this.X -= this.speed/3;
        }
    }


}
