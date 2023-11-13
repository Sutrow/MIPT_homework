import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MedianSorter {

  public static List<Integer> medianSort(List<Integer> list) {
    if (list.isEmpty()) {
      return list;
    }

    List<Integer> sortedList = new ArrayList<>(list);
    Collections.sort(sortedList);

    int size = sortedList.size();
    double median;
    if (size % 2 == 0) {
      median = ((double) sortedList.get(size / 2 - 1) + sortedList.get(size / 2)) / 2.0;
    } else {
      median = sortedList.get(size / 2);
    }

    Comparator<Integer> comparator = Comparator
            .<Integer, Double>comparing(a -> Math.abs(a - median))
            .thenComparingInt(a -> a);

    Collections.sort(list, comparator);
    return list;
  }

  public static void main(String[] args) {
    List<Integer> exampleList = new ArrayList<>();
    Collections.addAll(exampleList, 1, 3, 5, 7);

    List<Integer> sortedByMedian = medianSort(exampleList);
    System.out.println("Sorted list by median: " + sortedByMedian);
  }
}

