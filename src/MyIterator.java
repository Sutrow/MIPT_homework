import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyIterator<E> implements Iterator<E> {
  private MyLinkedList.Node<E> next;

  public MyIterator(MyLinkedList<E> list) {
    next = list.head;
  }

  @Override
  public boolean hasNext() {
    return next != null;
  }

  @Override
  public E next() {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }
    E element = next.element;
    next = next.next;
    return element;
  }
}
