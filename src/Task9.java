class Main5 {
    public static void main() {
        try {
            int[] m = new int[2];
            m[8] = 5;
        } catch (NullPointerException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        };
    }
}