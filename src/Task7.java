public class Task7 {

    private String colour;
    private int fuel;
    private final int maxFuel;
    private final String model;
    private final Engine engine;
    private int mileage;

    // Конструктор класса Car приватный, чтобы гарантировать создание объекта только через Builder
    private Task7(Builder builder) {
        this.colour = builder.colour;
        this.fuel = builder.fuel;
        this.maxFuel = builder.maxFuel;
        this.model = builder.model;
        this.engine = builder.engine;
        this.mileage = builder.mileage;
    }

    public static class Builder {
        private String colour;
        private int fuel;
        private int maxFuel;
        private String model;
        private Engine engine;
        private int mileage;

        public Builder(String model, Engine engine) {
            this.model = model;
            this.engine = engine;
        }

        public Builder colour(String colour) {
            this.colour = colour;
            return this;
        }

        public Builder fuel(int fuel) {
            this.fuel = fuel;
            return this;
        }

        public Builder maxFuel(int maxFuel) {
            this.maxFuel = maxFuel;
            return this;
        }

        public Builder mileage(int mileage) {
            this.mileage = mileage;
            return this;
        }

        public Task7 build() {
            return new Task7(this);
        }
    }

    // Простой внутренний класс Engine для демонстрации
    public static class Engine {
        // Здесь можно добавить параметры и методы, специфичные для двигателя
    }

    public static void main(String[] args) {
        Engine engine = new Engine();

        Task7 myCar = new Builder("Tesla Model S", engine)
                .colour("Red")
                .fuel(100)
                .maxFuel(500)
                .mileage(0)
                .build();
    }
}
