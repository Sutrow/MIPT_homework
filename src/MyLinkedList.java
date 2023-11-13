import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class MyLinkedList<E> implements List<E>, Iterable<E> {
  private Node<E> head;
  private Node<E> tail;
  private int size;

  private static class Node<E> {
    E element;
    Node<E> next;
    Node<E> previous;

    Node(E element, Node<E> previous, Node<E> next) {
      this.element = element;
      this.previous = previous;
      this.next = next;
    }
  }

  public MyLinkedList() {
    head = null;
    tail = null;
    size = 0;
  }

  public boolean add(E element) {
    addLast(element);
    return false;
  }

  private void addLast(E element) {
    Node<E> newNode = new Node<>(element, tail, null);
    if (tail != null) {
      tail.next = newNode;
    } else {
      head = newNode;
    }
    tail = newNode;
    size++;
  }

  // Insert at the head
  public void insertHead(E element) {
    Node<E> newNode = new Node<>(element, null, head);
    if (head != null) {
      head.previous = newNode;
    } else {
      tail = newNode;
    }
    head = newNode;
    size++;
  }

  public void add(int index, E element) {
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException();
    }
    if (index == size) {
      addLast(element);
    } else if (index == 0) {
      insertHead(element);
    } else {
      Node<E> current = getNode(index);
      Node<E> newNode = new Node<>(element, current.previous, current);
      if (current.previous != null) {
        current.previous.next = newNode;
      }
      current.previous = newNode;
      size++;
    }
  }

  public E get(int index) {
    Node<E> node = getNode(index);
    return node.element;
  }

  private Node<E> getNode(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }
    Node<E> current;
    if (index < (size >> 1)) {
      current = head;
      for (int i = 0; i < index; i++) {
        current = current.next;
      }
    } else {
      current = tail;
      for (int i = size - 1; i > index; i--) {
        current = current.previous;
      }
    }
    return current;
  }

  public E remove(int index) {
    Node<E> nodeToRemove = getNode(index);
    E element = nodeToRemove.element;
    Node<E> next = nodeToRemove.next;
    Node<E> previous = nodeToRemove.previous;

    if (previous == null) {
      head = next;
    } else {
      previous.next = next;
      nodeToRemove.previous = null;
    }

    if (next == null) {
      tail = previous;
    } else {
      next.previous = previous;
      nodeToRemove.next = null;
    }

    nodeToRemove.element = null;
    size--;
    return element;
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public E getFirst() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }
    return head.element;
  }

  public E getLast() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }
    return tail.element;
  }

  public void clear() {
    Node<E> x = head;
    while (x != null) {
      Node<E> next = x.next;
      x.element = null;
      x.next = null;
      x.previous = null;
      x = next;
    }
    head = tail = null;
    size = 0;
  }

  public Iterator<E> iterator() {
    return new MyIterator<>(this);
  }

  public void printList() {
    for (Node<E> x = head; x != null; x = x.next) {
      System.out.print(x.element + " ");
    }
    System.out.println();
  }
}
