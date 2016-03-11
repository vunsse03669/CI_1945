import java.util.Vector;

/**
 * Created by Mr Hung on 3/11/2016.
 */
public class GiftManager {
    private Vector<Gift> vectorGift = new Vector<>();
    private static GiftManager sharePointer;

    private GiftManager(){
        vectorGift.add(new Gift());
    }

    public static GiftManager getInstance(){
        if(sharePointer == null){
            sharePointer = new GiftManager();
        }
        return sharePointer;
    }

    public Vector<Gift> getVectorGift() {
        return vectorGift;
    }
}
