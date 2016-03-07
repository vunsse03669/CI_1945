/**
 * Created by Mr Hung on 3/2/2016.
 */
public abstract class PlaneObject extends GameObject {
    protected int heath;

    public int getHeath() {
        return heath;
    }

    public void setHeath(int heath) {
        this.heath = heath;
    }

    public void fire(){};
    public void move(){};
}
