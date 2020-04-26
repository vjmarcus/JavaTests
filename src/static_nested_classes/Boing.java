package static_nested_classes;

public class Boing {

    public static void main(String[] args) {
        Boing boing = new Boing(1923);
        System.out.println(Boing.maxPassengerCount);
        Boing.Drawing drawing = new Boing.Drawing();
        System.out.println(drawing.getMaxPassengersCount());
    }

    private int year;
    private static final int maxPassengerCount = 300;

    public Boing(int year) {
        this.year = year;
    }
    public int year() {
        return year;
    }

    public static class Drawing {
        public static int getMaxPassengersCount() {
            return maxPassengerCount;
        }
    }
}
