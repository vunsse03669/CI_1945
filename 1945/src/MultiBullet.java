/**
 * Created by Mr Hung on 3/7/2016.
 */
public class MultiBullet extends BulletObject {

    public MultiBullet(double x, double y, int speed) {
        super(x, y, speed);
    }

    @Override
    public void fire() {
        if(this.speed < 0){
            this.Y -= this.speed;
            this.X -= this.speed/3;
        }
        else{
            this.Y += this.speed;
            this.X -= this.speed/3;
        }
    }
}
