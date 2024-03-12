// 1. Prove that 5* n^2 + 2* n -3 = O(n^2)
public class qno1provethat {
    public static void main(String[] args) {
        int n0 = 1; // Starting value for n
        int c = 6; // Let's choose c = 6
        int n = n0; // Start with n0
        
        while (true) {
            int leftSide = 5 * n * n + 2 * n - 3;
            int rightSide = c * n * n;
            
            // Check if 5 * n^2 + 2 * n - 3 <= c * n^2 for all n >= n0
            if (leftSide > rightSide) {
                System.out.println("Condition violated for n = " + n);
                break; // If condition violated, stop
            }
            
            // Increment n for next iteration
            n++;
        }
        
        System.out.println("Condition holds true for all n >= " + n0);
    }
}
