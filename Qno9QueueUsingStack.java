import java.util.Stack;

public class Qno9QueueUsingStack<T> {
    private Stack<T> inbox;
    private Stack<T> outbox;

    public Qno9QueueUsingStack() {
        inbox = new Stack<>();
        outbox = new Stack<>();
    }

    public void enqueue(T item) {
        inbox.push(item);
    }

    public T dequeue() {
        if (outbox.isEmpty()) {
            while (!inbox.isEmpty()) {
                outbox.push(inbox.pop());
            }
        }
        return outbox.pop();
    }

    public boolean isEmpty() {
        return inbox.isEmpty() && outbox.isEmpty();
    }

    public int size() {
        return inbox.size() + outbox.size();
    }

    public static void main(String[] args) {
        Qno9QueueUsingStack<Integer> queue = new Qno9QueueUsingStack<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue.dequeue()); // Output: 1
        System.out.println(queue.dequeue()); // Output: 2
        System.out.println(queue.dequeue()); // Output: 3
    }
}
