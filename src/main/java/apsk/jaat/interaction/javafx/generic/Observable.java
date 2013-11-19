package apsk.jaat.interaction.javafx.generic;

import java.util.LinkedList;

public class Observable<T> {
    private LinkedList<Observer<T>> observers = new LinkedList<>();
    public void addObserver(Observer<T> observer) {
        observers.add(observer);
    }
    public void notifyObservers(T target) {
        for (Observer<T> observer : observers) {
            observer.observe(target);
        }
    }
}
