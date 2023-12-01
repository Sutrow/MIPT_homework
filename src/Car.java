public class Car {
    private String colour;
    private int fuel;
    private final int maxFuel;
    private final String model;
    private final Engine engine;
    private int mileage;

    public Car(String colour, int maxFuel, String model, int consumption) {
        this.colour = colour;
        this.maxFuel = maxFuel;
        this.model = model;
        this.engine = new Engine(consumption);
        this.fuel = maxFuel; // предполагаем, что автомобиль поставляется с полным баком
        this.mileage = 0;
    }

    private class Engine {
        private boolean isRunning;
        private final int consumption; // расход топлива на 100 км

        public Engine(int consumption) {
            this.isRunning = false;
            this.consumption = consumption;
        }

        public void start() {
            if (fuel > 0) {
                isRunning = true;
                System.out.println("Engine started.");
            } else {
                System.out.println("Cannot start the engine. The fuel tank is empty.");
            }
        }

        public void stop() {
            isRunning = false;
            System.out.println("Engine stopped.");
        }

        public boolean move() {
            if (isRunning) {
                if (fuel >= consumption) {
                    fuel -= consumption;
                    mileage += 100;
                    return true;
                } else {
                    stop();
                    System.out.println("Fuel is out. Refuel the car.");
                    return false;
                }
            }
            return false;
        }
    }

    public void refuel() {
        fuel = maxFuel;
        System.out.println("Car is refueled to maximum.");
    }

    public void refuel(int amount) {
        fuel = Math.min(fuel + amount, maxFuel);
        System.out.println("Car is refueled with " + amount + " liters.");
    }

    public void startEngine() {
        engine.start();
    }

    public void stopEngine() {
        engine.stop();
    }

    public void move() {
        while (engine.move()) { }
    }

    public void info() {
        System.out.println("Model: " + model);
        System.out.println("Colour: " + colour);
        System.out.println("Fuel left: " + fuel);
        System.out.println("Mileage: " + mileage);
        System.out.println("Engine is " + (engine.isRunning ? "running" : "stopped"));
    }

    public static void main(String[] args) {
        Car car = new Car("Red", 500, "Toyota", 50);
        car.info();

        car.move();
        car.info();

        car.stopEngine();
        car.refuel(200);
        car.info();

        car.startEngine();
        car.move();
        car.info();
    }
}
