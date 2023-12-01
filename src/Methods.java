public class Methods {
    static boolean equals(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        return s.equalsIgnoreCase(t);
    }

    static String replace(String str, String oldStr, String newStr) {
        if (str == null || oldStr == null || newStr == null) {
            return str;
        }
        return str.replace(oldStr, newStr);
    }

    static String format(String surname, int mark, String subject) {
        return String.format("Студент %s получил %d по %s", surname, mark, subject);
    }

    static boolean isPalindrome(String str) {
        if (str == null) {
            return false;
        }
        str = str.toLowerCase();
        StringBuilder reversedStr = new StringBuilder(str).reverse();
        return str.equals(reversedStr.toString());
    }

    public static void main(String[] args) {
        System.out.println(equals("hello", "HELLO")); // true
        System.out.println(replace("hello world", "world", "universe")); // hello universe
        System.out.println(format("Иванов", 5, "математике")); // Студент Иванов получил 5 по математике
        System.out.println(isPalindrome("level")); // true
        System.out.println(isPalindrome("hello")); // false
    }
}
