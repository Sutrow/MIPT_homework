import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoubleIterator<T> implements Iterator<T> {
  private Iterator<T> first;
  private Iterator<T> second;

  public DoubleIterator(Iterator<T> first, Iterator<T> second) {
    this.first = first;
    this.second = second;
  }

  @Override
  public boolean hasNext() {
    // Есть следующий элемент, если:
    // 1. Первый итератор имеет следующий элемент.
    // 2. Второй итератор имеет следующий элемент, если первый уже исчерпан.
    return first.hasNext() || second.hasNext();
  }

  @Override
  public T next() {
    // Возвращает следующий элемент из первого итератора, если он доступен.
    // В противном случае - из второго итератора.
    if (first.hasNext()) {
      return first.next();
    } else if (second.hasNext()) {
      return second.next();
    } else {
      throw new NoSuchElementException("No more elements to iterate over");
    }
  }
}
