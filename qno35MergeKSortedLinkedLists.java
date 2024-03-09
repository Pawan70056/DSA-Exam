// Merge Kth sorted linked list into single linked list.Merge Kth sorted linked list into single linked list.

// Answer:

import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class qno35MergeKSortedLinkedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Add the heads of all lists to the min-heap
        for (ListNode node : lists) {
            if (node != null) {
                minHeap.offer(node);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        // Merge the lists
        while (!minHeap.isEmpty()) {
            ListNode minNode = minHeap.poll();
            tail.next = minNode;
            tail = tail.next;

            if (minNode.next != null) {
                minHeap.offer(minNode.next);
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        qno35MergeKSortedLinkedLists solution = new qno35MergeKSortedLinkedLists();

        // Example usage:
        // Define sorted linked lists
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(5);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        ListNode list3 = new ListNode(2);
        list3.next = new ListNode(6);

        // Merge k sorted linked lists
        ListNode result = solution.mergeKLists(new ListNode[] { list1, list2, list3 });

        // Print the merged list
        System.out.println("Merged List:");
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
