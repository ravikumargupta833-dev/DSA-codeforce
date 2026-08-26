import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();

            int mismatch = 0;

            for (int i = 0; i < n / 2; i++) {
                if (s.charAt(i) != s.charAt(n - 1 - i)) {
                    mismatch++;
                }
            }

            StringBuilder ans = new StringBuilder();

            for (int x = 0; x <= n; x++) {
                boolean possible;

                if (x < mismatch) {
                    possible = false;
                } else if (n % 2 == 1) {
                    possible = true;
                } else {
                    possible = (x - mismatch) % 2 == 0;
                }

                ans.append(possible ? '1' : '0');
            }

            System.out.println(ans);
        }
    }
}
