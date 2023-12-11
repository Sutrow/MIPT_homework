import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class WordSpliterator implements Spliterator<String> {
  private String str;
  private int current = 0;

  public WordSpliterator(String str) {
    this.str = str;
  }

  @Override
  public boolean tryAdvance(Consumer<? super String> action) {
    while (current < str.length() && Character.isWhitespace(str.charAt(current))) {
      current++;
    }

    int start = current;
    while (current < str.length() && !Character.isWhitespace(str.charAt(current))) {
      current++;
    }

    if (start < current) {
      action.accept(str.substring(start, current));
      return true;
    }

    return false;
  }

  @Override
  public Spliterator<String> trySplit() {
    return null;
  }

  @Override
  public long estimateSize() {
    return str.length() - current;
  }

  @Override
  public int characteristics() {
    return ORDERED | NONNULL | IMMUTABLE;
  }

  public static void main(String[] args) {
    String text = "This is a sample sentence demonstrating custom Spliterator implementation";
    Stream<String> wordStream = StreamSupport.stream(new WordSpliterator(text), false);
    wordStream.forEach(System.out::println);
  }
}
