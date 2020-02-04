package Patterns;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ObserverApp {
    public static void main(String[] args) {
        MeteoStation meteoStation = new MeteoStation();
        meteoStation.addObserver(new ConsoleObserver());
        meteoStation.addObserver(new FileObserver());
        meteoStation.setMeasurements(25, 769);
        meteoStation.setMeasurements(-5, 780);

    }
}
interface Observed{
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

interface Observer{
    void handleEvent(int temperature, int pressure);
}
// Наблюдаемый имеет свое состояние и посылает его своим подписчикам
class MeteoStation implements Observed{
    int temperature;
    int pressure;

    List<Observer> observers = new ArrayList<>();

    public void setMeasurements(int temperature, int pressure) {
        this.temperature = temperature;
        this.pressure  = pressure;
        notifyObservers();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer: observers){
            observer.handleEvent(temperature, pressure);
        }
    }
}
class ConsoleObserver implements Observer{
    @Override
    public void handleEvent(int temperature, int pressure) {
        System.out.println("Погода изменилась. Температура = " + temperature + ", давление = " + pressure  + ".");
    }
}
class FileObserver implements Observer{
    @Override
    public void handleEvent(int temperature, int pressure) {
        File file;
        try {
            file = java.io.File.createTempFile("TempPressure", "_txt");
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.print("Погода изменилась. Температура = " + temperature + ", давление " + pressure + ".");
            printWriter.println();
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}