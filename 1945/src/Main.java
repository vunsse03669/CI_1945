/**
 * Created by Mr Hung on 2/28/2016.
 */
public class Main {
    public static void main(String [] args){
        GameWindow game = new GameWindow();
        Thread t = new Thread(game);
        t.start();
    }
}
