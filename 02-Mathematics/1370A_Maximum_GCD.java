// Codeforces: 1370A - Maximum GCD
// Rating: 800
// Topic: Math, Number Theory, Greedy, Implementation
// Link: https://codeforces.com/problemset/problem/1370/A

// Concept:
// The maximum possible GCD of two distinct integers from 1 to n is n / 2.
//
// Mathematical Observation:
// If gcd(a, b) = g and a < b, then a and b are distinct multiples of g.
// The smallest possible pair is g and 2g, so 2g <= n.
// Therefore, g <= n / 2.
// This bound is achievable using floor(n/2) and 2 * floor(n/2).
// Hence, the answer is simply n / 2.
//
// Time Complexity: O(t)
// Space Complexity: O(1)

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            System.out.println(n / 2);
        }
    }
}
