public class BackSubstitutionSolver {
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

    // Back Substitution for each question
    public static double solveRecursionQuestion2(int n) {
        return backSubstitutionQuestion2(n, 0); // T(n) = O(n log n)
    }

    public static double backSubstitutionQuestion2(int n, int level) {
        if (n <= 1) {
            return level; // Base case
        }
        return 2 * backSubstitutionQuestion2(n / 2, level + 1) + n; // Recurrence relation
    }

    public static double solveRecursionQuestion3(int n) {
        return backSubstitutionQuestion3(n, 0); // T(n) = O(n^2)
    }

    public static double backSubstitutionQuestion3(int n, int level) {
        if (n <= 1) {
            return level; // Base case
        }
        return 3 * backSubstitutionQuestion3(n / 4, level + 1) + n; // Recurrence relation
    }

    public static double solveRecursionQuestion4(int n) {
        return backSubstitutionQuestion4(n, 0); // T(n) = O(n^3)
    }

    public static double backSubstitutionQuestion4(int n, int level) {
        if (n <= 1) {
            return level; // Base case
        }
        return 5 * backSubstitutionQuestion4(n / 2, level + 1) + n * Math.log(n); // Recurrence relation
    }

    public static double solveRecursionQuestion5(int n) {
        return backSubstitutionQuestion5(n, 0); // T(n) = O(n^(log4 base 4))
    }

    public static double backSubstitutionQuestion5(int n, int level) {
        if (n <= 1) {
            return level; // Base case
        }
        return 3 * backSubstitutionQuestion5(n / 4, level + 1) + n * Math.log(n); // Recurrence relation
    }
}
