// Given sorted array of even order in ascending order with no gaps and an integer K, find the missing Kth value 
// from provided Array. (Input ;- 2,6,18,22 k=2 output - 8). Same question with array of numbers with no gap and 
// integer k.


// Answer::

public class qno21MissingKthValue {
    public static int findMissingKth(int[] arr, int k) {
        int n = arr.length;
        int Diff = (arr[n - 1] - arr[0]) / (n - 1); 
        int Count = 0;

        for (int i = 1; i < n; i++) {
            int a = arr[i] - arr[i - 1];
            int num = (a / Diff) - 1; 
            if (Count + num >= k) {
                int diff = k - Count;
                return arr[i - 1] + diff * Diff;
            }

            Count += num;
        }
        
        return arr[n - 1] + (k - Count) * Diff;
    }

    public static void main(String[] args) {
        int[] arr = {2, 6, 18, 22};
        int k = 2;
        System.out.println("Missing Kth value: " + findMissingKth(arr, k));
    }
}
