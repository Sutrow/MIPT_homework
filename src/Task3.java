import java.util.function.BiFunction;
import java.util.function.Function;

public class Task3 {
  public static void main(String[] args) {
    Function<String, String> sayHello = saySmth("Hello");
    System.out.println(sayHello.apply("Alice"));
  }

  static Function<String, String> saySmth(String greeting) {
    BiFunction<String, String, String> formatter = (greet, name) -> greet + ", " + name + "!";

    return curry(formatter).apply(greeting);
  }

  static <A, B, C> Function<A, Function<B, C>> curry(BiFunction<A, B, C> fn) {
    return a -> b -> fn.apply(a, b);
  }
}
