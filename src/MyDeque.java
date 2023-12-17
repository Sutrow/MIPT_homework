import java.util.NoSuchElementException;
import java.util.Stack;

public class MyDeque<T> {
  private Stack<T> firstStack;
  private Stack<T> secondStack;

  public MyDeque() {
    firstStack = new Stack<>();
    secondStack = new Stack<>();
  }

  public void addFirst(T el) {
    firstStack.push(el);
  }

  public void addLast(T el) {
    secondStack.push(el);
  }

  public T removeFirst() {
    if (isEmpty()) {
      throw new NoSuchElementException("Deque is empty");
    }
    if (firstStack.isEmpty()) {
      transferStacks(secondStack, firstStack);
    }
    return firstStack.pop();
  }

  public T removeLast() {
    if (isEmpty()) {
      throw new NoSuchElementException("Deque is empty");
    }
    if (secondStack.isEmpty()) {
      transferStacks(firstStack, secondStack);
    }
    return secondStack.pop();
  }

  public T peekFirst() {
    if (isEmpty()) {
      throw new NoSuchElementException("Deque is empty");
    }
    if (firstStack.isEmpty()) {
      transferStacks(secondStack, firstStack);
    }
    return firstStack.peek();
  }

  public T peekLast() {
    if (isEmpty()) {
      throw new NoSuchElementException("Deque is empty");
    }
    if (secondStack.isEmpty()) {
      transferStacks(firstStack, secondStack);
    }
    return secondStack.peek();
  }

  public boolean isEmpty() {
    return firstStack.isEmpty() && secondStack.isEmpty();
  }

  public int size() {
    return firstStack.size() + secondStack.size();
  }

  private void transferStacks(Stack<T> fromStack, Stack<T> toStack) {
    while (!fromStack.isEmpty()) {
      toStack.push(fromStack.pop());
    }
  }

  public void printDeque() {
    for (T el : firstStack) {
      System.out.print(el + " ");
    }
    for (int i = secondStack.size() - 1; i >= 0; i--) {
      System.out.print(secondStack.elementAt(i) + " ");
    }
    System.out.println();
  }
}
