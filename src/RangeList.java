import java.util.AbstractList;
import java.util.List;

public class RangeList {

  static List<Integer> rangeList(int from, int to) {
    if (from > to) {
      throw new IllegalArgumentException("from cannot be greater than to");
    }
    return new AbstractList<>() {
      @Override
      public Integer get(int index) {
        if (index < 0 || index >= size()) {
          throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        }
        return from + index;
      }

      @Override
      public int size() {
        return to - from;
      }

      @Override
      public int indexOf(Object o) {
        if (!(o instanceof Integer)) {
          return -1;
        }
        int value = (Integer) o;
        return (value >= from && value < to) ? value - from : -1;
      }

      @Override
      public int lastIndexOf(Object o) {
        return indexOf(o);
      }

      @Override
      public boolean contains(Object o) {
        return indexOf(o) != -1;
      }
    };
  }
}
