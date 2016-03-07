/**
 * Created by Mr Hung on 3/7/2016.
 */
public class SimpleEnemy extends EnemyObject {

    public SimpleEnemy(double x, double y, int speed) {
        super(x, y, speed);
    }

    @Override
    public void move() {
        this.X -= this.speed;
        if(this.X <= 0 || this.X >= Helper.WIDTH){
            this.speed = -this.speed;
        }
    }

    @Override
    public void fire() {
        vecBul.add(new SingleBullet(this.X+25,this.Y+30,-Helper.BULLET_SPEED));
        vecBul.add(new SingleBullet(this.X+25,this.Y+50,-Helper.BULLET_SPEED));
    }
}
