import java.util.Scanner;

public class PalindromeRecursive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string to check for palindrome: ");
        String st = sc.nextLine();
        System.out.println(checkPalindrome(st, 0, st.length() - 1));

    }

    static boolean checkPalindrome(String st, int left, int right) {
        if (left == right) {
            return true;
        }
        if (st.charAt(left) != st.charAt(right)) {
            return false;
        }
        return checkPalindrome(st, left + 1, right - 1);
    }
}
