public class RecursionSolver2 {
    public static void main(String[] args) {
        int n = 16; // Choose any value for n
        double result = solveRecursion(n);
        System.out.println("T(" + n + ") = " + result);
    }

    public static double solveRecursion(int n) {
        // Base case
        if (n <= 1) {
            return Math.sqrt(n);
        }
        // Recursive case
        return 2 * solveRecursion(n / 4) + Math.sqrt(n);
    }
}
