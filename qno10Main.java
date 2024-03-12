class qno10EightQueensProblem {
    final int N = 8; // Size of the chessboard
    int[] board = new int[N]; // Array to represent the positions of queens
    
    // Function to solve the 8 Queens Problem
    void solve() {
        if (placeQueens(0)) {
            printSolution();
        } else {
            System.out.println("Solution does not exist.");
        }
    }
    
    // Recursive function to place queens on the board
    boolean placeQueens(int col) {
        // Base case: all queens are placed
        if (col >= N) {
            return true;
        }
        
        // Try placing queen in each row of the current column
        for (int row = 0; row < N; row++) {
            if (isSafe(row, col)) {
                board[col] = row; // Place queen at (row, col)
                
                // Recur to place queens in subsequent columns
                if (placeQueens(col + 1)) {
                    return true; // If placing queens is successful, return true
                }
                
                // If placing queens fails, backtrack
                board[col] = 0;
            }
        }
        return false; // Return false if no solution exists
    }
    
    // Function to check if placing a queen at position (row, col) is safe
    boolean isSafe(int row, int col) {
        // Check if no queen is in the same row or diagonal
        for (int i = 0; i < col; i++) {
            if (board[i] == row || Math.abs(board[i] - row) == Math.abs(i - col)) {
                return false;
            }
        }
        return true;
    }
    
    // Function to print the solution
    void printSolution() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[j] == i) {
                    System.out.print("Q ");
                } else {
                    System.out.print("_ ");
                }
            }
            System.out.println();
        }
    }
}

// Main class
public class qno10Main {
    public static void main(String[] args) {
        qno10EightQueensProblem problem = new qno10EightQueensProblem();
        problem.solve();
    }
}
