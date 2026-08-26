import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int q = sc.nextInt();

        while (q-- > 0) {
            int n = sc.nextInt();
            int ones = 0;
            int oddLength = 0;

            for (int i = 0; i < n; i++) {
                String s = sc.next();

                if (s.length() % 2 == 1) {
                    oddLength++;
                }

                for (char c : s.toCharArray()) {
                    if (c == '1') {
                        ones++;
                    }
                }
            }

            int totalLength = 0;
            // Total length parity is enough to determine the parity of zeros.
            // If every string has even length, both zero and one counts must be even.
            // Otherwise, an odd-length string provides a free center position.
            if (oddLength > 0) {
                System.out.println(n);
            } else {
                totalLength = 0;
                // All strings have even length, so totalLength is even.
                // Therefore zeros and ones have the same parity.
                if (ones % 2 == 0) {
                    System.out.println(n);
                } else {
                    System.out.println(n - 1);
                }
            }
        }

        sc.close();
    }
}
