/**
 * Created by Mr Hung on 3/7/2016.
 */
public class SingleBullet extends BulletObject {

    public SingleBullet(double x, double y, int speed) {
        super(x, y, speed);
    }

    @Override
    public void fire() {
        this.Y -= this.speed;
    }
}
