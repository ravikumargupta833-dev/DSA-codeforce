import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            int[] a = new int[n];
            int[] b = new int[n];

            for (int i = 0; i < n; i++)
                a[i] = sc.nextInt();

            for (int i = 0; i < n; i++)
                b[i] = sc.nextInt();

            int l = 0, r = n - 1;

            while (a[l] == b[l])
                l++;

            while (a[r] == b[r])
                r--;

            while (l > 0 && b[l - 1] <= b[l])
                l--;

            while (r < n - 1 && b[r] <= b[r + 1])
                r++;

            System.out.println((l + 1) + " " + (r + 1));
        }
    }
}
