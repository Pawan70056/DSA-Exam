public class MasterTheoremSolver {
    public static void main(String[] args) {
        // Test each recursion relation
        System.out.println("Question 2:");
        System.out.println("T(n) = " + solveRecursionQuestion2(16));
        System.out.println("\nQuestion 3:");
        System.out.println("T(n) = " + solveRecursionQuestion3(2));
        System.out.println("\nQuestion 4:");
        System.out.println("T(n) = " + solveRecursionQuestion4(2));
        System.out.println("\nQuestion 5:");
        System.out.println("T(n) = " + solveRecursionQuestion5(3));
    }

    // Master Theorem for each question
    public static double solveRecursionQuestion2(int n) {
        return Math.log(n) / Math.log(2); // O(log n)
    }

    public static double solveRecursionQuestion3(int n) {
        return Math.pow(n, 2); // O(n^2)
    }

    public static double solveRecursionQuestion4(int n) {
        return Math.pow(n, 3); // O(n^3)
    }

    public static double solveRecursionQuestion5(int n) {
        return Math.pow(4, Math.log(n) / Math.log(4)); // O(n^log4 base 4) = O(n^0.5)
    }
}
