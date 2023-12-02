import java.util.NoSuchElementException;

interface Task1 {
    int next();
    boolean hasNext();

    static Task1 of(int... values) {
        return new Task1() {
            private int index = 0;

            @Override
            public int next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return values[index++];
            }

            @Override
            public boolean hasNext() {
                return index < values.length;
            }
        };
    }

    static Task1 constant(int value) {
        return new Task1() {
            @Override
            public int next() {
                return value;
            }

            @Override
            public boolean hasNext() {
                return true;
            }
        };
    }
}
