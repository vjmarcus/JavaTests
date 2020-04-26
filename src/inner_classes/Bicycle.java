package inner_classes;

public class Bicycle {

    public static void main(String[] args) {
        Bicycle bicycle = new Bicycle("CUBE", 13);
        Bicycle.SteeringWheel steeringWheel = bicycle.new SteeringWheel();
        Bicycle.Seat  seat = bicycle.new Seat();
        bicycle.start();
        steeringWheel.left();
        seat.down();
    }

    private String model;
    private int weight;

    public Bicycle(String model, int weight) {
        this.model = model;
        this.weight = weight;
    }

    public void start(){
        System.out.println("Поехали!");
    }

    public class SteeringWheel{

        public void right() {
            System.out.println("Руль вправо!");
        }
        public void left() {
            System.out.println("Руль влево!");
        }
    }

    public class Seat {

        public void up() {
            System.out.println("Сиденье выше!");
        }
        public void down() {
            System.out.println("Сиденье ниже!");
        }

    }
}
