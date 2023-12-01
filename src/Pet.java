import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Pet {
    protected String name;
    protected double weight;
    protected int age;
    protected String owner;

    public Pet(String name, double weight, int age, String owner) {
        this.name = name;
        this.weight = weight;
        this.age = age;
        this.owner = owner;
    }

    public void say() {
        System.out.println("Pet sound");
    }

    enum FoodType {
        CHEAP, EXPENSIVE
    }

    public static class Cat extends Pet {
        private String breed;
        private FoodType foodType;

        public Cat(String name, double weight, int age, String owner, String breed, FoodType foodType) {
            super(name, weight, age, owner);
            this.breed = breed;
            this.foodType = foodType;
        }

        @Override
        public void say() {
            System.out.println("Meow!");
        }

        public void walk() {
            System.out.println(name + " is walking with " + owner);
        }

        public void walk(String name) {
            System.out.println(this.name + " is walking with " + name);
        }
    }

    public static class Dog extends Pet {
        private String breed;
        private FoodType foodType;

        public Dog(String name, double weight, int age, String owner, String breed, FoodType foodType) {
            super(name, weight, age, owner);
            this.breed = breed;
            this.foodType = foodType;
        }

        @Override
        public void say() {
            System.out.println("Woof!");
        }

        public void walk() {
            System.out.println(name + " is walking with " + owner);
        }

        public void walk(String name) {
            System.out.println(this.name + " is walking with " + name);
        }
    }

    public static class Parrot extends Pet {
        private String country;
        private boolean hasDocuments;

        public Parrot(String name, double weight, int age, String owner, String country, boolean hasDocuments) {
            super(name, weight, age, owner);
            this.country = country;
            this.hasDocuments = hasDocuments;
        }

        @Override
        public void say() {
            System.out.println("Parrot sound");
        }

        public void fly() {
            Random random = new Random();
            int minutes = 1 + random.nextInt(60);
            System.out.println(name + " flew away but promises to return in " + minutes + " minutes.");
        }
    }

    public static void main(String[] args) {
        List<Pet> pets = new ArrayList<>();
        pets.add(new Cat("Tom", 5, 3, "Alice", "Siamese", FoodType.CHEAP));
        pets.add(new Dog("Rex", 10, 4, "Bob", "Labrador", FoodType.EXPENSIVE));
        pets.add(new Parrot("Polly", 0.5, 2, "Charlie", "Brazil", true));

        for (Pet pet : pets) {
            pet.say();
            if (pet instanceof Cat cat) {
                cat.walk();
                cat.walk("Jane");
            } else if (pet instanceof Dog dog) {
                dog.walk();
                dog.walk("John");
            } else if (pet instanceof Parrot parrot) {
                parrot.fly();
            }
        }
    }
}
