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
    BufferedImage background, plane1,plane2;
    public int plane1X = 0;
    public int plane1Y = 0;
    public int plane2X = 0;
    public int plane2Y = 0;
    public int status = 0;

    public GameWindow(){
        this.setGame();
        try{
            this.init();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setGame(){
        plane1X = 160;
        plane1Y = 300;
        plane2X = 160;
        plane2Y = 500;
        this.setTitle("1945");
        this.setSize(WIDTH,HEIGH);
        this.setVisible(true);
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
        plane1 = ImageIO.read(new File("Resources/PLANE1.png"));
        plane2 = ImageIO.read(new File("Resources/PLANE2.png"));
        repaint();
    }

    public void paint(Graphics g){
        g.drawImage(background,0,0,null);
        g.drawImage(plane1,plane1X,plane1Y,null);
        g.drawImage(plane2,plane2X,plane2Y,null);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyChar() == 'w'){
            System.out.println("xxxxxxxxxxx");
            status = 1;
        }else if(e.getKeyChar() == 's'){
            status = 2;
        }
        else if(e.getKeyChar() == 'a'){
            status = 3;
        }else if(e.getKeyChar() == 'd'){
            status = 4;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        status = 0;
    }

    @Override
    public void run() {

        while (true){
            if(status == 1){
                plane1Y -= 5;
            } else if(status == 2){
                plane1Y += 5;
            }else if(status == 3){
                plane1X -= 5;
            }else if(status == 4){
                plane1X += 5;
            }

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
        plane2X = e.getX();
        plane2Y = e.getY();
    }
}
