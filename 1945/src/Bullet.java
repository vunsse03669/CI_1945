import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Mr Hung on 2/29/2016.
 */
public class Bullet {
    private int X;
    private int Y;
    private int speed;
    public BufferedImage sprite;


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
    public  void draw(Graphics g){
        try {
            this.sprite = ImageIO.read(new File("Resources/DAN.png"));
            g.drawImage(this.sprite,this.X,this.Y,null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void fire(){
        //this.Y -= 10;
    }


}
