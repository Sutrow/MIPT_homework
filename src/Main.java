sealed class Shape permits Ball, Cylinder, Pyramid {

    private double volume;

    public Shape(double volume) {
        this.volume = volume;
    }

    public double getVolume() {
        return volume;
    }

    public void print() {
        System.out.println("Shape with volume: " + volume);
    }
}

final class Ball extends Shape {

    private double radius;

    public Ball(double radius) {
        super((4.0 / 3) * Math.PI * Math.pow(radius, 3));
        this.radius = radius;
    }

    @Override
    public void print() {
        System.out.println("Ball with radius: " + radius + " and volume: " + getVolume());
    }
}

non-sealed class Cylinder extends Shape {

    private double height;
    private double radius;

    public Cylinder(double height, double radius) {
        super(Math.PI * Math.pow(radius, 2) * height);
        this.height = height;
        this.radius = radius;
    }

    @Override
    public void print() {
        System.out.println("Cylinder with height: " + height + ", radius: " + radius + " and volume: " + getVolume());
    }
}

sealed class Pyramid extends Shape permits ColourPyramid {

    private double height;
    private double area;

    public Pyramid(double height, double area) {
        super(area * height / 3);
        this.height = height;
        this.area = area;
    }

    @Override
    public void print() {
        System.out.println("Pyramid with height: " + height + ", area: " + area + " and volume: " + getVolume());
    }
}

final class ColourPyramid extends Pyramid {

    private String colour;

    public ColourPyramid(double height, double area, String colour) {
        super(height, area);
        this.colour = colour;
    }

    @Override
    public void print() {
        System.out.println("ColourPyramid with colour: " + colour);
        super.print();
    }
}

public class Main {
    public static void main(String[] args) {
        Shape ball = new Ball(3);
        Shape cylinder = new Cylinder(5, 3);
        Shape pyramid = new Pyramid(4, 12);
        Shape colourPyramid = new ColourPyramid(4, 12, "red");

        Shape[] shapes = { ball, cylinder, pyramid, colourPyramid };

        for (Shape shape : shapes) {
            shape.print();
            if (shape instanceof Ball b) {
                System.out.println("Detected a ball with volume: " + b.getVolume());
            } else if (shape instanceof Cylinder c) {
                System.out.println("Detected a cylinder with volume: " + c.getVolume());
            } else if (shape instanceof Pyramid p) {
                System.out.println("Detected a pyramid with volume: " + p.getVolume());
            }
        }
    }
}
