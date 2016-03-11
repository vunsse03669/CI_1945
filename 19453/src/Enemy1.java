/**
 * Created by Mr Hung on 3/10/2016.
 */
public class Enemy1 extends EnemyObject {

    public Enemy1(int positionX, int positionY, int speed) {
        super(positionX, positionY, speed);
    }

    @Override
    public void move() {
        this.positionX += this.speed;
        if(this.positionX <= 0 || positionX >= Helper.WIDTH-getWidth()){
            this.speed =- this.speed;
        }
    }

    @Override
    public void shot() {
        vectorBullet.add(new SingleBullet(this.positionX + getWidth()/2-6,this.positionY+30,Helper.BULLET_ENEMY_SPEED));
    }
}
