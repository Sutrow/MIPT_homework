import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class MyHashSet<E> implements BaseSet<E>, Iterable<E> {

  private static final int DEFAULT_CAPACITY = 16;
  private static final int MAX_CAPACITY = 1 << 30;
  private static final float LOAD_FACTOR = 0.75f;

  private Node<E>[] table;
  private int size;
  private int threshold;

  public MyHashSet() {
    this.table = new Node[DEFAULT_CAPACITY];
    this.size = 0;
    this.threshold = (int) (DEFAULT_CAPACITY * LOAD_FACTOR);
  }

  private static int hash(Object key) {
    int h;
    return key == null ? 0 : (h = key.hashCode()) ^ (h >>> 16);
  }

  private void resize() {
    if (table.length == MAX_CAPACITY) {
      threshold = Integer.MAX_VALUE;
      return;
    }

    int newCapacity = table.length * 2;
    Node<E>[] newTable = new Node[newCapacity];
    for (Node<E> e : table) {
      while (e != null) {
        Node<E> next = e.next;
        int i = indexFor(e.hash, newCapacity);
        e.next = newTable[i];
        newTable[i] = e;
        e = next;
      }
    }
    table = newTable;
    threshold = (int) (newCapacity * LOAD_FACTOR);
  }

  private int indexFor(int hash, int length) {
    return hash & (length - 1);
  }

  @Override
  public void add(E e) {
    if (size >= threshold) {
      resize();
    }
    int hash = hash(e);
    int i = indexFor(hash, table.length);

    for (Node<E> node = table[i]; node != null; node = node.next) {
      if (node.hash == hash && Objects.equals(e, node.key)) {
        return;
      }
    }

    Node<E> newNode = new Node<>(hash, e, table[i]);
    table[i] = newNode;
    size++;
  }

  @Override
  public void remove(Object o) {
    int hash = hash(o);
    int i = indexFor(hash, table.length);

    Node<E> prev = null;
    Node<E> node = table[i];

    while (node != null) {
      Node<E> next = node.next;
      if (node.hash == hash && Objects.equals(o, node.key)) {
        if (prev == null) {
          table[i] = next;
        } else {
          prev.next = next;
        }
        size--;
        return;
      }
      prev = node;
      node = next;
    }
  }

  @Override
  public void clear() {
    size = 0;
    table = new Node[DEFAULT_CAPACITY];
  }

  @Override
  public boolean contains(Object o) {
    int hash = hash(o);
    int i = indexFor(hash, table.length);
    for (Node<E> node = table[i]; node != null; node = node.next) {
      if (node.hash == hash && Objects.equals(o, node.key)) {
        return true;
      }
    }
    return false;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public Iterator<E> iterator() {
    return new Iterator<E>() {
      private int currentIndex = 0;
      private Node<E> nextNode = null;

      {
        advance();
      }

      private void advance() {
        while (nextNode == null && currentIndex < table.length) {
          nextNode = table[currentIndex++];
        }
        while (nextNode != null && nextNode.key == null) {
          nextNode = nextNode.next;
        }
      }

      @Override
      public boolean hasNext() {
        return nextNode != null;
      }

      @Override
      public E next() {
        if (nextNode == null) {
          throw new NoSuchElementException();
        }
        E key = nextNode.key;
        nextNode = nextNode.next;
        if (nextNode == null) {
          advance();
        }
        return key;
      }
    };
  }

  static class Node<T> {
    final int hash;
    final T key;
    Node<T> next;

    public Node(int hash, T key, Node<T> next) {
      this.hash = hash;
      this.key = key;
      this.next = next;
    }
  }
}

interface BaseSet<E> {
  void add(E e);
  void remove(Object o);
  void clear();
  boolean contains(Object o);
  boolean isEmpty();
  int size();
}
