package Patterns;

public class StateApp {
    public static void main(String[] args) {
        Radio radio = new Radio();
        radio.setStation(new Radio7());
        radio.play();
        radio.nextStation();
        radio.play();
        radio.nextStation();
        radio.play();
    }
}
//State
interface Station {
    void play();
}
class Radio7 implements Station{
    @Override
    public void play() {
        System.out.println("Играет Радио7...");
    }
}
class RadioDFM implements Station{
    @Override
    public void play() {
        System.out.println("Играет DFM...");
    }
}
class VestiFm implements Station{
    @Override
    public void play() {
        System.out.println("В эфире ВестиФМ...");
    }
}
//Context
class Radio{
    Station station;
    void setStation(Station station){
        this.station = station;
    }
    void nextStation(){
        if (station instanceof Radio7) {
            setStation(new RadioDFM());
        } else if (station instanceof RadioDFM) {
            setStation(new VestiFm());
        }  else if (station instanceof VestiFm) {
            setStation(new Radio7());
        }
    }
    void play() {
        station.play();
    }
}