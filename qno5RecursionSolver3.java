// T(n) = 3T(n/4) + n(logn)

public class qno5RecursionSolver3 {
    public static void main(String[] args) {
        int n = 3; // Choose any value for n
        double result = num(n);
        System.out.println("T(" + n + ") = " + result);
    }

    public static double num(int n) {
        // Base case
        if (n <= 1) {
            return n * Math.log(n);
        }
        // Recursive case
        return 3 * num(n / 4) + n * Math.log(n);
    }
}
