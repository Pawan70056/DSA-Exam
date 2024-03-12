// T(n) = 2t(n/4) + root(n)

public class qno4RecursionSolver2 {
    public static void main(String[] args) {
        int n = 16; // Choose any value for n
        double result = num(n);
        System.out.println("T(" + n + ") = " + result);
    }

    public static double num(int n) {
        // Base case
        if (n <= 1) {
            return Math.sqrt(n);
        }
        // Recursive case
        return 2 * num(n / 4) + Math.sqrt(n);
    }
}
