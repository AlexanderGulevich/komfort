package basisFx.appCore;

import java.util.ArrayList;

public class MaximazingManager {

    protected static ArrayList<MaximazingObserver> observers=new ArrayList<>();

    public static void setObserver(MaximazingObserver observer){

        observers.add(observer);

    }

    public static void notifyObjects(){

        for (MaximazingObserver observer : observers) {
            observer.pervormMaximazingEventNotifier();
        }

    }





}
