import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageFilter;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

/**
 * Created by Mr Hung on 3/9/2016.
 */
public class GameWindow extends Frame implements Runnable{

    BufferedImage background;
    Graphics seconds;
    Image image;
    Plane plane;
    PlaneMouse planeMouse;
    Vector<EnemyObject> vectorEnemy;
    Vector<Gift> vectorGift;

    public GameWindow(){
        this.setGame();
        this.init();
    }

    public void setGame(){
        this.setSize(Helper.WIDTH,Helper.HEIGHT);
        this.setTitle("1945");
        this.setVisible(true);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_W){
                    PlaneManager.getInstance().getPlane().setDirection(1);
                }else if(e.getKeyCode() == KeyEvent.VK_S){
                    PlaneManager.getInstance().getPlane().setDirection(2);
                }else if(e.getKeyCode() == KeyEvent.VK_A){
                    PlaneManager.getInstance().getPlane().setDirection(3);
                }else if(e.getKeyCode() == KeyEvent.VK_D){
                    PlaneManager.getInstance().getPlane().setDirection(4);
                }else if(e.getKeyCode() == KeyEvent.VK_SPACE){
                    PlaneManager.getInstance().getPlane().shot();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                PlaneManager.getInstance().getPlane().setDirection(0);
            }
        });

        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {
                PlaneManager.getInstance().getPlaneMouse().move(e.getX(),e.getY());
            }
        });

        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getModifiers() == InputEvent.BUTTON1_MASK){
                    PlaneManager.getInstance().getPlaneMouse().shot();
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

    }

    public void init(){
        try {
            background = ImageIO.read(new File("Resources/Background.png"));
            plane = PlaneManager.getInstance().getPlane();
            planeMouse = PlaneManager.getInstance().getPlaneMouse();
            vectorEnemy = EnemyManager.getInstance().getVectorEnemy();
            for(EnemyObject enemy : vectorEnemy){
                PlaneManager.getInstance().getPlane().addObserver(enemy);
            }
           vectorGift = GiftManager.getInstance().getVectorGift();

            repaint();
        } catch (IOException e) {}
    }

    public void paint(Graphics g){
        g.drawImage(background,0,0,null);
        PlaneManager.getInstance().getPlane().draw(g);
        PlaneManager.getInstance().getPlaneMouse().draw(g);
        for(Gift gift : vectorGift){
            gift.draw(g);
        }
        for(EnemyObject enemy : vectorEnemy){
            enemy.draw(g);
        }
    }

    @Override
    public void run() {
        while(true){
            PlaneManager.getInstance().getPlane().update();
            PlaneManager.getInstance().getPlaneMouse().update();
            for(EnemyObject enemy : vectorEnemy){
                enemy.update();
            }
            for(Gift gift : vectorGift){
                gift.update();
            }
            repaint();
            try {
                Thread.sleep(Helper.FPS);
            } catch (InterruptedException e){}
        }
    }
    @Override
    public void update(Graphics g){
        if(image == null){
            image = createImage(this.getWidth(), this.getHeight());
            seconds= image.getGraphics();
        }
        seconds.setColor(getBackground());
        seconds.fillRect(0,0,getWidth(),getHeight());
        seconds.setColor(getForeground());
        paint(seconds);
        g.drawImage(image,0,0,null);
    }
}
