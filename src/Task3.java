@FunctionalInterface
interface Printable {
    void print();
}

class PrinterTest {
    public static void main(String[] args) {
        Printable printable = () -> System.out.println("Это текст из лямбда-выражения!");

        executePrintable(printable);
    }

    public static void executePrintable(Printable printable) {
        printable.print();
    }
}