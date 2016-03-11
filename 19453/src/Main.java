/**
 * Created by Mr Hung on 3/9/2016.
 */
public class Main {
    public static void main(String [] args){
        GameWindow game = new GameWindow();
        Thread t = new Thread(game);
        t.start();
    }
}
