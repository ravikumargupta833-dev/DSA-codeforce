// Codeforces: 158A - Next Round
// Rating: 800
// Topic: Implementation, Arrays, Conditions
// Link: https://codeforces.com/problemset/problem/158/A

// Concept:
// A participant advances if their score is at least the k-th participant's
// score AND their score is positive.
//
// Approach:
// 1. Read n and k.
// 2. Store all participant scores.
// 3. Use a[k - 1] as the k-th score because arrays are 0-indexed.
// 4. Count every score satisfying a[i] >= a[k - 1] and a[i] > 0.
// 5. Print the count.
//
// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            if (a[i] >= a[k - 1] && a[i] > 0) {
                count++;
            }
        }

        System.out.println(count);
    }
}
