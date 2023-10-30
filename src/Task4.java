import java.util.function.Function;

class Main {
    public static void main() {
        Function<Integer, String> lambda = (Integer number) -> {
            if (number == 0)
                return "Ноль";
            if (number > 0)
                return "Положительное число";

            return "Отрицательное число";
        };
    }
}