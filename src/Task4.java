import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Task4 {

  public static <T, R> Optional<R> processElements(
          List<T> elements,
          Predicate<T> predicate,
          Function<T, R> mapper,
          BinaryOperator<R> operator) {

    return elements.stream()
            .filter(predicate)
            .map(mapper)
            .reduce(operator);
  }

  public static void main(String[] args) {
    // Пример использования
    List<String> words = List.of("Hello", "World", "Java", "Stream");
    Optional<String> result = processElements(
            words,
            s -> s.length() > 4,
            String::toUpperCase,
            String::concat);

    result.ifPresent(System.out::println);
  }
}
