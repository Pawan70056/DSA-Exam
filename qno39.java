// Compare and contrast the time complexities of Merge sort, quick sort and heaps sort.

// Answer::

// Merge Sort, Quick Sort, and Heap Sort are three popular sorting algorithms, each with its own characteristics 
// and time complexities. Here's a comparison of their time complexities:

// 1. Merge Sort:

//      i. Time Complexity:
//         i. Best Case: O(n log n)
//         ii. Average Case: O(n log n)
//         iii. Worst Case: O(n log n)
//     ii. Merge Sort has a consistent time complexity of O(n log n) regardless of the input data, making it a 
//         reliable choice for sorting large datasets.
//     iii. It achieves this time complexity by dividing the array into two halves, recursively sorting each 
//         half, and then merging the sorted halves.


// 2. Quick Sort:

//     i. Time Complexity:
//         i. Best Case: O(n log n)
//         ii. Average Case: O(n log n)
//         iii. Worst Case: O(n^2)
//     ii. Quick Sort typically has an average-case time complexity of O(n log n), making it efficient for most 
//         inputs.
//     iii. However, in the worst-case scenario where the pivot selection is poor (e.g., when the array is 
//         already sorted), Quick Sort can degrade to O(n^2) time complexity.
//     iv. Quick Sort's average-case performance is often better than Merge Sort due to its in-place 
//         partitioning, which reduces the need for additional memory.

// 3. Heap Sort:
    
//     i. Time Complexity:
//         i. Best Case: O(n log n)
//         ii. Average Case: O(n log n)
//         iii. Worst Case: O(n log n)
//     ii. Heap Sort consistently has a time complexity of O(n log n) for all cases, including the best, 
//         average, and worst cases.
//     iii. It achieves this time complexity by first building a max heap from the input array, and then  
//         repeatedly removing the maximum element from the heap and placing it at the end of the array.
//     iv. Although Heap Sort has the same time complexity as Merge Sort, it is generally slower in practice 
//         due to its non-locality of reference, which can result in more cache misses.