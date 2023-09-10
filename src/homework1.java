import java.math.BigInteger;
import java.util.Arrays;

public class homework1 {

    public static void main(String[] args) {
        // тут можете тестировать ваш код

        convert(10);
        System.out.println(normalize(721));
        System.out.println(max(10, 12, -14));
        System.out.println(fact(12));
        System.out.println(fact(BigInteger.valueOf(30)));
        multiplTable();
        System.out.println(average(1, 2, 3, 4, 5, 6, 7));
        System.out.println(isMagicSquare(new int[][]{{16, 3, 2, 13}, {5, 10, 11, 8}, {9, 6, 7, 12}, {4, 15, 14, 1}}));
        System.out.println(Arrays.toString(reverse(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(sort(new int[]{2, 1, 45, 34, 12, 2})));
        System.out.println(Arrays.toString(removeExtra(new int[]{2, 1, 45, 2, 34, 1, 12, 2}, 2)));
    }


    // task 1
    static void convert(int arg) {
        String binary = Integer.toBinaryString(arg);
        String octal = Integer.toOctalString(arg);
        String hex = Integer.toHexString(arg);

        System.out.println(binary);
        System.out.println(octal);
        System.out.println(hex);
    }


    // task 2
    static int normalize(int angle) {
        angle = angle % 360;
        if (angle < 0) {
            angle = 360 + angle;
        }
        return angle;
    }


    // task 3
    static int max(int x, int y, int z) {
        int maximum = Math.max(x, Math.max(y, z));
        return maximum;
    }


    // task 4
    static int fact(int n) {
        int res = 1;
        for (int i = 0; i < n; i++) {
            res = res * (n - i);
        }
        return res;
    }

    static int factorial(int n) {
        if (n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }


    // task 5
    static BigInteger fact(BigInteger n) {
        if (n.equals(BigInteger.ONE)) {
            return n;
        }
        return n.multiply(fact(n.subtract(BigInteger.ONE)));
    }


    // task 6
    static void multiplTable() {
        System.out.print("|    ");
        for (int i = 1; i < 11; ++i) {
            System.out.print("|" + String.format("%4s", i));
        }
        System.out.println("|");

        for (int i = 1; i < 11; ++i) {
            System.out.print("|" + String.format("%4s", i));
            for (int j = 1; j < 11; ++j) {
                System.out.print("|" + String.format("%4s", i * j));
            }
            System.out.println("|");
        }
    }


    // task 7
    static int average(int... nums) {
        return Arrays.stream(nums).sum() / nums.length;
    }


    // task 8
    static boolean isMagicSquare(int[][] square) {
        boolean flag = true;
        int equal = 0, diag = 0, current_1, current_2;

        for (int i = 0; i < square[0].length; ++i) {
            equal += square[i][i];
            diag += square[i][square[0].length - i - 1];
        }

        for (int i = 0; i < square.length; ++i) {
            current_1 = 0;
            current_2 = 0;
            for (int j = 0; j < square[0].length; ++j) {
                current_1 += square[i][j];
                current_2 += square[j][i];
            }
            if (current_1 != equal || current_2 != equal) {
                flag = false;
                break;
            }
        }

        if (diag != equal) {
            flag = false;
        }

        return flag;
    }


    // task 9
    static int[] reverse(int[] arr) {
        int[] reverse_array = new int[arr.length];
        for (int i = 0; i < arr.length; ++i) {
            reverse_array[i] = arr[arr.length - i - 1];
        }
        return reverse_array;
    }


    // task 10
    static int[] sort(int[] arr) {
        for (int i = 0; i < arr.length; ++i) {
            for (int j = i + 1; j < arr.length; ++j) {
                if (arr[i] > arr[j]) {
                    swap(arr[i], arr[j] = arr[i]);
                }
            }
        }
        return arr;
    }

    static int swap(int first, int second) {
        return first;
    }


    // task 11
    static int[] removeExtra(int[] arr, int n) {

        int count = 0, current = 0;
        for (int i = 0; i < arr.length; ++i) {
            count += (arr[i] == n) ? 1 : 0;
        }
        int[] array = new int[arr.length - count];

        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] != n) {
                array[current] = arr[i];
                ++current;
            }
        }
        return array;
    }

    static int[] removeExtraAnotherWay(int[] arr, int n) {
        return Arrays.stream(arr).filter(i -> i != n).toArray();
    }
}
