// Discuss union and find algorithm in detail with an example. Write a greedy algorithm for sequencing unit 
// times job with deadline and profit.


// Answer:: 


// Union:

// The union operation in computer science refers to combining multiple sets into a single set, where each 
// element of the resulting set belongs to at least one of the original sets. The union operation is commonly 
// used in data structures like sets and disjoint-set data structures.

// Algorithm for Union:

// 1. Initialize an empty set to store the union of sets.
// 2. Iterate through each element of the input sets.
// 3. For each element, check if it's already present in the union set.
// 4. If not, add it to the union set.
// 5. Continue this process for all input sets.
// 6. Finally, the union set contains all distinct elements from the input sets.

import java.util.*;

class Job {
    char id;
    int deadline, profit;

    Job(char id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class qno14JobSequencing {
    static void sequenceJobs(List<Job> jobs) {
        int maxDeadline = 0;
        for (Job job : jobs) {
            if (job.deadline > maxDeadline) {
                maxDeadline = job.deadline;
            }
        }

        // Sort jobs based on profit in descending order
        Collections.sort(jobs, (a, b) -> b.profit - a.profit);

        // Array to store result (sequence of jobs)
        char[] result = new char[maxDeadline];
        Arrays.fill(result, '-');

        // Boolean array to keep track of slot availability
        boolean[] slots = new boolean[maxDeadline];

        // Fill slots from last deadline
        for (int i = 0; i < jobs.size(); i++) {
            Job currentJob = jobs.get(i);
            for (int j = Math.min(maxDeadline - 1, currentJob.deadline - 1); j >= 0; j--) {
                if (!slots[j]) {
                    result[j] = currentJob.id;
                    slots[j] = true;
                    break;
                }
            }
        }

        // Print the sequence
        System.out.println("Job sequence:");
        for (char jobId : result) {
            System.out.print(jobId + " ");
        }
    }

    public static void main(String[] args) {
        List<Job> jobs = new ArrayList<>();
        jobs.add(new Job('a', 2, 100));
        jobs.add(new Job('b', 1, 19));
        jobs.add(new Job('c', 2, 27));
        jobs.add(new Job('d', 1, 25));
        jobs.add(new Job('e', 3, 15));

        sequenceJobs(jobs);
    }
}
