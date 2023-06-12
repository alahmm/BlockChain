package innerclass;

public class Main {
    public static void main(String[] args) {
        Pumpkin pumpkin = new Pumpkin(false);
        pumpkin.addCandle();    }
}
class Pumpkin {

    private boolean forHalloween;

    public Pumpkin(boolean forHalloween) {
        this.forHalloween = forHalloween;
    }

    // create method addCandle()
    public void addCandle() {
        if (forHalloween) {
            new Candle().burning();
        } else {
            System.out.println("'We don't need a candle.'");
        }
    }

    class Candle {

        void burning() {
            System.out.println("The candle is burning! Boooooo!");
        }
    }
}

/**
 * second example
 */
class Vehicle {

    private String name;

    public Vehicle(String name) {
        this.name = name;
    }

    class Engine {

        private int horsePower;
        public Engine(int horsePower) {
            this.horsePower = horsePower;
        }

        void start() {
            System.out.println("RRRrrrrrrr....");
        }

        void printHorsePower() {
            System.out.println("Vehicle " + Vehicle.this.name + " has " + horsePower + " horsepower.");
        }
    }
}

// this code should work
/*class EnjoyVehicle {

    public static void main(String[] args) {

        Vehicle vehicle = new Vehicle("Dixi");
        Vehicle.Engine engine = vehicle.new Engine(20);
        engine.printHorsePower();
    }
}*/
/**
 * third example
 */
class ChristmasTree {

    private String color;

    public ChristmasTree(String color) {
        this.color = color;
    }

    void putTreeTopper(String color) {
        new TreeTopper(color).sparkle();
    }

    class TreeTopper {

        private String color;

        public TreeTopper(String color) {
            this.color = color;
        }

        void sparkle() {
            System.out.println("Sparkling " + color + " tree topper looks stunning with " + ChristmasTree.this.color + " Christmas tree!");
        }
    }
}

// this code should work
class CreateHoliday {

    public static void main(String[] args) {

        ChristmasTree christmasTree = new ChristmasTree("green");
        christmasTree.putTreeTopper("silver");
    }
}
/**
 * fourth example
 */
class EnjoyVehicle {

    public static void startVehicle() {
        Vehicle vehicle = new Vehicle("Dixi");
        Vehicle.Engine engine = vehicle.new Engine(20);
        engine.start();
    }
}