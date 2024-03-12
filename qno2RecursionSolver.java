// Solve the recursion relation T(n)= 16t(n/4) + 5n^3

public class qno2RecursionSolver {
    public static void main(String[] args) {
        int n = 16; // Choose any value for n
        long result = solveRecursion(n);
        System.out.println("T(" + n + ") = " + result);
    }

    public static long solveRecursion(int n) {
        if (n <= 1) {
            return 0;
        }
        return 16 * solveRecursion(n / 4) + 5 * (long)Math.pow(n, 3);
    }
}
