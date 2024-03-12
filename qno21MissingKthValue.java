// Given sorted array of even order in ascending order with no gaps and an integer K, find the missing Kth value 
// from provided Array. (Input ;- 2,6,18,22 k=2 output - 8). Same question with array of numbers with no gap and 
// integer k.


// Answer::

public class qno21MissingKthValue {
    public static int findMissingKth(int[] arr, int k) {
        int n = arr.length;
        int expectedDiff = (arr[n - 1] - arr[0]) / (n - 1); // Calculate the expected difference between consecutive elements
        int missingCount = 0;

        for (int i = 1; i < n; i++) {
            int actualDiff = arr[i] - arr[i - 1];
            int numMissing = (actualDiff / expectedDiff) - 1; // Calculate the number of missing elements between arr[i-1] and arr[i]

            if (missingCount + numMissing >= k) {
                // If the missing count plus the missing elements between arr[i-1] and arr[i] is greater than or equal to k,
                // the missing element lies between arr[i-1] and arr[i].
                int diff = k - missingCount;
                return arr[i - 1] + diff * expectedDiff;
            }

            missingCount += numMissing;
        }

        // If k is greater than the total number of missing elements in the array,
        // the missing element lies after the last element of the array.
        return arr[n - 1] + (k - missingCount) * expectedDiff;
    }

    public static void main(String[] args) {
        int[] arr = {2, 6, 18, 22};
        int k = 2;
        System.out.println("Missing Kth value: " + findMissingKth(arr, k));
    }
}
