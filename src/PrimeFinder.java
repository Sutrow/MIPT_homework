import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

public class PrimeFinder {

  public static List<Integer> findPrimes(int n) {
    Set<Integer> primes = new HashSet<>();
    for (int i = 2; i <= n; i++) {
      primes.add(i);
    }

    for (int i = 2; i * i <= n; i++) {
      if (primes.contains(i)) {
        for (int j = i * i; j <= n; j += i) {
          primes.remove(j);
        }
      }
    }

    return new ArrayList<>(primes);
  }

  public static void main(String[] args) {
    int n = 100;
    List<Integer> primes = findPrimes(n);
    System.out.println("Простые числа до " + n + ": " + primes);
  }
}
