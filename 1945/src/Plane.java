import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

/**
 * Created by Mr Hung on 2/29/2016.
 */
public class Plane extends PlaneObject {

    private Vector<Bullet> vecBul = new Vector<Bullet>();

    private Plane(){
        this.X = 150;
        this.Y = 300;
        this.type = 1;
        this.speed = 4;
        this.dir = 0;
        try {
            this.sprite = ImageIO.read(new File("Resources/PLANE1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Plane(int X, int Y, int speed, int type){
        this.X = X;
        this.Y = Y;
        this.speed = speed;
        switch (type){
            case 1:
                try {
                    this.sprite = ImageIO.read(new File("Resources/PLANE1.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                try {
                    this.sprite = ImageIO.read(new File("Resources/PLANE2.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 3:
                try {
                    this.sprite = ImageIO.read(new File("Resources/PLANE3.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 4:
                try {
                    this.sprite = ImageIO.read(new File("Resources/PLANE4.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }
    }



    public void draw(Graphics g){
        g.drawImage(this.sprite,(int)this.X,(int)this.Y,null);
        for(Bullet bul : vecBul){
            bul.draw(g);
        }
    }

    public void move(){
        switch(this.dir){
            case 1:
                this.Y -= this.speed;
                break;
            case 2:
                this.Y += this.speed;
                break;
            case 3:
                this.X -= this.speed;
                break;
            case 4:
                this.X += this.speed;
                break;
        }
    }

    public void move(int x, int y){
        this.X = x;
        this.Y = y;
    }

    public void update(){
        this.move();
        for(Bullet bul : vecBul){
            bul.update();
        }
    }

    public void fire(){
        Bullet bullet = new Bullet(this.X + 30,this.Y,10,1);
        vecBul.add(bullet);
    }

}
