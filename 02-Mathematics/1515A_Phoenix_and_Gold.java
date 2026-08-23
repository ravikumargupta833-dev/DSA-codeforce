// Codeforces: 1515A - Phoenix and Gold
// Rating: 800
// Topic: Constructive Algorithms, Greedy, Math
// Link: https://codeforces.com/problemset/problem/1515/A

// Concept:
// Rearrange the weights so that no prefix sum is exactly x.
//
// Approach:
// 1. Calculate the total sum.
// 2. If total == x, the final prefix sum will always be x, so answer NO.
// 3. Otherwise, sort the weights.
// 4. Build the prefix sum from left to right.
// 5. If adding the current weight makes the sum exactly x,
//    swap it with the next weight.
// 6. Print the resulting arrangement.
//
// Time Complexity: O(n log n)
// Space Complexity: O(n)

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int x = sc.nextInt();

            int[] a = new int[n];
            int total = 0;

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                total += a[i];
            }

            if (total == x) {
                System.out.println("NO");
                continue;
            }

            Arrays.sort(a);

            int sum = 0;

            for (int i = 0; i < n - 1; i++) {
                if (sum + a[i] == x) {
                    int temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                }
                sum += a[i];
            }

            System.out.println("YES");

            for (int i = 0; i < n; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
        }
    }
}
