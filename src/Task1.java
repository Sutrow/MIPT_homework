import java.util.ArrayList;
import java.util.List;

interface Matrix<T> {
    void add(T element, int row, int col);
    T get(int row, int col);
    void remove(int row, int col);
    int getRowCount();
    int getColCount();
}

class GenericMatrix<T> implements Matrix<T> {
    private List<List<T>> matrix;
    private int rowCount;
    private int colCount;

    // Конструктор по умолчанию
    public GenericMatrix() {
        this.matrix = new ArrayList<>();
        this.rowCount = 0;
        this.colCount = 0;
    }

    // Конструктор на основе другой матрицы
    public GenericMatrix(GenericMatrix<T> other) {
        this.matrix = new ArrayList<>(other.matrix);
        this.rowCount = other.rowCount;
        this.colCount = other.colCount;
    }

    @Override
    public void add(T element, int row, int col) {
        if (row >= rowCount || col >= colCount) {
            throw new IndexOutOfBoundsException("Индекс вне границ матрицы");
        }
        matrix.get(row).set(col, element);
    }

    @Override
    public T get(int row, int col) {
        if (row >= rowCount || col >= colCount) {
            throw new IndexOutOfBoundsException("Индекс вне границ матрицы");
        }
        return matrix.get(row).get(col);
    }

    @Override
    public void remove(int row, int col) {
        if (row >= rowCount || col >= colCount) {
            throw new IndexOutOfBoundsException("Индекс вне границ матрицы");
        }
        matrix.get(row).set(col, null);
    }

    @Override
    public int getRowCount() {
        return rowCount;
    }

    @Override
    public int getColCount() {
        return colCount;
    }

    // Метод для установки размера матрицы
    public void setSize(int rowCount, int colCount) {
        this.rowCount = rowCount;
        this.colCount = colCount;
        matrix = new ArrayList<>(rowCount);
        for (int i = 0; i < rowCount; i++) {
            List<T> row = new ArrayList<>(colCount);
            for (int j = 0; j < colCount; j++) {
                row.add(null);
            }
            matrix.add(row);
        }
    }
}

class Main1 {
    public static void main(String[] args) {
        GenericMatrix<Integer> matrix = new GenericMatrix<>();
        matrix.setSize(3, 3);

        // Добавление элементов
        matrix.add(1, 0, 0);
        matrix.add(2, 0, 1);
        matrix.add(3, 0, 2);
        matrix.add(4, 1, 0);
        matrix.add(5, 1, 1);
        matrix.add(6, 1, 2);
        matrix.add(7, 2, 0);
        matrix.add(8, 2, 1);
        matrix.add(9, 2, 2);

        // Получение и проверка элементов
        assert matrix.get(0, 0) == 1;
        assert matrix.get(0, 1) == 2;
        assert matrix.get(0, 2) == 3;
        assert matrix.get(1, 0) == 4;
        assert matrix.get(1, 1) == 5;
        assert matrix.get(1, 2) == 6;
        assert matrix.get(2, 0) == 7;
        assert matrix.get(2, 1) == 8;
        assert matrix.get(2, 2) == 9;

        // Удаление элементов
        matrix.remove(0, 0);
        matrix.remove(1, 1);
        matrix.remove(2, 2);

        // Проверка удаленных элементов
        assert matrix.get(0, 0) == null;
        assert matrix.get(1, 1) == null;
        assert matrix.get(2, 2) == null;

        System.out.println("Тесты пройдены успешно!");
    }
}
