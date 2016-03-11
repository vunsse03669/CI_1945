/**
 * Created by Mr Hung on 3/11/2016.
 */
public interface Subject {
    void addObserver(Observer ob);
    void removeObserver(Observer ob);
    void notifiObserver();
}
