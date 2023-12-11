import java.util.function.BiFunction;
import java.util.function.Function;

public class Task1 {
  public static void main(String[] args) {
    int testValue = 3;
    System.out.println("Умножение " + testValue + " на 2: " + getDoubleFunction().apply(testValue));
  }

  static Function<Integer, Integer> getDoubleFunction() {
    BiFunction<Integer, Integer, Integer> multiplication = (x, y) -> x * y;
    return bind(multiplication, 2);
  }

  static <A, B, C> Function<B, C> bind(BiFunction<A, B, C> fn, A a) {
    return b -> fn.apply(a, b);
  }
}
