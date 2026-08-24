// Codeforces: 123A - Prime Permutation
// Rating: 1300
// Topic: Implementation, Number Theory, Strings, DSU
// Link: https://codeforces.com/problemset/problem/123/A

// Concept:
// For every prime p <= n/2, position p must contain the same character
// as every multiple of p. These positions form connected components.
// We use DSU (Disjoint Set Union) to group positions that must contain
// the same character.
//
// Approach:
// 1. Count the frequency of each character.
// 2. Find all primes using the Sieve of Eratosthenes.
// 3. Union each prime p (p <= n/2) with all its multiples.
// 4. Find the largest connected component.
// 5. Assign one character with enough frequency to that component.
// 6. Fill all remaining positions with the remaining characters.
// 7. If no character has enough frequency, print NO.
//
// Time Complexity: O(n log log n + n log n) approximately
// Space Complexity: O(n)

import java.util.*;

public class Main {
    static int[] parent;

    static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            parent[b] = a;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        int n = s.length();

        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);

        if (n >= 0) prime[0] = false;
        if (n >= 1) prime[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = false;
                }
            }
        }

        for (int p = 2; p <= n / 2; p++) {
            if (prime[p]) {
                for (int j = 2 * p; j <= n; j += p) {
                    union(p, j);
                }
            }
        }

        int[] size = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            size[find(i)]++;
        }

        int largestRoot = 1;
        int largestSize = 0;

        for (int i = 1; i <= n; i++) {
            if (size[i] > largestSize) {
                largestSize = size[i];
                largestRoot = i;
            }
        }

        int chosen = -1;
        for (int c = 0; c < 26; c++) {
            if (freq[c] >= largestSize) {
                chosen = c;
                break;
            }
        }

        if (chosen == -1) {
            System.out.println("NO");
            return;
        }

        char[] ans = new char[n];
        Arrays.fill(ans, '?');

        for (int i = 1; i <= n; i++) {
            if (find(i) == largestRoot) {
                ans[i - 1] = (char) ('a' + chosen);
            }
        }

        freq[chosen] -= largestSize;

        int current = 0;
        for (int i = 0; i < n; i++) {
            if (ans[i] == '?') {
                while (current < 26 && freq[current] == 0) {
                    current++;
                }

                ans[i] = (char) ('a' + current);
                freq[current]--;
            }
        }

        System.out.println("YES");
        System.out.println(new String(ans));
    }
}
