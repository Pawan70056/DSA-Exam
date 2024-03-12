// t(n) = 2T (n/2) + n

public class qno3 {
    public static void main(String[] args) {
        int n = 2; // Choose any value for n
        long result = num(n);
        System.out.println("T(" + n + ") = " + result);
    }

    public static long num(int n) {
        // Base case
        if (n <= 1) {
            return 0;
        }
        // Recursive case
        return 2 * num(n / 2) + n;
    }
}
