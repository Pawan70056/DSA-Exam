// Is hashing better than binary search algorithm? Give reason. Define any two collision resolution technique.


// Answer::

// 1. Hashing:
//     i. Strengths:
//         i. Efficient for retrieval operations
//         ii. Suitable for large datasets

//     ii. Weaknesses:
//         i. Not suitable for range queries
//         ii. Collision resolution
    
// 2. Binary Search:
//     i. Strengths:
//         i. Efficient for sorted arrays
//         ii. Preserves order
//     ii. Weaknesses
//         i. Costly for insertion and deletion
//         ii. Not suitable for unsorted data

// #Collision Resolution Techniques:
// 1. Chaining:
//     i. In chaining, each bucket in the hash table contains a linked list of elements that hash to the same index.
//     ii. When a collision occurs, the new element is appended to the linked list at the corresponding bucket.
//     iii. Chaining is relatively simple to implement and works well for a wide range of hash functions.

// 2. Open Addressing:
//     i. In open addressing, collisions are resolved by finding an alternative location in the hash table when a 
//         collision occurs.
//     ii. Various methods such as linear probing, quadratic probing, or double hashing can be used to find the next 
//         available slot.
//     iii. Open addressing techniques require careful design to avoid clustering and ensure efficiency.