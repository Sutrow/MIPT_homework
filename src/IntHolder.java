public class IntHolder {
    private int value;

    // Конструктор
    public IntHolder(int value) {
        this.value = value;
    }

    // Статический метод инициализации
    public static IntHolder of(int value) {
        return new IntHolder(value);
    }

    // Методы для арифметических операций
    public IntHolder add(IntHolder other) {
        return new IntHolder(this.value + other.value);
    }

    public IntHolder subtract(IntHolder other) {
        return new IntHolder(this.value - other.value);
    }

    public IntHolder multiply(IntHolder other) {
        return new IntHolder(this.value * other.value);
    }

    public IntHolder divide(IntHolder other) {
        if (other.value == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return new IntHolder(this.value / other.value);
    }

    public IntHolder remainder(IntHolder other) {
        return new IntHolder(this.value % other.value);
    }

    // Метод для обмена значениями двух объектов
    public static void swap(IntHolder i, IntHolder j) {
        int temp = i.value;
        i.value = j.value;
        j.value = temp;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    // Пример использования
    public static void main(String[] args) {
        IntHolder i1 = IntHolder.of(10);
        IntHolder i2 = IntHolder.of(5);

        System.out.println(i1.add(i2)); // 15
        System.out.println(i1.subtract(i2)); // 5
        System.out.println(i1.multiply(i2)); // 50
        System.out.println(i1.divide(i2)); // 2
        System.out.println(i1.remainder(i2)); // 0

        swap(i1, i2);
        System.out.println(i1); // 5
        System.out.println(i2); // 10
    }
}
