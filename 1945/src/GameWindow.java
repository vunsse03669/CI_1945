import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Mr Hung on 2/28/2016.
 */
public class GameWindow extends Frame implements KeyListener,Runnable, MouseMotionListener {

    public final int WIDTH = 400;
    public final int HEIGH = 640;
    public final int FPS = 1000/60;
    BufferedImage background;
    Graphics seconds;
    Image img;
    Plane plane, plane2;
    Bullet bullet;

    public GameWindow(){

        try{
            this.init();
            this.setGame();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void update(Graphics g){
        if(img == null){
            img = createImage(this.getWidth(), this.getHeight());
            seconds = img.getGraphics();
        }
        seconds.setColor(getBackground());
        seconds.fillRect(0,0,getWidth(),getHeight());
        seconds.setColor(getForeground());
        paint(seconds);
        g.drawImage(img,0,0,null);
    }

    public void setGame(){
        this.setTitle("1945");
        this.setSize(WIDTH,HEIGH);
        this.setVisible(true);

        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB), new Point(0, 0), "cursor"));
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
        this.addKeyListener(this);
        this.addMouseMotionListener(this);
    }

    public void init() throws Exception {
        background = ImageIO.read(new File("Resources/Background.png"));
        plane = new Plane();
        plane2 = new Plane();
        plane.setX(150);
        plane.setY(300);
        plane.setSpeed(5);
        plane.setDir(0);
        plane.setType(1);
        plane2.setX(150);
        plane2.setY(500);
        plane2.setType(2);
        plane.loadImage();
        plane2.loadImage();
       // repaint();
    }

    public void paint(Graphics g){
        g.drawImage(background,0,0,null);
        plane.draw(g);
        plane2.draw(g);
        if(plane.getFire()){
            plane.drawBullet(g);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyChar() == 'w'){
            plane.setDir(1);
        }else if(e.getKeyChar() == 's'){
            plane.setDir(2);
        }
        else if(e.getKeyChar() == 'a'){
            plane.setDir(3);
        }else if(e.getKeyChar() == 'd'){
            plane.setDir(4);
        }else if(e.getKeyChar() == 'l'){
            plane.setFire(true);
            plane.bullet.setX(plane.getX()+30);
            plane.bullet.setY(plane.getY());
            if(plane.bullet.getY() == 0){
                plane.setFire(false);
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        plane.setDir(0);
        //plane.setFire(false);
    }

    @Override
    public void run() {

        while (true){
            plane.update();
            plane.fire();
            repaint();
            try {
                Thread.sleep(FPS);
            } catch (InterruptedException e) {}
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        plane2.setX(e.getX());
        plane2.setY(e.getY());
    }
}
