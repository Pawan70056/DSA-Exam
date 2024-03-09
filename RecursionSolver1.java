public class RecursionSolver1 {
    public static void main(String[] args) {
        int n = 2; // Choose any value for n
        long result = solveRecursion(n);
        System.out.println("T(" + n + ") = " + result);
    }

    public static long solveRecursion(int n) {
        // Base case
        if (n <= 1) {
            return 0;
        }
        // Recursive case
        return 2 * solveRecursion(n / 2) + n;
    }
}
