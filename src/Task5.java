import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

class Main5 {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        Function<Integer, Double> squareRootFunction = Math::sqrt;

        List<Double> squareRoots = map(numbers, squareRootFunction);

        System.out.println(squareRoots);

        assert squareRoots.size() == numbers.size();
        for (int i = 0; i < numbers.size(); i++) {
            assert squareRoots.get(i) == Math.sqrt(numbers.get(i));
        }

        System.out.println("Тесты пройдены успешно!");
    }

    public static <T, R> List<R> map(List<T> list, Function<T, R> function) {
        List<R> result = new ArrayList<>(list.size());
        for (T item : list) {
            result.add(function.apply(item));
        }
        return result;
    }
}
