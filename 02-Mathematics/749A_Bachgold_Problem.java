import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int count = n / 2;

        System.out.println(count);

        for (int i = 0; i < count; i++) {
            if (n % 2 == 1 && i == count - 1) {
                System.out.print(3);
            } else {
                System.out.print(2);
            }

            if (i < count - 1) {
                System.out.print(" ");
            }
        }

        System.out.println();
    }
}
