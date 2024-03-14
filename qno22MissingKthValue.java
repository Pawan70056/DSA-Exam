// Find the missing Kth value from provided array in O(n) time complexity.


// Answer::

public class qno22MissingKthValue {
    public static int find(int[] array, int k) {
        int n = array.length;
        int Num = (n + 1) * (n + 2) / 2;
        int Sum = 0;
        for (int num : array) {
            Sum += num;
        }
        int Value = Num - Sum;
        
        return Value;
    }
    
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 6, 7, 8, 9, 10}; 
        int k = 5; 
        
        int m = find(a, k);
        System.out.println("Missing " + k + "th value: " + m);
    }
}
