// Explain briefly about divide and conquer approach of algorithm design. Implement quick sort.

// Answer:

// The divide and conquer approach is a fundamental algorithm design paradigm that involves breaking down 
// a problem into smaller subproblems, solving each subproblem recursively, and then combining the solutions 
// to the subproblems to solve the original problem. It follows the following general steps:

// 1. Divide: Break the problem into smaller, more manageable subproblems.
// 2. Conquer: Recursively solve each subproblem.
// 3. Combine: Merge the solutions of the subproblems to solve the original problem.

public class qno38QuickSort {
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};
        int n = arr.length;
        quickSort(arr, 0, n - 1);
        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
