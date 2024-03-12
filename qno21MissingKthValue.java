// Given sorted array of even order in ascending order with no gaps and an integer K, find the missing Kth value 
// from provided Array. (Input ;- 2,6,18,22 k=2 output - 8). Same question with array of numbers with no gap and 
// integer k.


// Answer::

public class qno21MissingKthValue {
    public static int findMissingKth(int[] arr, int k) {
        int n = arr.length;
        int expectedDiff = (arr[n - 1] - arr[0]) / (n - 1); 
        int missingCount = 0;

        for (int i = 1; i < n; i++) {
            int actualDiff = arr[i] - arr[i - 1];
            int numMissing = (actualDiff / expectedDiff) - 1; 
            if (missingCount + numMissing >= k) {
                int diff = k - missingCount;
                return arr[i - 1] + diff * expectedDiff;
            }

            missingCount += numMissing;
        }
        
        return arr[n - 1] + (k - missingCount) * expectedDiff;
    }

    public static void main(String[] args) {
        int[] arr = {2, 6, 18, 22};
        int k = 2;
        System.out.println("Missing Kth value: " + findMissingKth(arr, k));
    }
}
