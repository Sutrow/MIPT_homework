import java.util.Objects;

class Pair1<T extends Comparable<T>> {
    private T min;
    private T max;

    public Pair1(T min, T max) {
        this.min = min;
        this.max = max;
    }

    public T getMin() {
        return min;
    }

    public T getMax() {
        return max;
    }
}

class Main4 {

    public static void main(String[] args) {
        Integer[] intArray = {3, 5, 1, 4, 9, 7};
        Pair1<Integer> intPair = minMax(intArray);
        assert Objects.equals(intPair.getMin(), 1);
        assert Objects.equals(intPair.getMax(), 9);

        String[] strArray = {"apple", "banana", "cherry", "date"};
        Pair1<String> strPair = minMax(strArray);
        assert "apple".equals(strPair.getMin());
        assert "date".equals(strPair.getMax());

        System.out.println("Тесты пройдены успешно!");
    }

    public static <T extends Comparable<T>> Pair1<T> minMax(T[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Массив не может быть null или пустым");
        }

        T min = arr[0];
        T max = arr[0];
        for (T t : arr) {
            if (t.compareTo(min) < 0) min = t;
            if (t.compareTo(max) > 0) max = t;
        }

        return new Pair1<>(min, max);
    }
}