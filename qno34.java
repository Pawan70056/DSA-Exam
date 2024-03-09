// Discuss the detail about P, np, np-hard, and np-complete problems with example.


// Answer:

// Certainly! Let's discuss P, NP, NP-hard, and NP-complete problems along with examples:

// 1. P (Polynomial Time):

// P refers to the class of decision problems that can be solved in polynomial time by a deterministic Turing 
// machine.
// These are problems for which an algorithm exists that can solve them efficiently, with the time taken by the
//  algorithm growing polynomially with the size of the input.
// Examples of problems in P include sorting algorithms like Merge Sort and Quick Sort, as well as finding the 
// shortest path in a graph using Dijkstra's algorithm.


// 2. NP (Nondeterministic Polynomial Time):

// NP refers to the class of decision problems for which a given solution can be verified as correct in 
// polynomial time by a deterministic Turing machine.
// In other words, if someone claims to have a solution to an NP problem, we can verify its correctness 
// efficiently.
// However, finding a solution for an NP problem is not necessarily easy; it's just that verifying the 
// solution is easy.
// Examples of NP problems include the Traveling Salesman Problem (TSP), the Knapsack Problem, and the 
// Subset Sum Problem.


// 3. NP-Hard (Nondeterministic Polynomial Time Hard):

// NP-hard refers to the class of decision problems that are at least as hard as the hardest problems in NP.
// These problems do not necessarily have solutions that can be verified in polynomial time, but they are 
// at least as hard to solve as NP problems.
// NP-hard problems can be thought of as "as hard as or harder than NP problems," but they may not actually 
// be in NP themselves.
// Examples of NP-hard problems include the Boolean Satisfiability Problem (SAT) and the Traveling Salesman 
// Problem (TSP).


// 4 .NP-Complete (Nondeterministic Polynomial Time Complete):

// NP-complete refers to the class of decision problems that are both in NP and NP-hard.
// These are the hardest problems in NP; they are at least as hard as the hardest problems in NP, and any 
// problem in NP can be reduced to an NP-complete problem in polynomial time.
// If an efficient algorithm exists for any NP-complete problem, then an efficient algorithm exists for all 
// problems in NP (P = NP).
// Examples of NP-complete problems include the Boolean Satisfiability Problem (SAT), the Traveling Salesman 
// Problem (TSP), and the Knapsack Problem.