// Find the missing Kth value from provided array in O(n) time complexity.


// Answer::

public class qno22MissingKthValue {
    public static int findMissingKthValue(int[] array, int k) {
        int n = array.length;
        
        int sumOfFirstN = (n + 1) * (n + 2) / 2;
        int actualSum = 0;
        for (int num : array) {
            actualSum += num;
        }
        int missingValue = sumOfFirstN - actualSum;
        
        return missingValue;
    }
    
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 6, 7, 8, 9, 10}; // Example array
        int k = 5; // Example Kth value
        
        int missingValue = findMissingKthValue(array, k);
        System.out.println("Missing " + k + "th value: " + missingValue);
    }
}
