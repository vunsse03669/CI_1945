/**
 * Created by Mr Hung on 3/9/2016.
 */
public class PlaneManager {

    private Plane plane;
    private PlaneMouse planeMouse;
    private static PlaneManager sharePointer;

    private PlaneManager(){
        plane = new Plane(100,500,Helper.PLANE_SPEED,2);
        planeMouse = new PlaneMouse(300,500,Helper.PLANE_SPEED,3);
    }

    public static PlaneManager getInstance(){
        if(sharePointer == null){
            sharePointer = new PlaneManager();
        }
        return sharePointer;
    }

    public Plane getPlane() {
        return plane;
    }

    public PlaneMouse getPlaneMouse() {
        return planeMouse;
    }
}
