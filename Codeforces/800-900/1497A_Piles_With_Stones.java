import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int sumX = 0, sumY = 0;

        for (int i = 0; i < n; i++) {
            sumX += sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            sumY += sc.nextInt();
        }

        System.out.println(sumX >= sumY ? "Yes" : "No");
    }
}
