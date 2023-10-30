class Main4 {
    public static void main() {
        try {
            String s = null;
            String m = s.toLowerCase();
        } catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        };
    }
}