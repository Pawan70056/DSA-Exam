import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue<T> {
    private Queue<T> queue1;
    private Queue<T> queue2;

    public StackUsingQueue() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(T item) {
        queue2.add(item);
        while (!queue1.isEmpty()) {
            queue2.add(queue1.poll());
        }
        Queue<T> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    public T pop() {
        return queue1.poll();
    }

    public T peek() {
        return queue1.peek();
    }

    public boolean isEmpty() {
        return queue1.isEmpty();
    }

    public int size() {
        return queue1.size();
    }

    public static void main(String[] args) {
        StackUsingQueue<Integer> stack = new StackUsingQueue<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop()); // Output: 3
        System.out.println(stack.pop()); // Output: 2
        System.out.println(stack.pop()); // Output: 1
    }
}
