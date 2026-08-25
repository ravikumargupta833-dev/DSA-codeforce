import java.util.*;

public class Main {
    static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();

            boolean allA = true;
            for (char ch : s.toCharArray()) {
                if (ch != 'a') {
                    allA = false;
                    break;
                }
            }

            if (allA) {
                System.out.println("NO");
            } else {
                String result = "a" + s;

                if (!isPalindrome(result)) {
                    System.out.println("YES");
                    System.out.println(result);
                } else {
                    result = s + "a";
                    System.out.println("YES");
                    System.out.println(result);
                }
            }
        }

        sc.close();
    }
}
