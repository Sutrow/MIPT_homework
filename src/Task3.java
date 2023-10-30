class Pair<T extends Comparable<T>> {
    private T first;
    private T second;

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getSecond() {
        return second;
    }

    public void setSecond(T second) {
        this.second = second;
    }

    public T min() {
        return (first.compareTo(second) <= 0) ? first : second;
    }

    public T max() {
        return (first.compareTo(second) >= 0) ? first : second;
    }
}

class Main3 {
    public static void main(String[] args) {
        Pair<Integer> intPair = new Pair<>(3, 7);
        assert intPair.min() == 3;
        assert intPair.max() == 7;

        Pair<String> stringPair = new Pair<>("apple", "banana");
        assert "apple".equals(stringPair.min());
        assert "banana".equals(stringPair.max());

        System.out.println("Тесты пройдены успешно!");
    }
}
