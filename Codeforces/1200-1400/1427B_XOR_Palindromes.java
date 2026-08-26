import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            String s = sc.next();

            int score = 0;
            int gaps = 0;

            // Count current score and gaps of L's between W's
            int i = 0;

            while (i < n) {
                if (s.charAt(i) == 'W') {
                    score++;
                    if (i > 0 && s.charAt(i - 1) == 'W') {
                        score++;
                    }
                    i++;
                } else {
                    int j = i;

                    while (j < n && s.charAt(j) == 'L') {
                        j++;
                    }

                    if (i > 0 && j < n) {
                        gaps += j - i;
                    }

                    i = j;
                }
            }

            // No W initially
            if (score == 0) {
                score = Math.min(k, n) * 2 - 1;
                System.out.println(Math.max(0, score));
                continue;
            }

            // Fill internal gaps first
            List<Integer> gapList = new ArrayList<>();

            i = 0;
            while (i < n) {
                if (s.charAt(i) == 'L') {
                    int j = i;
                    while (j < n && s.charAt(j) == 'L') {
                        j++;
                    }

                    if (i > 0 && j < n) {
                        gapList.add(j - i);
                    }

                    i = j;
                } else {
                    i++;
                }
            }

            Collections.sort(gapList);

            for (int gap : gapList) {
                if (k >= gap) {
                    score += 2 * gap + 1;
                    k -= gap;
                } else {
                    score += 2 * k;
                    k = 0;
                    break;
                }
            }

            // Remaining changes can be used at the ends
            if (k > 0) {
                score += 2 * k;
            }

            System.out.println(Math.min(score, 2 * n - 1));
        }
    }
}
