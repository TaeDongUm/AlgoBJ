import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long N = scanner.nextLong();
        long ans = 0;

        while (N % 5 != 0) {
            N -= 3;
            ans++;
        }

        if (N < 0) {
            System.out.println(-1);
        } else {
            System.out.println(ans + N / 5);
        }
    }
}