import java.util.Scanner;

public class Question3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array size: ");
        int n = sc.nextInt();
        System.out.println("Enter array elements: ");
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter Target: ");
        int target = sc.nextInt();
        System.out.println(getTargetIndex(arr, n, target));

    }

    static String getTargetIndex(int[] arr, int length, int target) {
        int left = 0;
        int right = length - 1;

        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target) {
                return "[" + left + ", " + right + "]";
            } else if (sum > target) {
                right--;
            } else if (sum < target) {
                left++;
            }

        }
        return "[]";
    }
}
