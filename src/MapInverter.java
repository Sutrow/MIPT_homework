import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class MapInverter {

  public static <K, V> Map<V, Collection<K>> inverse(Map<? extends K, ? extends V> map) {
    Map<V, Collection<K>> inverseMap = new HashMap<>();

    for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
      K key = entry.getKey();
      V value = entry.getValue();

      inverseMap.computeIfAbsent(value, k -> new HashSet<>()).add(key);
    }

    return inverseMap;
  }

  public static void main(String[] args) {
    Map<Integer, String> map = new HashMap<>();
    map.put(1, "A");
    map.put(2, "B");
    map.put(3, "A");

    System.out.println("Original map: " + map);
    Map<String, Collection<Integer>> invertedMap = inverse(map);
    System.out.println("Inverted map: " + invertedMap);
  }
}
