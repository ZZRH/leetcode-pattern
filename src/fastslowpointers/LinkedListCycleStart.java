package fastslowpointers;

import sun.security.util.Length;

public class LinkedListCycleStart {
    public static ListNode findCycleStart(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                int length = calculateLength(slow);
                return findCycleStart(head, length);
            }
        }

        return null;
    }

    private static ListNode findCycleStart(ListNode head, int cycleLength) {
        ListNode pointer1 = head, pointer2 = head;
        for (int i = 0; i < cycleLength; i++) {
            pointer2 = pointer2.next;
        }
        while (pointer1 != pointer2) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }
        return pointer1;
    }

    private static int calculateLength(ListNode start) {
        ListNode runer = start.next;
        int length = 1;
        while (runer != start) {
            length++;
            runer= runer.next;
        }
        return length;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
//        System.out.println("LinkedList cycle length: " + LinkedListCycleStart.findCycleStart(head).value);

        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList cycle length: " + LinkedListCycleStart.findCycleStart(head).value);

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList cycle length: " + LinkedListCycleStart.findCycleStart(head).value);

        head.next.next.next.next.next.next = head;
        System.out.println("LinkedList cycle length: " + LinkedListCycleStart.findCycleStart(head).value);
    }
}
