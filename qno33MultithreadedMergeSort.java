// 33. Design multithreaded algorithm of merge sort.


// Answer::


import java.util.Arrays;

public class qno33MultithreadedMergeSort {
    public static void main(String[] args) {
        int[] arr = { 12, 11, 13, 5, 6, 7 };

        System.out.println("Original Array: " + Arrays.toString(arr));

        mergeSort(arr);

        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }

        int mid = arr.length / 2;

        // Divide the array into two halves
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);

        // Create threads to sort the two halves concurrently
        Thread leftThread = new Thread(() -> mergeSort(left));
        Thread rightThread = new Thread(() -> mergeSort(right));

        leftThread.start();
        rightThread.start();

        try {
            // Wait for both threads to finish
            leftThread.join();
            rightThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Merge the sorted halves
        merge(arr, left, right);
    }

    public static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        // Merge the two sorted arrays
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        // Copy remaining elements of left[] if any
        while (i < left.length) {
            arr[k++] = left[i++];
        }

        // Copy remaining elements of right[] if any
        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }
}
