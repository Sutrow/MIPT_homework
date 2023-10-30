class Tuple<E> {
    private Object[] elements;
    private int size;

    public Tuple(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Вместимость кортежа не может быть отрицательной");
        }
        this.elements = new Object[capacity];
        this.size = 0;
    }

    public E get(int index) {
        if (index < 0 || index >= elements.length) {
            throw new IndexOutOfBoundsException("Индекс вне границ кортежа");
        }
        return (E) elements[index];
    }

    public void add(E el) {
        if (size >= elements.length) {
            throw new IllegalStateException("Кортеж полностью заполнен");
        }
        elements[size++] = el;
    }

    public void add(E el, int index) {
        if (index < 0 || index >= elements.length) {
            throw new IndexOutOfBoundsException("Индекс вне границ кортежа");
        }
        elements[index] = el;
        if (index >= size) {
            size = index + 1;
        }
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс вне границ кортежа");
        }
        elements[index] = null;
        size--;
    }

    public void remove(E el) {
        for (int i = 0; i < size; i++) {
            if (el.equals(elements[i])) {
                elements[i] = null;
                size--;
                return;
            }
        }
        throw new IllegalArgumentException("Элемент не найден в кортеже");
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E orElse(int index, E defaultValue) {
        if (index < 0 || index >= elements.length) {
            throw new IndexOutOfBoundsException("Индекс вне границ кортежа");
        }
        return (elements[index] != null) ? (E) elements[index] : defaultValue;
    }
}

class Main2 {
    public static void main(String[] args) {
        Tuple<String> tuple = new Tuple<>(5);

        assert tuple.isEmpty();

        tuple.add("A");
        tuple.add("B", 1);
        tuple.add("C", 2);
        tuple.add("D", 3);
        tuple.add("E", 4);

        assert "A".equals(tuple.get(0));
        assert "B".equals(tuple.get(1));
        assert "C".equals(tuple.get(2));
        assert "D".equals(tuple.get(3));
        assert "E".equals(tuple.get(4));
        assert "Z".equals(tuple.orElse(6, "Z"));

        tuple.remove(1);
        tuple.remove("C");

        assert tuple.get(1) == null;
        assert tuple.get(2) == null;

        assert !tuple.isEmpty();

        System.out.println("Тесты пройдены успешно!");
    }
}
