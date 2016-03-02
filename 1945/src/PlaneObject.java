/**
 * Created by Mr Hung on 3/2/2016.
 */
public abstract class PlaneObject extends GameObject {
    protected int heath;
    protected int type;
    protected int dir;

    public int getHeath() {
        return heath;
    }

    public int getType() {
        return type;
    }

    public int getDir() {
        return dir;
    }

    public void setHeath(int heath) {
        this.heath = heath;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setDir(int dir) {
        this.dir = dir;
    }

    public void fire(){};
    public void move(){};
}
