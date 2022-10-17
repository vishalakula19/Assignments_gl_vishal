import java.util.Scanner;

public class Question4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Base: ");
        int X = sc.nextInt();
        System.out.println("Enter Power");
        int N = sc.nextInt();
        System.out.println(pow(X, N));
    }

    static int pow(int x, int n) {
        if (n == 1) {
            return x;
        } else if (n % 2 == 0) {
            int temp = pow(x, n / 2);
            return temp * temp;
        } else {
            return pow(x, n - 1) * x;
        }

    }
}
