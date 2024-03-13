// Implement maximum sum sub-array problem.


// Answer:

public class qno28MaximumSumSubarray {
    public static int maxSubArray(int[] a) {
        int maxSum = a[0];
        int Sum = a[0];
        
        for (int i = 1; i < a.length; i++) {
            Sum = Math.max(a[i], Sum + a[i]);
            maxSum = Math.max(maxSum, Sum);
        }
        
        return maxSum;
    }
    
    public static void main(String[] args) {
        int[] a = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println("Maximum sum of subarray: " + maxSubArray(a));
    }
}

