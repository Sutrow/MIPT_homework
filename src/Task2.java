import java.util.function.BiFunction;
import java.util.function.Function;

public class Task2 {
  public static void main(String[] args) {
    String testString = "HelloWorld";
    System.out.println("Substring: " + getSubstringFunction().apply(testString));
  }

  static Function<String, String> getSubstringFunction() {
    BiFunction<Integer, String, String> substringFunction = (length, str) -> {
      if (str.length() < length) {
        return str;
      }
      return str.substring(0, length);
    };

    return bind(substringFunction, 5);
  }

  static <A, B, C> Function<B, C> bind(BiFunction<A, B, C> fn, A a) {
    return b -> fn.apply(a, b);
  }
}
