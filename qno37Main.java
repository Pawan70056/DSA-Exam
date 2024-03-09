// Implement Fizz-buzz multithreaded algorithm.

// Answer::

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.function.IntConsumer;

class FizzBuzz {
    private int n;
    private volatile int current = 1;
    private final CyclicBarrier barrier = new CyclicBarrier(4);

    public FizzBuzz(int n) {
        this.n = n;
    }

    public void fizz(Runnable printFizz) throws InterruptedException, BrokenBarrierException {
        while (true) {
            if (current > n) break;
            if (current % 3 == 0 && current % 5 != 0) {
                printFizz.run();
                current++;
            }
            try {
                barrier.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    public void buzz(Runnable printBuzz) throws InterruptedException, BrokenBarrierException {
        while (true) {
            if (current > n) break;
            if (current % 3 != 0 && current % 5 == 0) {
                printBuzz.run();
                current++;
            }
            try {
                barrier.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException, BrokenBarrierException {
        while (true) {
            if (current > n) break;
            if (current % 3 == 0 && current % 5 == 0) {
                printFizzBuzz.run();
                current++;
            }
            try {
                barrier.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    public void number(IntConsumer printNumber) throws InterruptedException, BrokenBarrierException {
        while (true) {
            if (current > n) break;
            if (current % 3 != 0 && current % 5 != 0) {
                printNumber.accept(current);
                current++;
            }
            try {
                barrier.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}

public class qno37Main {
    public static void main(String[] args) {
        int n = 15;
        FizzBuzz fizzBuzz = new FizzBuzz(n);

        Thread fizzThread = new Thread(() -> {
            try {
                fizzBuzz.fizz(() -> System.out.print("Fizz, "));
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        });

        Thread buzzThread = new Thread(() -> {
            try {
                fizzBuzz.buzz(() -> System.out.print("Buzz, "));
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        });

        Thread fizzBuzzThread = new Thread(() -> {
            try {
                fizzBuzz.fizzbuzz(() -> System.out.print("FizzBuzz, "));
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        });

        Thread numberThread = new Thread(() -> {
            try {
                fizzBuzz.number(System.out::print);
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        });

        fizzThread.start();
        buzzThread.start();
        fizzBuzzThread.start();
        numberThread.start();

        try {
            fizzThread.join();
            buzzThread.join();
            fizzBuzzThread.join();
            numberThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
