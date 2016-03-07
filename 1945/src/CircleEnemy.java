/**
 * Created by Mr Hung on 3/7/2016.
 */
public class CircleEnemy extends EnemyObject {

    private int angle;
    public CircleEnemy(double x, double y, int speed) {
        super(x, y, speed);
        angle = 0;
    }

    @Override
    public void move() {
        angle ++;
        this.X += (double)(5*Math.sin(angle*0.09));
        this.Y += (double)(5*Math.cos(angle*0.09));
    }

    @Override
    public void fire() {
        vecBul.add(new MultiBullet(this.X+10,this.Y+30,Helper.ENEMY_SPEED));
        vecBul.add(new SingleBullet(this.X+25,this.Y+30,-Helper.ENEMY_SPEED));
        vecBul.add(new MultiBullet(this.X+40,this.Y+30,-Helper.ENEMY_SPEED));
    }
}
