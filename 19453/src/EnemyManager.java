import java.util.Vector;

/**
 * Created by Mr Hung on 3/10/2016.
 */
public class EnemyManager {

    private static EnemyManager sharePointer;
    Vector<EnemyObject> vectorEnemy = new Vector<EnemyObject>();;

    private EnemyManager(){
        vectorEnemy.add(new Enemy1(50,100,Helper.ENEMY_SPEED));
        vectorEnemy.add(new Enemy1(150,100,Helper.ENEMY_SPEED));
        vectorEnemy.add(new Enemy1(250,100,Helper.ENEMY_SPEED));
    }

    public static EnemyManager getInstance(){
        if(sharePointer == null){
            sharePointer = new EnemyManager();
        }
        return sharePointer;
    }

    public Vector<EnemyObject> getVectorEnemy() {
        return vectorEnemy;
    }
}
