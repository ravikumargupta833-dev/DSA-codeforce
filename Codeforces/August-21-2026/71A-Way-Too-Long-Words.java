import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        while (n-- > 0) {
            String word = sc.next();

            if (word.length() > 10) {
                System.out.println(
                    word.charAt(0) +
                    String.valueOf(word.length() - 2) +
                    word.charAt(word.length() - 1)
                );
            } else {
                System.out.println(word);
            }
        }
    }
}
