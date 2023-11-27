import java.util.HashSet;
import java.util.Set;

public class SetOperations {

  public static <E> Set<E> union(Set<? extends E> s1, Set<? extends E> s2) {
    Set<E> result = new HashSet<>(s1);
    result.addAll(s2);
    return result;
  }

  public static <E> Set<E> intersection(Set<? extends E> s1, Set<? extends E> s2) {
    Set<E> result = new HashSet<>(s1);
    result.retainAll(s2);
    return result;
  }

  public static <E> Set<E> difference(Set<? extends E> s1, Set<? extends E> s2) {
    Set<E> result = new HashSet<>(s1);
    result.removeAll(s2);
    return result;
  }

  public static <E> Set<E> symmetricDifference(Set<? extends E> s1, Set<? extends E> s2) {
    Set<E> result = union(s1, s2);
    Set<E> intersection = intersection(s1, s2);
    result.removeAll(intersection);
    return result;
  }

  public static void main(String[] args) {
    Set<Integer> set1 = new HashSet<>();
    set1.add(1);
    set1.add(2);
    set1.add(3);

    Set<Integer> set2 = new HashSet<>();
    set2.add(2);
    set2.add(3);
    set2.add(4);

    System.out.println("Union: " + union(set1, set2));
    System.out.println("Intersection: " + intersection(set1, set2));
    System.out.println("Difference: " + difference(set1, set2));
    System.out.println("Symmetric Difference: " + symmetricDifference(set1, set2));
  }
}
