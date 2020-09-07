package fastslowpointers;

public class MiddleOfLinkedList {
    public static ListNode findMiddle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        System.out.println("middle of the linkedList: " + findMiddle(head).value);

        head.next.next.next = new ListNode(4);
        System.out.println("middle of the linkedList: " + findMiddle(head).value);

        head.next.next.next.next = new ListNode(5);
        System.out.println("middle of the linkedList: " + findMiddle(head).value);

        head.next.next.next.next.next = new ListNode(6);
        System.out.println("middle of the linkedList: " + findMiddle(head).value);

        head.next.next.next.next.next.next = new ListNode(7);
        System.out.println("middle of the linkedList: " + findMiddle(head).value);
    }
}
