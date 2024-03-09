// Write a java program that demonstrates asynchronous programming with completable future.

// Answer:


import java.util.concurrent.CompletableFuture;

public class qno31CompletableFutureDemo {

    public static void main(String[] args) {
        // Simulating fetching data from two different sources asynchronously
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> fetchData("Source 1"));
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> fetchData("Source 2"));

        // Combining the results of both tasks when they are completed
        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(future1, future2);

        // Handling the combined result
        combinedFuture.thenRun(() -> {
            try {
                String result1 = future1.get();
                String result2 = future2.get();
                System.out.println("Data from Source 1: " + result1);
                System.out.println("Data from Source 2: " + result2);
                System.out.println("Combined Result: " + result1 + " | " + result2);
            } catch (Exception e) {
                System.out.println("Error retrieving data: " + e.getMessage());
            }
        });

        // Program continues to run while tasks are executed asynchronously
        System.out.println("Fetching data from multiple sources asynchronously...");
        // Other tasks can be performed while waiting for the completion of asynchronous tasks
        System.out.println("Performing other tasks while waiting...");

        // Preventing the main thread from exiting before completion of asynchronous tasks
        try {
            Thread.sleep(3000); // Simulating other tasks being performed
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Simulated method to fetch data from a source
    private static String fetchData(String source) {
        // Simulating fetching data from a source
        try {
            Thread.sleep(2000); // Simulating delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Data from " + source;
    }
}
