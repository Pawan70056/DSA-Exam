// Find the time complexity on for loops and such.

// Answer::

// Here are the time complexities for common types of for loops and related constructs in Java:
// 1.	Basic For Loop:
//     for (int i = 0; i < n; i++) {
        
//     }
//         •	Time Complexity: O(n)
//         •	Explanation: The loop runs 'n' times, where 'n' is the size of the input.

// 2.	Nested For Loops:
//     for (int i = 0; i < n; i++) {
//         for (int j = 0; j < m; j++) {
//         }
//     }
//         •	Time Complexity: O(n * m)
//         •	Explanation: Nested loops result in a time complexity that is the product of their individual 
//             iterations.

// 3.	While Loop:
//     int i = 0;
//     while (i < n) {
//         i++;
//     }
//         •	Time Complexity: O(n)
//         •	Explanation: Similar to a basic for loop, the while loop runs 'n' times.

// 4.	ForEach Loop:
//     for (int element : array) {
//     }
//         •	Time Complexity: O(n)
//         •	Explanation: The loop iterates over each element in the array or collection, resulting in a time 
//             complexity of O(n), where 'n' is the size of the array or collection.

// 5.	Do-While Loop:
//     int i = 0;
//     do {
//         i++;
//     } while (i < n);
//         •	Time Complexity: O(n)
//         •	Explanation: Similar to a while loop, the do-while loop runs 'n' times.
