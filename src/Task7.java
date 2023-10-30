class Main3 {
    public static void main() {
        try {
            int a = 42 / 0;
        } catch (ArithmeticException ex) {
            System.out.println("Делить на ноль нельзя!");
        };
    }
}