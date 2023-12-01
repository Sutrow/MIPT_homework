public final class Point {
    private final double x;
    private final double y;

    // Конструктор без аргументов, создает точку в начале координат
    public Point() {
        this.x = 0;
        this.y = 0;
    }

    // Конструктор с параметрами для создания точки с заданными координатами
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Методы доступа к координатам
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    // Перемещает точку на заданные координаты и возвращает новый объект Point
    public Point translate(double dx, double dy) {
        return new Point(this.x + dx, this.y + dy);
    }

    // Изменяет масштаб по обеим координатам и возвращает новый объект Point
    public Point scale(double factor) {
        return new Point(this.x * factor, this.y * factor);
    }

    @Override
    public String toString() {
        return "Point(" + x + ", " + y + ")";
    }

    public static void main(String[] args) {
        Point p = new Point(3, 4);
        System.out.println(p); // Point(3.0, 4.0)

        p = p.translate(1, 1);
        System.out.println(p); // Point(4.0, 5.0)

        p = p.scale(2);
        System.out.println(p); // Point(8.0, 10.0)
    }
}
