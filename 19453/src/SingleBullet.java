/**
 * Created by Mr Hung on 3/10/2016.
 */
public class SingleBullet extends BulletObject {

    public SingleBullet(int positionX, int positionY, int speed) {
        super(positionX, positionY, speed);
    }

    @Override
    public void move() {
        this.positionY -= this.speed;
    }
}
