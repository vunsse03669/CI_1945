import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

/**
 * Created by Mr Hung on 2/28/2016.
 */
public class GameWindow extends Frame implements KeyListener,Runnable, MouseMotionListener {

    BufferedImage background;
    Graphics seconds;
    Image img;
    Plane plane, plane2;
    Vector<EnemyObject> vectorEnemy = new Vector<>();


    public GameWindow(){

        try{
            this.setGame();
            this.init();
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
        this.setSize(Helper.WIDTH,Helper.HEIGH);
        this.setVisible(true);

        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB),
                new Point(0, 0), "cursor"));
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
        this.addKeyListener(this);
        this.addMouseMotionListener(this);
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getModifiers() == InputEvent.BUTTON1_MASK){
                    plane2.fire();
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

    public void init() throws Exception {
        background = ImageIO.read(new File("Resources/Background.png"));
        plane = new Plane(90,500,4,2);
        plane2 = new Plane(250,500,4,3);
        vectorEnemy.add(new SimpleEnemy(130,100,Helper.ENEMY_SPEED));
        vectorEnemy.add(new SimpleEnemy(190,100,Helper.ENEMY_SPEED));
        vectorEnemy.add(new CircleEnemy(130,300,Helper.ENEMY_SPEED));
        vectorEnemy.add(new CircleEnemy(230,300,Helper.ENEMY_SPEED));

    }

    public void paint(Graphics g){
        g.drawImage(background,0,0,null);
        plane.draw(g);
        plane2.draw(g);
        for(EnemyObject enemy : vectorEnemy){
            enemy.draw(g);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_W){
            plane.setDir(1);
        }else if(e.getKeyCode() == KeyEvent.VK_S) {
            plane.setDir(2);
        }else if(e.getKeyCode() == KeyEvent.VK_A){
            plane.setDir(3);
        }else if(e.getKeyCode() == KeyEvent.VK_D){
            plane.setDir(4);
        } else if(e.getKeyCode() == KeyEvent.VK_SPACE){
            plane.fire();
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        plane.setDir(0);
    }

    @Override
    public void run() {

        while (true){
            plane.update();
            plane2.update();
            for(EnemyObject enemy : vectorEnemy){
                enemy.update();
            }
            repaint();
            try {
                Thread.sleep(Helper.FPS);
            } catch (InterruptedException e) {}
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        plane2.move(e.getX(),e.getY());
    }
}
