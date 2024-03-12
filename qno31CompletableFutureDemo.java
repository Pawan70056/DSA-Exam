// Write a java program that demonstrates asynchronous programming with completable future.

// Answer:


import java.util.concurrent.CompletableFuture;

public class qno31CompletableFutureDemo {

    public static void main(String[] args) {
        
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> fetchData("Source 1"));
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> fetchData("Source 2"));

        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(future1, future2);

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

        System.out.println("Fetching data from multiple sources asynchronously...");
        System.out.println("Performing other tasks while waiting...");

        try {
            Thread.sleep(3000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static String fetchData(String source) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Data from " + source;
    }
}
