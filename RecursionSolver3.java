public class RecursionSolver3 {
    public static void main(String[] args) {
        int n = 3; // Choose any value for n
        double result = solveRecursion(n);
        System.out.println("T(" + n + ") = " + result);
    }

    public static double solveRecursion(int n) {
        // Base case
        if (n <= 1) {
            return n * Math.log(n);
        }
        // Recursive case
        return 3 * solveRecursion(n / 4) + n * Math.log(n);
    }
}
